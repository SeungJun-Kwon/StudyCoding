#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

bool compare(vector<int> a, vector<int> b) {
    if(a[0] > a[1]) {
        int tmp = a[0];
        a[0] = a[1];
        a[1] = tmp;
    }
    if(b[0] > b[1]) {
        int tmp = b[0];
        b[0] = b[1];
        b[1] = tmp;
    }
    
    return a < b;
}

int solution(int n, vector<vector<int>> edge) {
    int answer = 0, max = 0;
    
    vector<bool> visited(n + 1, false);
    vector<int> distance(n + 1, 0);
    vector<int> point;
    
    sort(edge.begin(), edge.end(), compare);
    
    visited[0] = true;
    visited[1] = true;
    
    for(int i = 0; i < edge.size(); i++) {
        point = edge[i];
        
        if(!visited[point[1]] && !visited[point[0]])
            continue;
        else {
            visited[point[1]] = true;
            if(distance[point[1]] == 0)
                distance[point[1]] = distance[point[0]] + 1;
            else if(distance[point[1]] > distance[point[0]] + 1)
                distance[point[1]] = distance[point[0]] + 1;
            printf("[%d, %d] -> %d\n", point[0], point[1], distance[point[1]]);
            if(max < distance[point[1]])
                max = distance[point[1]];
        }
    }
    
    for(int i = 1; i <= n; i++)
        if(max == distance[i])
            answer++;
    
    return answer;
}