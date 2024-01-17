#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>
#include <iterator>
#include <stack>

using namespace std;


int main() {
    int cnt;
    cin >> cnt;
    cin.ignore();

    string input;
    getline(cin, input);

    istringstream iss(input);
    vector<int> numbers(istream_iterator<int> {iss}, istream_iterator<int>());

    // 제시한 수열의 index를 임시로 담아두는 저장소
    // 수열의 값을 
    stack<int> st;
    st.push(0); // 초기 index push

    // 버블정렬?
    // 수열의 첫 번째부터 다음 수 중에 제일 빨리 만나는 큰 수 찾기
    // 큰 수가 나오면, result의 index에 삽입한다.   
    vector<int> result(cnt);
    for (int i = 0; i < cnt - 1; i++) {
        // 비교값이 현재 loop 값보다 작으면 현재 loop 값이 오큰수이다.
        while (!st.empty() && numbers[st.top()] < numbers[i + 1]) {
            result[st.top()] = numbers[i + 1];
            st.pop(); // 해당 값은 체크가 끝났으므로 삭제
        }

        // 인덱스 추가
        st.push(i + 1);
    }

    // 남아있는 index가 있다면, 오른쪽 큰 수가 없는거니까 -1
    while (!st.empty()) {
        int index = st.top();
        result[index] = -1;
        st.pop();
    }

    ostringstream oss;
    for (int item : result) {
        oss << item << " ";
    }
    cout << oss.str();
}