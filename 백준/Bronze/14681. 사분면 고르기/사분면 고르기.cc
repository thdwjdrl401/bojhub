#include <iostream>
using namespace std;

int main() {
	int A, B;
	cin >> A >> B;
	if (A > 0)
		if (B > 0)
			cout << "1";
		else
			cout << "4";
	else
		if (B > 0)
			cout << "2";
		else
			cout << "3";
}