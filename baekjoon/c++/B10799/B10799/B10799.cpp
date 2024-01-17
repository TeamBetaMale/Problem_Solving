#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>
#include <iterator>
using namespace std;

int main()
{
    string input;
    getline(cin, input);

    int sticks = 0;
    char prev = 0;
    int result = 0;
    for (char item : input) {
        // 막대기 추가
        if (item == '(') {
            sticks++;    
        } else { 
            
            // 만약 () 라면, 막대기가 아니라 레이저이다.
            if (prev == '(') {
                // 이전 loop에 막대인줄 알고 더했던 값 원복
                sticks--;
                // 레이저로 잘린 왼쪽 막대의 개수를 더한다
                result += sticks;
            } else { // 만약 )) 라면, 막대 하나가 끊겼으므로.. 오른쪽의 나머지 막대를 결과에 더해준다.
                sticks--;
                result++;
            }
        }
        prev = item;
    }

    cout << result;
}