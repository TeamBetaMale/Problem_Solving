#include <iostream>
#include <sstream>
#include <vector>
#include <iterator>
#include <algorithm>
#include <list>

using namespace std;
class Editor {
private:
    // 커서는 항상 index + 1에 위치함
    // int _cursorIterator;
    
    
    // 이중 연결 리스트, 특정 위치의 원소 삽입, 삭제에 내부적인 이동을 하지 않음 (node)
    list<char> _linkedList;
    // 연결 리스트의 반복자 커서
    // #############################
    //  반복자는 node의 위치를 반환한다
    // #############################
    list<char>::iterator _cursorIterator;

public:
    // ctor
    Editor(string str) {
        _cursorIterator = _linkedList.begin();
        init(str);
        
    }

    void init(string str) {
        for (char item : str) {
            P(item);
        }
    }

    void Command(string str) {
        // 입력 문자열을 단어별로 분할
        //istringstream iss(str);

        //// @param1: iss문자열을 읽는 이터레이터
        //// @param2: 끝 이터레이터
        //// @return: iss의 처음부터 끝까지 읽어서 전부 저장
        //vector<string> command(istream_iterator<string>{iss}, istream_iterator<string>());

        if (str.size() != 1) {
            this->P(str.at(2));
        } else {
            switch (str.at(0)) {
            case 'L':
                L();
                break;
            case 'D':
                D();
                break;
            case 'B':
                B();
                break;
            default:
                break;
            }
        }
    }

    string Print() {
        ostringstream oss;

        for (char item : _linkedList) {
            oss << item;
        }
        return oss.str();
    }

    void L() {
        if (_cursorIterator == _linkedList.begin()) return;
        _cursorIterator--;
    }

    void D() {
        if (_cursorIterator == _linkedList.end()) return;
        _cursorIterator++;
    }

    void B() {
        // 이터레이터 반환
        //auto iterator = _linkedList.begin();
        //advance(iterator, _cursorIterator - 1);

        // 특정위치의 원소 삭제
        if (_cursorIterator == _linkedList.begin()) return;
        _cursorIterator--;

        // erase는 삭제된 후 다음 node를 가리킨다.
        // ex) 0번 노드 삭제 시, 다음 header node를 return한다.
        _cursorIterator = _linkedList.erase(_cursorIterator);
    }

    void P(char $) {
        // 이터레이터 반환
        //auto iterator = _linkedList.begin();
        //advance(iterator, _cursorIterator);

        // insert는 삽입한 현재 node를 반환한다..?
        // 
        _cursorIterator = _linkedList.insert(_cursorIterator, $);
        _cursorIterator++;
    }
};



int main() {
    string str;
    std::cin >> str;
    cin.ignore();

    // 생성
    Editor edit = Editor(str);
    int M;
    std::cin >> M;
    cin.ignore();

    for (int i = 0; i < M; i++) {
        string input;
        getline(cin, input);

        // 내부적으로 실행
        edit.Command(input);
    }

    cout << edit.Print();
}