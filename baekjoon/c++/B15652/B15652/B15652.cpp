#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[10]; // 중복없이 고른 수열 (m)의 개수를 담아놓는 array

void func(int k, int idx) {
    if (k > m) { // 수열의 반복 회수에 도달하면 print
        for (int i = 1; i <= m; i++) {
            cout << arr[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = idx; i <= n; i++) {
        arr[k] = i;
        func(k + 1, i);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    func(1, 1);
}
