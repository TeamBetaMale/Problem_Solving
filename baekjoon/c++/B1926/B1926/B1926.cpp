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

    queue<pair<int, int>> Q; // BFS
    vis[0][0] = 1; // 0, 0 을 방문했다고 명시
    Q.push({ 0, 0 }); // 큐의 시작점 세팅
 
    int cnt = 0; // 그림의 개수
    int big = 0; // 제일 큰 그림 넓이
    int cur = 0; // 현재 그림의 넓이
    if (board[0][0] == 1) cur++; // (0, 0) 좌표가 색칠되어있으면 넓이 +1

    int nx = 0; int ny = 0; // 현재 좌표
    while (true) {
        /***********************************
            실패이유: 다음 그림 찾는 방식을
            BFS 방식으로 돌렸더니 0,0 에 수렴함
            -> 그 다음부턴 무한루프 빠져서 실패
        ***********************************/

        while (Q.empty()) { // 주변에 더 이상 연결된 색칠이 없을 경우
            if (big < cur) big = cur; // 제일 큰 그림 갱신 체크

            // 다음 색칠이 나올떄까지 찾는다.
            for (int dir = 0; dir < 4; dir++) {// 상하좌우를 탐색
                nx = nx + dx[dir]; // 현재 위치에서 상하좌우 한번씩 탐색
                ny = ny + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위를 over한 경우 over
                if (vis[nx][ny] || board[nx][ny] != 1) continue; // 이미 방문했거나, 그림판에 색칠이 안 된경우 pass
                vis[nx][ny] = 1; // (nx, ny)를 방문했다고 명시

                Q.push({ nx, ny });
                cnt++; // 그림 개수 +1
                break;
            }
        }

        pair<int, int> current = Q.front(); Q.pop();
        // nx = current.X; ny = current.Y; // nx, ny 초기화

        for (int dir = 0; dir < 4; dir++) {// 상하좌우를 탐색
            int nx = current.first + dx[dir]; // 현재 위치에서 상하좌우 한번씩 탐색
            int ny = current.second + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위를 over한 경우 over
            if (vis[nx][ny] || board[nx][ny] != 1) continue; // 이미 방문했거나, 그림판에 색칠이 안 된경우 pass
            vis[nx][ny] = 1; // (nx, ny)를 방문했다고 명시

            Q.push({ nx, ny });
            cur++;
        }
    }

    cout << cnt << endl;
    cout << big << endl;
}