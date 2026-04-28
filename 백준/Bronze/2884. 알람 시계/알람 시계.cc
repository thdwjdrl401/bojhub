#include <iostream>
using namespace std;

int main() {
	int H, M;
	cin >> H >> M;
	if (M >= 45) {
		M -= 45;
	}
	else {
		M = M - 45 + 60;
		if (H == 0) {
			H = 23;

		}
		else {
			H -= 1;
		}
	}
	cout << H << " ";
	cout << M;

}