#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>
#include <iterator>
#include <algorithm>
#include <list>
#include <map>
#include <stack>
using namespace std;

string calculate(stack<string> formula) {
	stack<string> operations;
	stack<string> alp;

	ostringstream oss;
	while (!formula.empty()) {
		string b;
		stack<string> formula2;
		if (formula.top() == ")") {
			formula.pop();

			while (formula.top() != "(") {
				formula2.push(formula.top());
				formula.pop();
			}
			formula.pop();

			b = calculate(formula2);
		}

		stack<string> formula3;
		string operation = formula.top();
		if (formula.top() == "*" || formula.top() == "/") {
			formula3.push(b);
			formula3.push(formula.top());
			formula.pop();

			formula3.push(formula.top());
			formula.pop();

			b += calculate(formula3);
		}
		else if (formula.top() == "+" || formula.top() == "-") {
			b += formula.top();
			formula.pop();
		}
		
		ostringstream a;
		oss << formula.top();
		formula.pop();
		oss << b;
	}
	
	return oss.str();
}

int main()
{
	string input;
	cin >> input;

	stack<string> st;
	// 제시된 계산식을 후입선출로 stack 자료구조에 다시 push
	//for (int i = input.size() - 1; i >= 0; i--) {
	//	string str(1, input[i]);
	//	st.push(str);
	//}

	for (char item : input) {
		string str(1, item);
		st.push(str);
	}

	string result = calculate(st);

	cout << result;
}