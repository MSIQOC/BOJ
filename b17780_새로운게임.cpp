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
		int m = (mal[i][0] - 1) * n + (mal[i][1] - 1); //queue 배열의 자리
		if (a[m].front() != i) continue;

		//오른쪽
		if (mal[i][2] == 1) {
			if (mal[i][1] >= n) { //범위 벗어난 경우 (elseif)
				mal[i][2] = 2;  //방향 반대로(elseif)
				if (mal[i][1] - 2 >= 0 && pan[mal[i][0] - 1][mal[i][1] - 2] != 2) //이동할려는 칸이 파랑이 아닐 경우나 범위 벗어나지 않는 경우 (elseif)
					--i;//i를 하나 줄여주고 컨티뉴. (한번더 실행)
			}
			else if (pan[mal[i][0] - 1][mal[i][1]] == 2) { //범위안에서 오른쪽 파란색으로 이동하는 경우 (elseif)
				mal[i][2] = 2;  //방향 반대로(elseif)
				if (mal[i][1] - 2 >= 0 && pan[mal[i][0] - 1][mal[i][1] - 2] != 2) //이동할려는 칸이 파랑이 아니고 범위 벗어나지 않는 경우 (elseif)[
					--i;//i를 하나 줄여주고 컨티뉴. (한번더 실행)
			}
			else if (pan[mal[i][0] - 1][mal[i][1]] == 0) { //흰색으로 이동
				int w = (mal[i][0] - 1) * n + mal[i][1];  //이동할려는 배열 위치
				if (a[w].size() + a[m].size() >= 4) { //이미 있는 말 + 이동할려는 말 >= 4인 경우
					yes = 1;
					break;
				}
				while (!a[m].empty()) {
					a[w].push(a[m].front());
					int l = m;
					++mal[a[m].front()][1];
					a[l].pop();
				} //말들 다 이동
			}
			else if (pan[mal[i][0] - 1][mal[i][1]] == 1) { //빨간색으로 이동
				int w = (mal[i][0] - 1) * n + mal[i][1];  //이동할려는 배열 위치
				if (a[w].size() + a[m].size() >= 4) { //이미 있는 말 + 이동할려는 말 >= 4인 경우
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

		//왼쪽
		else if (mal[i][2] == 2) {
			if (mal[i][1] - 2 < 0) { //범위 벗어난 경우 (elseif)
				mal[i][2] = 1;  //방향 반대로(elseif)
				if (mal[i][1] < n && pan[mal[i][0] - 1][mal[i][1]] != 2) //이동할려는 칸이 파랑이 아닐 경우나 범위 벗어나지 않는 경우 (elseif)
					--i;//i를 하나 줄여주고 컨티뉴. (한번더 실행)
			}
			else if (pan[mal[i][0] - 1][mal[i][1] - 2] == 2) { //범위안에서 왼쪽 파란색으로 이동하는 경우 (elseif)
				mal[i][2] = 1;  //방향 반대로(elseif)
				if (mal[i][1] < n && pan[mal[i][0] - 1][mal[i][1]] != 2) //이동할려는 칸이 파랑이 아니고 범위 벗어나지 않는 경우 (elseif)[
					--i;//i를 하나 줄여주고 컨티뉴. (한번더 실행)
			}
			else if (pan[mal[i][0] - 1][mal[i][1] - 2] == 0) { //흰색으로 이동
				int w = (mal[i][0] - 1) * n + (mal[i][1] - 2);  //이동할려는 배열 위치
				if (a[w].size() + a[m].size() >= 4) { //이미 있는 말 + 이동할려는 말 >= 4인 경우
					yes = 1;
					break;
				}
				while (!a[m].empty()) {
					a[w].push(a[m].front());
					int l = m;
					--mal[a[m].front()][1];
					a[l].pop();
				} //말들 다 이동
			}
			else if (pan[mal[i][0] - 1][mal[i][1] - 2] == 1) { //빨간색으로 이동
				int w = (mal[i][0] - 1) * n + (mal[i][1] - 2);  //이동할려는 배열 위치
				if (a[w].size() + a[m].size() >= 4) { //이미 있는 말 + 이동할려는 말 >= 4인 경우
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

		//위
		else if (mal[i][2] == 3) {
			if (mal[i][0] - 2 < 0) { //범위 벗어난 경우 (elseif)
				mal[i][2] = 4;  //방향 반대로(elseif)
				if (mal[i][0] < n && pan[mal[i][0]][mal[i][1] - 1] != 2) //이동할려는 칸이 파랑이 아닐 경우나 범위 벗어나지 않는 경우 (elseif)
					--i;//i를 하나 줄여주고 컨티뉴. (한번더 실행)
			}
			else if (pan[mal[i][0] - 2][mal[i][1] - 1] == 2) { //범위안에서 위쪽 파란색으로 이동하는 경우 (elseif)
				mal[i][2] = 4;  //방향 반대로(elseif)
				if (mal[i][0] < n && pan[mal[i][0]][mal[i][1] - 1] != 2) //이동할려는 칸이 파랑이 아니고 범위 벗어나지 않는 경우 (elseif)
					--i;//i를 하나 줄여주고 컨티뉴. (한번더 실행)
			}
			else if (pan[mal[i][0] - 2][mal[i][1] - 1] == 0) { //흰색으로 이동
				int w = (mal[i][0] - 2) * n + (mal[i][1] - 1);  //이동할려는 배열 위치
				if (a[w].size() + a[m].size() >= 4) { //이미 있는 말 + 이동할려는 말 >= 4인 경우
					yes = 1;
					break;
				}
				while (!a[m].empty()) {
					a[w].push(a[m].front());
					int l = m;
					--mal[a[m].front()][0];
					a[l].pop();
				} //말들 다 이동
			}
			else if (pan[mal[i][0] - 2][mal[i][1] - 1] == 1) { //빨간색으로 이동
				int w = (mal[i][0] - 2) * n + (mal[i][1] - 1);  //이동할려는 배열 위치
				if (a[w].size() + a[m].size() >= 4) { //이미 있는 말 + 이동할려는 말 >= 4인 경우
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
		
		//아래
		else if (mal[i][2] == 4) {
			if (mal[i][0] >= n) { //범위 벗어난 경우 (elseif)
				mal[i][2] = 3;  //방향 반대로(elseif)
				if (mal[i][0] - 2 >= 0 && pan[mal[i][0] - 2][mal[i][1] - 1] != 2) //이동할려는 칸이 파랑이 아닐 경우나 범위 벗어나지 않는 경우 (elseif)
					--i;//i를 하나 줄여주고 컨티뉴. (한번더 실행)
			}
			else if (pan[mal[i][0]][mal[i][1] - 1] == 2) { //범위안에서 밑의 파란색으로 이동하는 경우 (elseif)
				mal[i][2] = 3;  //방향 반대로(elseif)
				if (mal[i][0] - 2 >= 0 && pan[mal[i][0] - 2][mal[i][1] - 1] != 2) //이동할려는 칸이 파랑이 아니고 범위 벗어나지 않는 경우 (elseif)[
					--i;//i를 하나 줄여주고 컨티뉴. (한번더 실행)
			}
			else if (pan[mal[i][0]][mal[i][1] - 1] == 0) { //흰색으로 이동
				int w = (mal[i][0]) * n + (mal[i][1] - 1);  //이동할려는 배열 위치
				if (a[w].size() + a[m].size() >= 4) { //이미 있는 말 + 이동할려는 말 >= 4인 경우
					yes = 1;
					break;
				}
				while (!a[m].empty()) {
					a[w].push(a[m].front());
					int l = m;
					++mal[a[m].front()][0];
					a[l].pop();
				} //말들 다 이동
			}
			else if (pan[mal[i][0]][mal[i][1] - 1] == 1) { //빨간색으로 이동
				int w = (mal[i][0]) * n + (mal[i][1] - 1);  //이동할려는 배열 위치
				if (a[w].size() + a[m].size() >= 4) { //이미 있는 말 + 이동할려는 말 >= 4인 경우
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
