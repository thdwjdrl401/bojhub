#include <iostream>
using namespace std;

int main() {
	int A, B, C;
	cin >> A >> B >> C;

	if (A == B && A== C) {
		cout << 10000 + A * 1000;
	}
	else if (A == B || B == C || A == C) {
		if (A == B)
			cout << 1000 + A * 100;
		else if (B == C)
			cout << 1000 + B * 100;
		else
			cout << 1000 + A * 100;
	}
	else {
		if (A > B && A > C) {
			cout << A * 100;
		}
		else if(B > C && B > A) {
			cout << B * 100;
		}
		else if (C > A && C > B) {
			cout << C * 100;

		}
	}
}