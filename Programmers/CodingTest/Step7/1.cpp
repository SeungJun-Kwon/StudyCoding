#include <vector>
#include <queue>
#include <tuple>
using namespace std;

int solution(vector<vector<int> > maps)
{
    int answer = -1;
    
    vector<vector<bool>> visited(maps.size(), vector<bool>(maps[0].size()));
    
    int dr[4] = {-1, 1, 0, 0};
    int dc[4] = {0, 0, -1, 1};
    
    queue<tuple<int, int, int>> q;
    
    q.push({0, 0, 1});
    visited[0][0] = true;
    
    while(!q.empty()) {
        int r = get<0>(q.front());
        int c = get<1>(q.front());
        int cnt = get<2>(q.front());
        q.pop();
        
        if(r == maps.size() - 1 && c == maps[0].size() - 1)
            return cnt;
        
        for(int i = 0; i < 4; i++) {
            int cr = r + dr[i];
            int cc = c + dc[i];
            
            if((cr >= 0 && cr < maps.size()) && (cc >= 0 && cc < maps[0].size())
               && !visited[cr][cc] && maps[cr][cc] == 1) {
                q.push({cr, cc, cnt + 1});
                visited[cr][cc] = true;
            }
        }
    }
    
    return answer;
}