#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> numbers) {
    string answer = "";
    
    vector<string> v;
    
    for(int i = 0; i < numbers.size(); i++) {
        string s = "";
        s = to_string(numbers[i]);
        v.push_back(s);
    }
    
    struct {
        bool operator()(string a, string b) {
            cout << a << " " << b << "\n";
            if(a + b >= b + a) {
                cout << a + b << "\n";
                return a >= b;
            }
            else {
                cout << b + a << "\n";
                return b < a;
            }
        }
    } compare;
    
    sort(v.begin(), v.end(), compare);
    
    for(auto i : v)
        answer += i;
    
    return answer;
}

int main() {
    int N;

    cin >> N;
    vector<int> v;

    for(int i = 0; i < N; i++) {
        int n;
        cin >> n;
        v.push_back(n);
    }

    cout << solution(v);
}