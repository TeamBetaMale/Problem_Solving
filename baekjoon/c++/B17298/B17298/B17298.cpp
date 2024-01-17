#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>
#include <iterator>
#include <list>

using namespace std;

struct Data {
    int index; // 제시한 수열의 인덱스
    int val; // val로 정렬할거임
    int result; // 결과값, 나보다 큰 값 중 제일 작은 값
    Data(int index, int val) : index(index), val(val), result(-1) {}
};

// 정렬 callback
bool compare(const Data* a, const Data* b) {
    return a->val < b->val; // 오름차순
}

int main() {
    int cnt;
    cin >> cnt;
    cin.ignore();
    
    string input;
    getline(cin, input);
    
    istringstream iss(input);
    vector<int> numbers (istream_iterator<int> {iss}, istream_iterator<int>());
 
    // 값: 3 5 2 7
    // i:  0 1 2 3
    list<Data*> originList; // 정렬이 적용안되고 result만 갱
    list<Data*> linkedList; // 정렬해서 뺑뺑이 칠 객체
    for (int i = 0; i < cnt; i++) {
        // 포인터 Data
        Data* data = new Data(i, numbers[i]);

        // 값 참조
        originList.push_back(data);
        linkedList.push_back(data);
    }
    
    // 정렬
    // 값: 2 3 5 7
    // i : 2 0 1 3
    linkedList.sort(compare);

    // 연결리스트 순회
    list<Data*>::iterator it = linkedList.begin();
    for (int i = 0; i < cnt; i++) {
        Data* currentData = *it; // 반복자 역참조로 Data 포인터에 접근할 수 있다고 함
        
        for (int j = 1; j < cnt - i; j++) {
            Data* nextData = *next(it, j); // 반복자 다음값을 반환. ++ 사용하면 it가 변경돼서 안됨
            
            // 내 현재 인덱스보다 큰 값이 있으면 break
            if (currentData->index < nextData->index) {
                currentData->result = nextData->val;
                break;
            }
        }
        
        it++;
    }

    ostringstream oss;
    for (Data* data : originList) {
        oss << data->result << " ";
    }
    
    cout << oss.str();
}