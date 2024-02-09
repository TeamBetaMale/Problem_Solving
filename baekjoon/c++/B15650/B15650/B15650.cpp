#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[10]; // 중복없이 고른 수열 (m)의 개수를 담아놓는 array
bool isused[10]; // 재귀를 돌면서 선택된 숫자들은 true로 세팅

void func(int k, int idx) {
    if (k == m) { // 수열의 반복 회수에 도달하면 print
        for (int i = 0; i < m; i++) {
            cout << arr[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = idx; i <= n; i++) {
        if (!isused[i]) { // 사용하지 않는 상태면 재귀함수 호출
            arr[k] = i;
            isused[i] = true;
            func(k + 1, i + 1);
            isused[i] = false;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    func(0, 1);
}