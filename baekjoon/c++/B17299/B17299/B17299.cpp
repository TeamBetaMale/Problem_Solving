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
    int cnt;
    cin >> cnt;
    cin.ignore();

    //string input;
    //getline(cin, input);

    //istringstream iss(input);
    //// 제시된 수열
    //vector<int> numbers(istream_iterator<int> {iss}, istream_iterator<int>());
    //
    // 각 수의 등장한 회수 Map 자료구조
    //map<int, int> cntList;
    //for (int num : numbers) {
    //    cntList[num]++;
    //}

    vector<int> numbers(cnt);
    vector<int> cntList(1000001, 0); // default: 0
    for (int i = 0; i < cnt; i++) {
        cin >> numbers[i];
        cntList[numbers[i]]++;
    }

    // 인덱스 자료구조
    stack<int> st;
    st.push(0);

    // 수열의 오등큰수 결과 자료구조
    vector<int> result(cnt, -1); // default: -1
    for (int i = 0; i < cnt - 1; i++) {

        // 같은 수라면 체크를 하지 않는다.
        if (numbers[st.top()] != numbers[i + 1]) {

            // 오른쪽 중 오등큰수가 나오면 왼쪽 수 중에 오등큰수 조건 체킹
            // 비교하는 index의 등장한 값이 현재 index 값 보다 작으면 현재 값이 오등큰수이다
            while (!st.empty() && cntList[numbers[st.top()]] < cntList[numbers[i + 1]]) {
                result[st.top()] = numbers[i + 1];
                st.pop();
            }
        }

        st.push(i + 1);
    }
    
    //// 남아있는 index가 있다면, 오등큰수가 없는거니까 -1
    //while (!st.empty()) {
    //    int index = st.top();
    //    result[index] = -1;
    //    st.pop();
    //}
    
    // 결과 for 출력
    ostringstream oss;
    for (int item : result) {
        oss << item << " ";
    }
    cout << oss.str();
}
