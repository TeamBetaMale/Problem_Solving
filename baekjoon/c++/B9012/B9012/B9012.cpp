// B9012.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <sstream>
#include <vector>
#include <iterator>
#include <algorithm>

int main()
{
    int cnt;
    std::cin >> cnt;
    std::cin.ignore();

    std::ostringstream oss;
    for (int i = 0; i < cnt;  i++)
    {
        std::string input;
        getline(std::cin, input);

        int pointer = 0;
        std::string result = "YES";
        for (char item : input) {
            if (item == '(') {
                pointer++;
            }
            
            if (item == ')') {
                if (pointer == 0) {
                    result = "NO";
                    break;
                }
               
                pointer--;
            }
        }
        if (pointer != 0) result = "NO";
        oss << result << std::endl;
    }
    
    std::string result = oss.str();
    // 마지막에 추가된 개행 제거
    if (cnt != 0) {
        result.pop_back();
    }
    
    std::cout << result;
}