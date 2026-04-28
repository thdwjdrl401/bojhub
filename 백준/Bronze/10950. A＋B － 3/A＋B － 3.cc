#include <iostream>
using namespace std;

int main() {
	int T, A, B;
	cin >> T;
	int *a;
	int *b;
	a = (int*)calloc(T, sizeof(int));
	b = (int*)calloc(T, sizeof(int));
	for (int i = 0; i < T; i++) {
		cin >> a[i] >> b[i];

	}
	for (int i = 0; i < T; i++) {
		cout << a[i] + b[i] << "\n";
	}
	free(a);
	free(b);
}