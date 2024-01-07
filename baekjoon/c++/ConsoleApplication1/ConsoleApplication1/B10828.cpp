// ProgramSolving.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <iterator> 

using namespace std;

class Stack {
private:
    // vector: 크기를 동적으로 조정가능한 배열 (제네릭 List)
    vector<int> _stack;
    void _push(int x) {

    }

    int _defaultifEmpty() {
        if (_stack.empty()) return -1;

        return 0;
    }
public:
    int Push(int x) {
        _stack.push_back(x);
        return x;
    }

    int Pop() {
        if (_stack.empty()) return -1;

        int result = _stack.back();
        _stack.pop_back();

        return result;
    }

    int Size() {
        return _stack.size();
    }

    int Empty() {
        return _stack.empty() ? 1 : 0;
    }

    int Top() {
        if (_stack.empty()) return -1;

        return _stack.back();
    }
};

int main()
{
    Stack stack;
    int commandcnt;
    cin >> commandcnt;

    cin.ignore(); // 첫 번째 개행 문자를 무시

    vector<int> results;
    ostringstream oss;

    for (int i = 0; i < commandcnt; i++)
    {
        // 버퍼 비우기
        // std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

        string input;
        getline(cin, input);

        // 문자열을 공백을 기준으로 분할하여 배열에 저장
        istringstream iss(input);
        vector<string> command(istream_iterator<string>{iss}, istream_iterator<string>());

        // push로 호출 한 경우
        if (command.size() != 1) {
            stack.Push(stoi(command[1]));
        }
        else {
            if (command[0] == "pop") {
                oss << stack.Pop();
            }
            else if (command[0] == "size") {
                oss << stack.Size();
            }
            else if (command[0] == "empty") {
                oss << stack.Empty();
            }
            else if (command[0] == "top") {
                oss << stack.Top();
            }

            if (i + 1 < commandcnt) {
                oss << endl;
            }
        }
    }

    cout << oss.str();
}