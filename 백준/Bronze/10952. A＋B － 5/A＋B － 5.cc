#include <iostream>
using namespace std;


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int A, B, i = 0;

	int* a;
	int* b;
	a = (int*)calloc(1, sizeof(int));
	b = (int*)calloc(1, sizeof(int));

	while (1) {
		i++;
		a = (int*)realloc(a, sizeof(int) * i);
		b = (int*)realloc(b, sizeof(int) * i);

		cin >> a[i-1] >> b[i-1];
		if (a[i-1] == 0 || b[i-1] == 0)break;
	}
	for (int j = 0; j < i-1; j++) {
		cout << a[j] + b[j] << "\n";
	}

}