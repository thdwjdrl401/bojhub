#include <iostream>
using namespace std;


int main() {
	int N;

	cin >> N;
	
	int* numbers = (int*)calloc(N, sizeof(int));
	int max_number = -1000000;
	int min_number = 1000000;
	for (int i = 0; i < N; i++) {
		if(numbers!=NULL) cin >> numbers[i];
		if (min_number > numbers[i]) min_number = numbers[i];
		if (max_number < numbers[i]) max_number = numbers[i];

	}


		cout << min_number << " " << max_number;

	
}