#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>
#include <iterator>
#include <algorithm>
#include <queue>
#include <map>
#include <stack>
using namespace std;
#define X first
#define Y second

int board[1002][1002];
int dist[1002][1002]; // 해당 칸을 방문했는지

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int main() {
    // c++ 표준만 사용하곘다 (c 사용x)
    ios::sync_with_stdio(0);
    cin.tie(0);
    queue<pair<int, int>> Q; // BFS

    int n; int m;
    cin >> m >> n; // 아니;; 왜 또 반대로 줘
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
            if (board[i][j] == 1) { // 익은 토마토가 들어갔다면, bfs시작점으로 q 삽입
                Q.push({ i, j });
            } else if (board[i][j] == 0) { // 안익은 토마토
                dist[i][j] = -1;
            }
        }
    }

    int ans = 0;
    while (!Q.empty()) {
        pair<int, int> current = Q.front(); Q.pop();

        for (int dir = 0; dir < 4; dir++) {// 상하좌우를 탐색
            int nx = current.X + dx[dir]; // 현재 위치에서 상하좌우 한번씩 탐색
            int ny = current.Y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위를 over한 경우 over
            if (dist[nx][ny] != -1 || board[nx][ny] == -1) continue; // 이미 방문했거나, 토마토가 들어있지 않은 칸이면 pass
            dist[nx][ny] = dist[current.X][current.Y] + 1; // 익은 날짜 초기화
            Q.push({ nx, ny });
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (dist[i][j] == -1) { // 안익은 토마토가 있다면, 익은토마토가 애초에 없었던 것
                cout << -1;
                return 0;
            }

            ans = max(ans, dist[i][j]);
        }
    }
    cout << ans;
}