#include <iostream>
#include <cmath>

using namespace std;

bool chk(int a, int b) {
    if(abs(b - a) == 1) {
        if(b > a) {
            if(b % 2)
                return true;
            return false;
        }
        else if(a > b) {
            if(a % 2)
                return true;
            return false;
        }
    }
    else if(abs(b - a) > 1) {
        return true;
    }
    
    return false;
}

int solution(int n, int a, int b)
{
    int answer = 1;

    while(chk(a, b)) {
        if(a % 2)
            a = (a + 1) / 2;
        else
            a = a / 2;
        
        if(b % 2)
            b = (b + 1) / 2;
        else
            b = b / 2;
        
        answer++;
    }

    return answer;
}