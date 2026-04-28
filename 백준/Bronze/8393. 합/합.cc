#include <iostream>
using namespace std;

int main() {
	int n, N = 0;
	cin >> n;
	
	for (int i = 1; i <= n; i++) {
		N += i;
	}
	cout << N;
}