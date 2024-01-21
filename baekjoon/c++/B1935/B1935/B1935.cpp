#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>
#include <iterator>
#include <stack>
#include <iomanip> // std::fixed와 std::setprecision을 사용하기 위한 헤더
#include <map>

using namespace std;
double calculate(char type, double a, double b) {
    if (type == '*') {
        return a * b;
    }

    if (type == '/') {
        return a / b;
    }

    if (type == '+') {
        return a + b;
    }

    if (type == '-') {
        return a - b;
    }
}

int main()
{
    int cnt;
    cin >> cnt;

    string input;
    cin >> input;
    stack<char> calc;
    // 제시된 계산식을 후입선출로 stack 자료구조에 다시 push
    for (int i = input.size() - 1; i >= 0; i--) {
        calc.push(input[i]);
    }

    map<char, int> alpMap;
    char alp = 65;
    for (int i = 0; i < cnt; i++)
    {
        cin >> alpMap[alp + i];
    }

    stack<double> nums; // 알파벳에 매칭되는 숫자 + 계산된 숫자를 push할거임
    while (!calc.empty()) {
        // 아스키코드값으로 65 ~ 90은 대문자 알파벳, 사칙연산은 42 ~ 47
        if (calc.top() >= 65) { // 알파벳일 경우 stack에 push            
            nums.push(alpMap[calc.top()]); // 알파벳에 매칭되는 값이 입력으로 들어왔음
            calc.pop();
        }
        else { // 사칙연산일 경우, 이전 두 개의 값을 계산하여 stack에 저장
            char type = calc.top();
            calc.pop();

            // 숫자 자료구조에서 값 빼서 사칙연산 수행 (후입선출이라 첨 뺀게 b로 가게)
            double b = nums.top();
            nums.pop();
            double a = nums.top();
            nums.pop();

            double result = calculate(type, a, b);

            // 결과값 다시 자료구조에 push
            nums.push(result);
        }
    }

    cout << fixed << setprecision(2) << nums.top();
}