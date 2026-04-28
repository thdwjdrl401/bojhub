#include <iostream>
using namespace std;


int main() {
	
	int* numbers = (int*)calloc(9, sizeof(int));
	int max_number = 0;
	int count;
	for (int i = 0; i < 9; i++) {
		if(numbers!=NULL) cin >> numbers[i];
		if (max_number < numbers[i]) {
			max_number = numbers[i];
			count = i+1;
		}
	}


		cout << max_number<<"\n"<<count;

	
}