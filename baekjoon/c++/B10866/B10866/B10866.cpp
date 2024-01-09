#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>
#include <iterator>
#include <list>

#define TRUE    1
#define FALSE   0

using namespace std;

class MyDeQue {
private:
    list<int> _deque; // Linked List Library
public:
    void PushFront(int x) {
        _deque.push_front(x);
    }

    void PushBack(int x) {
        _deque.push_back(x);
    }

    int PopFront() {
        if (this->Empty() == TRUE) {
            return -1;
        }
        
        int front = _deque.front();
        _deque.pop_front();
        return front;
    }
    int PopBack() {
        if (this->Empty() == TRUE) {
            return -1;
        }

        int back = _deque.back();
        _deque.pop_back();
        return back;
    }

    int Size() {
        return _deque.size();
    }

    int Empty() {
        return this->Size() == 0 ? TRUE : FALSE;
    }

    int Front() {
        if (this->Empty() == TRUE) {
            return -1;
        }

        return _deque.front();
    }

    int Back() {
        if (this->Empty() == TRUE) {
            return -1;
        }

        return _deque.back();
    }
};

int main() {
    MyDeQue deque;
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
            if (command[0] == "push_front") {
                deque.PushFront(stoi(command[1]));
            } else if (command[0] == "push_back") {
                deque.PushBack(stoi(command[1]));
            }
            
        } else {
            if (command[0] == "pop_front") {
                oss << deque.PopFront() << endl;
            } else if (command[0] == "pop_back") {
                oss << deque.PopBack() << endl;
            } else if (command[0] == "size") {
                oss << deque.Size() << endl;
            } else if (command[0] == "empty") {
                oss << deque.Empty() << endl;
            } else if (command[0] == "front") {
                oss << deque.Front() << endl;
            } else if (command[0] == "back") {
                oss << deque.Back() << endl;
            }
        }

    }
    cout << oss.str();
}
