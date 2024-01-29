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

int board[102][102];
int dist[102][102]; // 해당 칸을 방문했는지

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int main() {
    // c++ 표준만 사용하곘다 (c 사용x)
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n; int m;
    cin >> n >> m;
    cin.ignore();
    for (int i = 0; i < n; i++) {
        string input;
        getline(cin, input);       

        for (int j = 0; j < m; j++) {
            board[i][j] = input[j] - '0';
        }
    }

    for (int i = 0; i < n; i++) fill(dist[i], dist[i] + m, -1); // 행별로 loop -1로 초기화
    
    queue<pair<int, int>> Q; // BFS
    dist[0][0] = 0; // 0, 0 을 방문했다고 명시
    Q.push({ 0, 0 }); // 큐의 시작점 세팅

    while (!Q.empty()) {
        pair<int, int> current = Q.front(); Q.pop();
        // nx = current.X; ny = current.Y; // nx, ny 초기화

        for (int dir = 0; dir < 4; dir++) {// 상하좌우를 탐색
            int nx = current.X + dx[dir]; // 현재 위치에서 상하좌우 한번씩 탐색
            int ny = current.Y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위를 over한 경우 over
            if (dist[nx][ny] != -1 || board[nx][ny] != 1) continue; // 이미 방문했거나, 그림판에 색칠이 안 된경우 pass
            dist[nx][ny] = dist[current.X][current.Y] + 1 ; // (nx, ny)를 방문했다고 명시 + (0, 0)에서의 위치 값 추가
            Q.push({ nx, ny });
        }
    }


    cout << dist[n - 1][m - 1] + 1;
}