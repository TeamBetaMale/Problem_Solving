#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>
#include <iterator>
#include <algorithm>
using namespace std;

// 문자를 맵으로 쪼갠다
// 쪼개는 기준: 태그를 만날경우

// 배열을 순회를 돈다

struct Data {
    bool is_tag;
    string str;

    // ctor
    Data(bool is_tag, string str): is_tag(is_tag), str(str) {}
};

int main()
{
    vector<Data> dataList;
    string input;
    getline(cin, input);

    while (!input.empty()) {
        size_t startIdx = input.find('<');
        if (startIdx == string::npos) {
            Data* data = new Data(false, input);
            dataList.push_back(*data);
            break;
        }

        if (startIdx != 0) {
            dataList.push_back(*new Data(false, input.substr(0, startIdx)));
            input = input.erase(0, startIdx);
        }

        size_t endIdx = input.find('>');
        dataList.push_back(*new Data(true, input.substr(0, endIdx+1)));
        input = input.erase(0, endIdx+1);
    }

    ostringstream oss;
    for (Data& item : dataList) {
        if (item.is_tag) {
            oss << item.str;
            continue;
        }

        istringstream iss(item.str);
        vector<string> split(istream_iterator<string>{iss}, istream_iterator<string>());
    
        string newStr;
        for (size_t i = 0; i < split.size(); i++) {
            string& str = split.at(i);
            reverse(str.begin(), str.end());
            oss << str;
            if (i < split.size() - 1) {
                oss << " ";
            }
        }
    }
    cout << oss.str();
}
