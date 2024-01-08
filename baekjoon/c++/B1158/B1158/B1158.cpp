#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>
#include <iterator>
using namespace std;

struct MyNode {
    // current value
    int _data;
    // next element
    MyNode* _next;
    MyNode* _prev;
    // ctor
    MyNode(int data): _data(data), _prev(nullptr), _next(nullptr) {} // init Fields and next Node has null address
};

class MyLinkedList {
private:
    // first node
    MyNode* _firstNode;
    MyNode* _lastNode;
   
public:
    MyLinkedList() : _firstNode(nullptr), _lastNode(nullptr) {}

    void add(int data) {
        MyNode* node = new MyNode(data);

        if (_firstNode == nullptr) {
            _firstNode = node;
        } 

        if (_lastNode == nullptr) {           
            _lastNode = node;
        }

        // 1. Last node set NEXT node to the CURRENT node
        this->_lastNode->_next = node;

        // 2. Current node set PREVIOUS node to the CURRENT node
        node->_prev = _lastNode;
        
        // !!!3. Current node set NEXT node to the FIRST node!!! (Circular Linked List)
        node->_next = this->_firstNode;
        this->_firstNode->_prev = node;

        // 4. Update LAST node pointer
        this->_lastNode = node;
    }
    
    MyNode* GetFirstNode() {
        return this->_firstNode;
    }

    MyNode* PopAtIndex(MyNode* node, int idx) {
        for (int i = 0; i < idx; i++) {
            node = node->_next;
        }

        MyNode* preNode = node->_prev;
        MyNode* nextNode = node->_next;

        preNode->_next = nextNode;
        nextNode->_prev = preNode;

        return node;
    }
};


int main() {
    MyLinkedList list;

    string input;
    getline(cin, input);
    istringstream iss(input);
    vector<string> command(istream_iterator<string> {iss}, istream_iterator<string>());

    int capacity = stoi(command[0]);
    int jump = stoi(command[1]);

    for (int i = 0; i < capacity; i++) {
        list.add(i + 1);
    }


    ostringstream oss;
    oss << "<";
    MyNode* node = list.GetFirstNode()->_prev;
    for (int i = 0; i < capacity; i++) {
        // append str
        if (i != 0) oss << ", ";

        node = list.PopAtIndex(node, jump);

        oss << node->_data;
    }
    oss << ">";
    cout << oss.str();
}
