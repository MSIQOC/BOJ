#include<stdio.h>
#include<vector>
#include<cmath>
#include<queue>
#include<stack>
using namespace std;
int n, k;
int turn = 0;
int** pan;
int** mal;
int yes = 0;
queue<int>* a;
void move() {
	++turn;
	for (int i = 1; i < k + 1; ++i) {
		int m = (mal[i][0] - 1) * n + (mal[i][1] - 1); //queue �迭�� �ڸ�
		if (a[m].front() != i) continue;

		//������
		if (mal[i][2] == 1) {
			if (mal[i][1] >= n) { //���� ��� ��� (elseif)
				mal[i][2] = 2;  //���� �ݴ��(elseif)
				if (mal[i][1] - 2 >= 0 && pan[mal[i][0] - 1][mal[i][1] - 2] != 2) //�̵��ҷ��� ĭ�� �Ķ��� �ƴ� ��쳪 ���� ����� �ʴ� ��� (elseif)
					--i;//i�� �ϳ� �ٿ��ְ� ��Ƽ��. (�ѹ��� ����)
			}
			else if (pan[mal[i][0] - 1][mal[i][1]] == 2) { //�����ȿ��� ������ �Ķ������� �̵��ϴ� ��� (elseif)
				mal[i][2] = 2;  //���� �ݴ��(elseif)
				if (mal[i][1] - 2 >= 0 && pan[mal[i][0] - 1][mal[i][1] - 2] != 2) //�̵��ҷ��� ĭ�� �Ķ��� �ƴϰ� ���� ����� �ʴ� ��� (elseif)[
					--i;//i�� �ϳ� �ٿ��ְ� ��Ƽ��. (�ѹ��� ����)
			}
			else if (pan[mal[i][0] - 1][mal[i][1]] == 0) { //������� �̵�
				int w = (mal[i][0] - 1) * n + mal[i][1];  //�̵��ҷ��� �迭 ��ġ
				if (a[w].size() + a[m].size() >= 4) { //�̹� �ִ� �� + �̵��ҷ��� �� >= 4�� ���
					yes = 1;
					break;
				}
				while (!a[m].empty()) {
					a[w].push(a[m].front());
					int l = m;
					++mal[a[m].front()][1];
					a[l].pop();
				} //���� �� �̵�
			}
			else if (pan[mal[i][0] - 1][mal[i][1]] == 1) { //���������� �̵�
				int w = (mal[i][0] - 1) * n + mal[i][1];  //�̵��ҷ��� �迭 ��ġ
				if (a[w].size() + a[m].size() >= 4) { //�̹� �ִ� �� + �̵��ҷ��� �� >= 4�� ���
					yes = 1;
					break;
				}
				stack<int> imsi;
				while (!a[m].empty()) {
					imsi.push(a[m].front());
					a[m].pop();
				}
				while (!imsi.empty()) {
					a[w].push(imsi.top());
					++mal[imsi.top()][1];
					imsi.pop();
				}
			}
		}

		//����
		else if (mal[i][2] == 2) {
			if (mal[i][1] - 2 < 0) { //���� ��� ��� (elseif)
				mal[i][2] = 1;  //���� �ݴ��(elseif)
				if (mal[i][1] < n && pan[mal[i][0] - 1][mal[i][1]] != 2) //�̵��ҷ��� ĭ�� �Ķ��� �ƴ� ��쳪 ���� ����� �ʴ� ��� (elseif)
					--i;//i�� �ϳ� �ٿ��ְ� ��Ƽ��. (�ѹ��� ����)
			}
			else if (pan[mal[i][0] - 1][mal[i][1] - 2] == 2) { //�����ȿ��� ���� �Ķ������� �̵��ϴ� ��� (elseif)
				mal[i][2] = 1;  //���� �ݴ��(elseif)
				if (mal[i][1] < n && pan[mal[i][0] - 1][mal[i][1]] != 2) //�̵��ҷ��� ĭ�� �Ķ��� �ƴϰ� ���� ����� �ʴ� ��� (elseif)[
					--i;//i�� �ϳ� �ٿ��ְ� ��Ƽ��. (�ѹ��� ����)
			}
			else if (pan[mal[i][0] - 1][mal[i][1] - 2] == 0) { //������� �̵�
				int w = (mal[i][0] - 1) * n + (mal[i][1] - 2);  //�̵��ҷ��� �迭 ��ġ
				if (a[w].size() + a[m].size() >= 4) { //�̹� �ִ� �� + �̵��ҷ��� �� >= 4�� ���
					yes = 1;
					break;
				}
				while (!a[m].empty()) {
					a[w].push(a[m].front());
					int l = m;
					--mal[a[m].front()][1];
					a[l].pop();
				} //���� �� �̵�
			}
			else if (pan[mal[i][0] - 1][mal[i][1] - 2] == 1) { //���������� �̵�
				int w = (mal[i][0] - 1) * n + (mal[i][1] - 2);  //�̵��ҷ��� �迭 ��ġ
				if (a[w].size() + a[m].size() >= 4) { //�̹� �ִ� �� + �̵��ҷ��� �� >= 4�� ���
					yes = 1;
					break;
				}
				stack<int> imsi;
				while (!a[m].empty()) {
					imsi.push(a[m].front());
					a[m].pop();
				}
				while (!imsi.empty()) {
					a[w].push(imsi.top());
					--mal[imsi.top()][1];
					imsi.pop();
				}
			}
		}

		//��
		else if (mal[i][2] == 3) {
			if (mal[i][0] - 2 < 0) { //���� ��� ��� (elseif)
				mal[i][2] = 4;  //���� �ݴ��(elseif)
				if (mal[i][0] < n && pan[mal[i][0]][mal[i][1] - 1] != 2) //�̵��ҷ��� ĭ�� �Ķ��� �ƴ� ��쳪 ���� ����� �ʴ� ��� (elseif)
					--i;//i�� �ϳ� �ٿ��ְ� ��Ƽ��. (�ѹ��� ����)
			}
			else if (pan[mal[i][0] - 2][mal[i][1] - 1] == 2) { //�����ȿ��� ���� �Ķ������� �̵��ϴ� ��� (elseif)
				mal[i][2] = 4;  //���� �ݴ��(elseif)
				if (mal[i][0] < n && pan[mal[i][0]][mal[i][1] - 1] != 2) //�̵��ҷ��� ĭ�� �Ķ��� �ƴϰ� ���� ����� �ʴ� ��� (elseif)
					--i;//i�� �ϳ� �ٿ��ְ� ��Ƽ��. (�ѹ��� ����)
			}
			else if (pan[mal[i][0] - 2][mal[i][1] - 1] == 0) { //������� �̵�
				int w = (mal[i][0] - 2) * n + (mal[i][1] - 1);  //�̵��ҷ��� �迭 ��ġ
				if (a[w].size() + a[m].size() >= 4) { //�̹� �ִ� �� + �̵��ҷ��� �� >= 4�� ���
					yes = 1;
					break;
				}
				while (!a[m].empty()) {
					a[w].push(a[m].front());
					int l = m;
					--mal[a[m].front()][0];
					a[l].pop();
				} //���� �� �̵�
			}
			else if (pan[mal[i][0] - 2][mal[i][1] - 1] == 1) { //���������� �̵�
				int w = (mal[i][0] - 2) * n + (mal[i][1] - 1);  //�̵��ҷ��� �迭 ��ġ
				if (a[w].size() + a[m].size() >= 4) { //�̹� �ִ� �� + �̵��ҷ��� �� >= 4�� ���
					yes = 1;
					break;
				}
				stack<int> imsi;
				while (!a[m].empty()) {
					imsi.push(a[m].front());
					a[m].pop();
				}
				while (!imsi.empty()) {
					a[w].push(imsi.top());
					--mal[imsi.top()][0];
					imsi.pop();
				}
			}
		}
		
		//�Ʒ�
		else if (mal[i][2] == 4) {
			if (mal[i][0] >= n) { //���� ��� ��� (elseif)
				mal[i][2] = 3;  //���� �ݴ��(elseif)
				if (mal[i][0] - 2 >= 0 && pan[mal[i][0] - 2][mal[i][1] - 1] != 2) //�̵��ҷ��� ĭ�� �Ķ��� �ƴ� ��쳪 ���� ����� �ʴ� ��� (elseif)
					--i;//i�� �ϳ� �ٿ��ְ� ��Ƽ��. (�ѹ��� ����)
			}
			else if (pan[mal[i][0]][mal[i][1] - 1] == 2) { //�����ȿ��� ���� �Ķ������� �̵��ϴ� ��� (elseif)
				mal[i][2] = 3;  //���� �ݴ��(elseif)
				if (mal[i][0] - 2 >= 0 && pan[mal[i][0] - 2][mal[i][1] - 1] != 2) //�̵��ҷ��� ĭ�� �Ķ��� �ƴϰ� ���� ����� �ʴ� ��� (elseif)[
					--i;//i�� �ϳ� �ٿ��ְ� ��Ƽ��. (�ѹ��� ����)
			}
			else if (pan[mal[i][0]][mal[i][1] - 1] == 0) { //������� �̵�
				int w = (mal[i][0]) * n + (mal[i][1] - 1);  //�̵��ҷ��� �迭 ��ġ
				if (a[w].size() + a[m].size() >= 4) { //�̹� �ִ� �� + �̵��ҷ��� �� >= 4�� ���
					yes = 1;
					break;
				}
				while (!a[m].empty()) {
					a[w].push(a[m].front());
					int l = m;
					++mal[a[m].front()][0];
					a[l].pop();
				} //���� �� �̵�
			}
			else if (pan[mal[i][0]][mal[i][1] - 1] == 1) { //���������� �̵�
				int w = (mal[i][0]) * n + (mal[i][1] - 1);  //�̵��ҷ��� �迭 ��ġ
				if (a[w].size() + a[m].size() >= 4) { //�̹� �ִ� �� + �̵��ҷ��� �� >= 4�� ���
					yes = 1;
					break;
				}
				stack<int> imsi;
				while (!a[m].empty()) {
					imsi.push(a[m].front());
					a[m].pop();
				}
				while (!imsi.empty()) {
					a[w].push(imsi.top());
					++mal[imsi.top()][0];
					imsi.pop();
				}
			}
		}
	}
}
	int main() {
		scanf("%d %d", &n, &k);
		mal = new int* [k + 1];
		pan = new int* [n];
		a = new queue<int>[n * n];
		for (int i = 0; i < n; ++i)
			pan[i] = new int[n];
		for (int i = 0; i < k + 1; ++i)
			mal[i] = new int[3];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				int in = 0;
				scanf("%d", &in);
				pan[i][j] = in;
			}
		}
		for (int i = 1; i < k + 1; ++i) {
			int in1, in2, in3;
			scanf("%d", &in1);
			mal[i][0] = in1;
			scanf("%d", &in2);
			mal[i][1] = in2;
			scanf("%d", &in3);
			mal[i][2] = in3;
			a[(mal[i][0] - 1) * n + (mal[i][1] - 1)].push(i);
		}
		do {
			move();
		} while (yes != 1 && turn <= 1000);
		if (turn > 1000) printf("%d", -1);
		else printf("%d", turn);
	}