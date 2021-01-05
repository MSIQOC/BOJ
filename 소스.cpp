#pragma comment (lib, "ws2_32.lib")
#pragma comment (lib, "wpcap.lib")

#define WIN32
#define WPCAP
#define HAVE_REMOTE

#include <stdio.h>
#include "pcap.h"

struct ip_hdr {
	unsigned char ip_header_len : 4;
	unsigned char ip_version : 4;
	unsigned char ip_tos;
	unsigned short ip_total_length;
	unsigned short ip_id;
	unsigned char ip_frag_offset : 5;
	unsigned char ip_more_fragment : 1;
	unsigned char ip_dont_fragment : 1;
	unsigned char ip_reserved_zero : 1;
	unsigned char ip_frag_offset1;
	unsigned char ip_ttl;
	unsigned char ip_protocol;
	unsigned short ip_checksum;
	unsigned int ip_srcaddr;
	unsigned int ip_destaddr;
};
struct tcp_hdr {
	unsigned short source_port;
	unsigned short dest_port;
	unsigned int sequence;
	unsigned int acknowledge;
	unsigned char ns : 1;
	unsigned char reserved_part1 : 3;
	unsigned char data_offset : 4;
	unsigned char fin : 1;
	unsigned char syn : 1;
	unsigned char rst : 1;
	unsigned char psh : 1;
	unsigned char ack : 1;
	unsigned char urg : 1;
	unsigned char ecn : 1;
	unsigned char cwr : 1;
	unsigned short window;
	unsigned short checksum;
	unsigned short urgent_pointer;
};
int caplen = 0;
void print_raw_packet(const unsigned char* pkt_data, pcap_pkthdr* header) {
	printf("Print Raw Packet : \n");
	for (int i = 0; i < header->caplen; i++) {
		printf("%x ", pkt_data[i]);
	}
	caplen = header->caplen;
}
void print_ether_header(const unsigned char* pkt_data) {
	printf("Print Ether Header : \n");
	printf("dest MAC: ");
	for (int i = 0; i < 6; i++) {
		printf("%x ", pkt_data[i]);
	}
	printf("src MAC: ");
	for (int i = 6; i < 12; i++) {
		printf("%x ", pkt_data[i]);
	}
	printf("protocol type: ");
	for (int i = 12; i < 14; ++i) {
		printf("%x ", pkt_data[i]);
	}
}
int tlength = 0; //represent the sum of length of headers.
void print_ip_header(const unsigned char* pkt_data) {
	printf("Print IP Header : \n");
	struct ip_hdr* ih;
	ih = (struct ip_hdr*) & pkt_data[14]; //from the place where ether_header ended
	printf("ip version : %d\n", ih->ip_version);
	printf("ip header length : %d\n", ih->ip_header_len * 4);
	printf("type of service : %d\n", ih->ip_tos);
	printf("total length : %d\n", ntohs(ih->ip_total_length));
	printf("identification : %x\n", ntohs(ih->ip_id));
	printf("frag offset : %d\n", ih->ip_frag_offset);
	printf("more fragment : %d\n", ih->ip_more_fragment);
	printf("don't fragment : %d\n", ih->ip_dont_fragment);
	printf("reserved zero : %d\n", ih->ip_reserved_zero);
	printf("fragment offset : %d\n", ih->ip_frag_offset1);
	printf("time to live : %x\n", ih->ip_ttl);
	printf("protocol : %d\n", ih->ip_protocol);

	printf("header checksum : %x\n", ntohs(ih->ip_checksum));
	printf("src address : %x\n", ntohl(ih->ip_srcaddr));
	printf("dest address: %x\n", ntohl(ih->ip_destaddr));
	tlength = 14 + ih->ip_header_len * 4;  //tlength is now length of two headers.
}
void print_tcp_header(const unsigned char* pkt_data) {
	printf("Print TCP Header : \n");
	struct tcp_hdr* ih;
	ih = (struct tcp_hdr*) & pkt_data[tlength];
	printf("source port number : %x\n", ntohs(ih->source_port));
	printf("dest port number : %x\n", ntohs(ih->dest_port));
	printf("sequence : %x\n", ntohl(ih->sequence));
	printf("acknowledge number : %x\n", ntohl(ih->acknowledge));
	printf("header length : %d\n", ih->data_offset * 4);
	printf("reserved : %d\n", ih->reserved_part1);
	printf("fin : %d\n", ih->fin);
	printf("syn : %d\n", ih->syn);
	printf("rst : %d\n", ih->rst);
	printf("psh : %d\n", ih->psh);
	printf("ack : %d\n", ih->ack);
	printf("urg : %d\n", ih->urg);
	printf("ecn : %d\n", ih->ecn);
	printf("cwr : %d\n", ih->cwr);
	printf("window : %x\n", ntohs(ih->window));
	printf("TCP checksum : %x\n", ntohs(ih->checksum));
	printf("urgent pointer : %x\n", ntohs(ih->urgent_pointer));
	tlength = tlength + ih->data_offset * 4;
}
void print_data(const unsigned char* pkt_data) {
	printf("Print data : \n");
	for (int i = tlength; i < caplen; i++) {
		printf("%x ", pkt_data[i]);
	}
}
int main() {
	pcap_if_t* alldevs = NULL;
	char errbuf[PCAP_ERRBUF_SIZE];

	// find all network adapters
	if (pcap_findalldevs(&alldevs, errbuf) == -1) {
		printf("dev find failed\n");
		return -1;
	}
	if (alldevs == NULL) {
		printf("no devs found\n");
		return -1;
	}
	// print them
	pcap_if_t* d; int i;
	for (d = alldevs, i = 0; d != NULL; d = d->next) {
		printf("%d-th dev: %s ", ++i, d->name);
		if (d->description)
			printf(" (%s)\n", d->description);
		else
			printf(" (No description available)\n");
	}
	int inum;
	printf("enter the interface number: ");
	scanf_s("%d", &inum);
	for (d = alldevs, i = 0; i < inum - 1; d = d->next, i++); // jump to the inum-th dev

	// open
	pcap_t* fp;
	if ((fp = pcap_open_live(d->name,      // name of the devicee
		65536,                   // capture size
		1,  // promiscuous mode
		20,                    // read timeout
		errbuf
	)) == NULL) {
		printf("pcap open failed\n");
		pcap_freealldevs(alldevs);
		return -1;
	}
	printf("pcap open successful\n");
	struct bpf_program  fcode;
	if (pcap_compile(fp,  // pcap handle
		&fcode,  // compiled rule
		(char*) "port 24344",  // filter rule
		1,            // optimize
		NULL) < 0) {
		printf("pcap compile failed\n");
		pcap_freealldevs(alldevs);
		return -1;
	}
	if (pcap_setfilter(fp, &fcode) < 0) {
		printf("pcap setfilter failed\n");
		pcap_freealldevs(alldevs);
		return -1;
	}
	printf("filter setting successful\n");
	pcap_freealldevs(alldevs); // we don't need this anymore

	struct pcap_pkthdr* header;
	const unsigned char* pkt_data;
	int res;
	int count = 0;
	while ((res = pcap_next_ex(fp, &header, &pkt_data)) >= 0) {// 1 if success
		if (res == 0) continue; // 0 if time-out'
		print_raw_packet(pkt_data, header);
		printf("\n");
		print_ether_header(pkt_data);
		printf("\n");
		print_ip_header(pkt_data);
		printf("\n");
		print_tcp_header(pkt_data);
		printf("\n");
		print_data(pkt_data);
		printf("\n");
		printf("\n");
		++count;
		if (count == 20)
			break;
	}

	return 0;
}
