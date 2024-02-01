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
#define X first;
#define Y second;

int board[502][502];
bool vis[502][502]; // 해당 칸을 방문했는지

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
        istringstream iss(input);
        vector<int> command(istream_iterator<int> {iss}, istream_iterator<int>());

        for (int j = 0; j < m; j++) {
            board[i][j] = command[j];
        }
    }

    int cnt = 0; // 그림의 개수
    int mx = 0; // 제일 큰 그림 넓이
    
    queue<pair<int, int>> Q; // BFS
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (board[i][j] == 0 || vis[i][j]) continue; // 색칠되지 않은 좌표거나, 이미 방문했다면 pass
            cnt++; // 총 그림 개수 +1
            vis[i][j] = 1; // 0, 0 을 방문했다고 명시
            Q.push({ i, j }); // 큐의 시작점 세팅            
            
            int cur = 0; // 현재 그림의 넓이

            while (!Q.empty()) {
                cur++; // 색칠된곳이니 + 1
                pair<int, int> current = Q.front(); Q.pop();
                // nx = current.X; ny = current.Y; // nx, ny 초기화

                for (int dir = 0; dir < 4; dir++) {// 상하좌우를 탐색
                    int nx = current.first + dx[dir]; // 현재 위치에서 상하좌우 한번씩 탐색
                    int ny = current.second + dy[dir];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위를 over한 경우 over
                    if (vis[nx][ny] || board[nx][ny] != 1) continue; // 이미 방문했거나, 그림판에 색칠이 안 된경우 pass
                    vis[nx][ny] = 1; // (nx, ny)를 방문했다고 명시

                    Q.push({ nx, ny });
                }
            }
            mx = max(mx, cur); // 젤 큰 그림 <-> 현재 그림  비교
        }
    }   


    cout << cnt << endl;
    cout << mx << endl;
}