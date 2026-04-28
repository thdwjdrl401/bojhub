#include <iostream>
using namespace std;


int main() {
	int N, X;

	cin >> N >> X;
	
	int* numbers = (int*)calloc(N, sizeof(int));
	int number;
	for (int i = 0; i < N; i++) {
		cin >> numbers[i];
		
	}

	for (int i = 0; i < N; i++) {
		if(numbers[i]<X)
		cout << numbers[i] << " ";

	}
}