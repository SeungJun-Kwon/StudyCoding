#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    
    sort(times.begin(), times.end());
    
    long long left = 1, right = times[times.size() - 1] * n, mid, cnt = 0;
    
    while(left <= right) {
        mid = (left + right) / 2;
        
        for(auto i : times)
            cnt += mid / i;
        
        if(cnt >= n) {
            answer = mid;
            right = mid - 1;
        }
        else
            left = mid + 1;
        
        cnt = 0;
    }
    
    return answer;
}