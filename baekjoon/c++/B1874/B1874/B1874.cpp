#include <iostream>
#include <sstream>
#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

// return����ϱ����� �Լ����λ�
ostringstream func(int maxNum, vector<int> sequences) {
    // start test...
    int pointer = 0;
    vector<int> result;
    ostringstream oss;
    for (int item : sequences) {
        if (result.empty() || result.back() < item) {
            for (int i = 1; i <= item; i++) {
                result.push_back(++pointer);
                oss << "+" << endl;

                // ������ �Ѵ� ��� NO
                if (pointer > maxNum) {
                    oss.str("");
                    oss << "NO";
                    return oss;
                }

                // �����Ϳ� ���� �ʿ��� ���ڰ� ���ٸ� break
                if (pointer == item) {
                    result.pop_back();
                    oss << "-" << endl;
                    break;
                }
            }
        } else {
            for (int i = 1; i <= item; i++) {
                if (result.size() == 0) {
                    oss.str("");
                    oss << "NO";
                    return oss;
                }
                int cur = result.back();
                result.pop_back();
                oss << "-" << endl;

                // ���� ���Ϳ� �ʿ��� ���ڰ� ���ٸ� break
                if (cur == item) {
                    break;
                }
            }
        }
    }

    return oss;
}

int main()
{
    int n;
    std::cin >> n;
    cin.ignore();

    // ������ ���� ����
    vector<int> sequences;
    for (int i = 1; i <= n; i++) {
        int num;
        cin >> num;
        sequences.push_back(num);
    }

    ostringstream oss = func(n, sequences);
    

    cout << oss.str();
}