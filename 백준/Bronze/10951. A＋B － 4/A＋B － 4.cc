#include <iostream>
using namespace std;


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int A, B, i = 0;

	int a;
	int b;


	while (1) {
		cin >> a >> b;
		if (cin.eof())break;
		else cout << a + b << "\n";
	}
}