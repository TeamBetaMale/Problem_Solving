#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>
#include <iterator>

#define TRUE    1
#define FALSE   0

using namespace std;

class MyQueue {
private:
    vector<int> _queue;
    int _cursor;
public: 
    void Push(int x) {
        _queue.push_back(x);
    }

    int Pop() {
        if (this->Empty() == TRUE) {
            return -1;
        }

        return _queue[_cursor++];
    }

    int Size() {
        return _queue.size() - _cursor;
    }

    int Empty() {
        return this->Size() == 0 ? TRUE : FALSE;
    }

    int Front() {
        if (this->Empty() == TRUE) {
            return -1;
        }

        return _queue[_cursor];
    }

    int Back() {
        if (this->Empty() == TRUE) {
            return -1;
        }

        return _queue.back();
    }
};

int main()
{
    MyQueue queue;
    int cnt;
    cin >> cnt;
    cin.ignore();

    ostringstream oss;
    for (int i = 0; i < cnt; i++) { 
        string input;
        getline(cin, input);
        
        istringstream iss(input);
        vector<string> command(istream_iterator<string> {iss}, istream_iterator<string>());
        if (command.size() != 1) {
            queue.Push(stoi(command[1]));
        } else {
            if (command[0] == "pop") {
                oss << queue.Pop() << endl;
            } else if (command[0] == "size") {
                oss << queue.Size() << endl;
            } else if (command[0] == "empty") {
                oss << queue.Empty() << endl;
            } else if (command[0] == "front") {
                oss << queue.Front() << endl;
            } else if (command[0] == "back") {
                oss << queue.Back() << endl;
            } 
        }

    }
    cout << oss.str();
}
