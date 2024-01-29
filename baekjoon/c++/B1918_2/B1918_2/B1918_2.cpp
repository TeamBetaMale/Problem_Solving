#include <iostream>
#include <stack>
#include <string>

using namespace std;

void calculate(stack<char> operations) {
	while (!operations.empty() && operations.top() != '(') {
		if (operations.top() == '*' || operations.top() == '/') {
			cout << operations.top();
			operations.pop();
		}
		else if (operations.top() == '+' || operations.top() == '-') {
		}

	}

}

int main()
{
	string input;
	cin >> input;

	stack<char> operations;
	for (int i = 0; i < input.size(); i++)
	{
		if (input[i] >= 'A' && input[i] <= 'Z') { // 알파벳이면 바로 출력
			cout << input[i];
		}
		else {
			if (input[i] == '(') { // 여는 괄호이면 이면 operations 자료구조에 삽입
				operations.push(input[i]);
			}
			else if (input[i] == ')') { // 닫는 괄호이면 '('이 나올때까지 출력pop... ( A + B * C ) 같은거 있으면 어떡할라고?
				while (!operations.empty() && operations.top() != '(') {
					cout << operations.top();
					operations.pop();
				}
				operations.pop();
			}
			else  if (input[i] == '*' || input[i] == '/') {
				while (!operations.empty() && (operations.top() == '*' || operations.top() == '/')) { // 곱셈, 나눗셈이면 기존에 스택에 있던게 곱셈나눗셈만 아니면 먼저 뱉게함?
					cout << operations.top();
					operations.pop();
				}

				operations.push(input[i]);
			}
			else if (input[i] == '+' || input[i] == '-') { // 우선순위가 젤 낮음, 기존에 스택에 있던거 먼저 배틍ㅁ
				while (!operations.empty() && operations.top() != '(') { 
					cout << operations.top();
					operations.pop();
				}

				operations.push(input[i]);
			}
		}
	}

	while (!operations.empty()) {
		cout << operations.top();
		operations.pop();
	}

}