#include <iostream>
using namespace std;

int main() {
	int H, M, S, h, m;
	cin >> H >> M;
	cin >> S;

	h = S / 60;
	m = S % 60;

	if (M + m < 60) {
		M += m;
		H = (H + h) % 24;
	}
	else {
		M = M +m -60;
		H = (H + h + 1) % 24;
	}
	cout << H << " ";
	cout << M;

}