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
    vector<int> alpList(26, 0); // 알파벳 개수 자료구조 초기화
    string input;
    cin >> input;
    // 97 ~ 122 아스키코드 a ~ z
    for (char item : input) {
        int index = item - 97;
        alpList[index]++;
    }

    ostringstream oss;
    for (int item : alpList) {
        oss << item << " ";
    }
    cout << oss.str();
}