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

int main()
{
    //스택이 빠지고 나서 다음 꺼가 닫는게 아니면 +이다.
    string input;
    cin >> input;

    stack<char> open;
    int temp = 1; // 배수. 괄호가 중첩될 때, 안의 연산은 곱셈이 적용되어있다. 2 x (1 + 3)은 2 + 6인 것 처럼..
    int result = 0; // 닫힌괄호를 만날때 마다 더해준다. 

    bool isValid = false;
    for (int i = 0; i < input.size(); i++) {
        if (input[i] == '(') {
            temp *= 2;
            open.push(input[i]);
        }
        else if (input[i] == '[') {
            temp *= 3;
            open.push(input[i]);
        } else if (input[i] == ')') {
            if (open.empty() || open.top() == '[') {
                isValid = true;
                break;
            }
            
            // 이전 괄호가 열린 괄호였다면, 실제 값을 반영, 그게 아니면 배수만 조정해야함 더하는게 아니니까
            if (input[i - 1] == '(') {
                result += temp;
            }
            temp /= 2;
            open.pop();
        } else if (input[i] == ']') {
            if (open.empty() || open.top() == '(') {
                isValid = true;
                break;
            }

            if (input[i - 1] == '[') {
                result += temp;
            }
            temp /= 3;
            open.pop();
        }
    }
    
    if (isValid || !open.empty()) {
        cout << 0;
    } else {
        cout << result;
    }

}