#include<stdio.h>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> karr;
vector<int> rcs;
int minn = 2147483647;
int main() {
	int n, m, k;
	scanf("%d %d %d", &n, &m, &k);
	int** a = new int *[n+1];
	int** ori = new int* [n + 1];
	for (int i = 0; i < n+1; ++i) {
		a[i] = new int[m + 1];
		ori[i] = new int[m + 1];
	}
	
	for (int i = 1; i < n + 1; ++i) {
		for (int j = 1; j < m + 1; ++j) {
			int aa = 0;
			scanf("%d", &aa);
			a[i][j] = aa;
			ori[i][j] = aa;
		}			
	}
	for (int i = 0; i < k; ++i)
		karr.push_back(i);
	int r = 0, c = 0, s = 0;
	for (int i = 0; i < k; ++i) {
		scanf("%d %d %d", &r, &c, &s);
		rcs.push_back(r);
		rcs.push_back(c);
		rcs.push_back(s);
	}
	do {
		for (int i = 0; i < k; ++i) {
			r = rcs[karr[i] * 3];
			c = rcs[karr[i] * 3 + 1];
			s = rcs[karr[i] * 3 + 2];
			while (s != 0) {
				int ii = r - s;
				int jj = c - s;
				int start = a[ii][jj];
				int prv = a[ii+1][jj];
				for (int i = 0; i < s * 2; ++i) {
					a[ii][jj] = prv;
					++ii;
					if(i!=s*2-1)
						prv = a[ii+1][jj];
				}
				prv = a[ii][jj + 1];
				for (int i = 0; i < s * 2; ++i) {
					a[ii][jj] = prv;
					++jj;
					if (i != s * 2 - 1)
						prv = a[ii][jj + 1];
				}
				prv = a[ii - 1][jj];
				for (int i = 0; i < s * 2; ++i) {
					a[ii][jj] = prv;
					--ii;
					if (i != s * 2 - 1)
						prv = a[ii - 1][jj];
				}
				prv = a[ii][jj - 1];
				for (int i = 0; i < s * 2; ++i) {
					a[ii][jj] = prv;
					--jj;
					if (i != s * 2 - 1)
						prv = a[ii][jj - 1];
				}
				a[ii][jj + 1] = start;
				--s;
			}

		}
		int sum = 0;
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < m + 1; ++j) {
				sum += a[i][j];
			}
			if (minn > sum) minn = sum;
			sum = 0;
		}
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < m + 1; ++j) {
				a[i][j] = ori[i][j];
			}
		}
	} while (next_permutation(karr.begin(), karr.end()));
	printf("%d", minn);

}