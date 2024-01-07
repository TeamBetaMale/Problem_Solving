#include <iostream>
#include <sstream>
#include <vector>
#include <iterator>
#include <algorithm>
using namespace std;

int main()
{
    int cnt;
    cin >> cnt;
    cin.ignore(); // 첫 번째 개행 문자를 무시

    ostringstream oss;

    for (int i = 0;  i < cnt;  i++)
    {
        string input;
        getline(cin, input);

        // 문자열을 공백을 기준으로 분할하여 배열에 저장
        istringstream iss(input);
        vector<string> command(istream_iterator<string>{iss}, istream_iterator<string>());

        // &: 주소를 그대로 참조하겠다는 의미
        for (string& item: command)
        {
            // 문자열 뒤집기
            reverse(item.begin(), item.end());
            oss << item << ' ';
        }
        // 마지막 추가된 공백 제거
        oss.seekp(-1, oss.cur); // 현재 위치에서 한 칸 이동하겠다는 의미
        oss << '\n';
    }

    string result = oss.str();
    // 마지막 추가된 개행 제거
    if (cnt != 0) {
        result.pop_back();
    }

    cout << result;
}