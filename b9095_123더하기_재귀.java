//
//  Created by MinSeo on 2021/02/20.
//  Copyright �� 2021 MinSeo Shin. All rights reserved.
//
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b9095_123���ϱ�_��� {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer=0;
	static int n=0;
	static void gogo(int sum) {
		if(sum==n) { 
			++answer;
			return;
		}
		else if(sum>n)
			return;
		//������ ������ �� �ڿ� 1�� ���� ��
		gogo(sum+1);
		//��͸� ���������� sum+1���� sum���� �����Եǰ�, sum�� �ٽ� 2�� �����ش�.
		gogo(sum+2);
		//�ٽ� ��͸� �������� sum�� 3�� ���Ѵ�. sum�� n�� ���ų� ���� �� ���� �ݺ�.
		gogo(sum+3);
	}
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			n = Integer.parseInt(br.readLine());
			gogo(0);
			bw.write(answer+"\n");
			answer = 0;
		}
		bw.flush();
	}
}
