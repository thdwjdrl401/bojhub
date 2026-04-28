#include <iostream>
using namespace std;

int main() {
	int A , B;
	cin >> A >> B;
	cout << A * (B%10) << "\n";
	cout << A * (B%100 - B%10)/10 << "\n";
	cout << A * (B - B%100)/100<< "\n";
	cout << A*B << "\n";


}