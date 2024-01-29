#include <iostream>
#include <sstream>
#include <string>
#include <stack>
#include <vector>
using namespace std;

int main()
{
    ostringstream oss;

    while (true) {
        string input;
        getline(cin, input);

        stack<char>open;
        // stack<char>close;
        if (input == ".") break;

        bool isContinue = false;
        for (char item : input) {
            if (item == '(' || item == '[') {
                open.push(item);
            } else if (item == ')') {
                if (open.empty() || open.top() == '[') {
                    oss << "no" << endl;
                    isContinue = true;
                    break;
                }

                open.pop();
            } else if (item == ']') {
                if (open.empty() || open.top() == '(') {
                    oss << "no" << endl;
                    isContinue = true;
                    break;
                }

                open.pop();
            }
        }        

        if (isContinue) continue;

        if (open.empty()) {
            oss << "yes" << endl;
        } else {
            oss << "no" << endl;
        }
    }

    cout << oss.str();
}
