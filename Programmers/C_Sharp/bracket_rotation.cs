using System;
using System.Collections.Generic;

public class Solution {
    public int solution(string s) {
        int answer = 0;
        int rotation_cnt = 0;
        string str = "";
        
        for(int i = 0; i < s.Length; i++) {
            str = s.Substring(rotation_cnt, s.Length - rotation_cnt);
            if(rotation_cnt > 0)
                str += s.Substring(0, rotation_cnt);
            rotation_cnt++;
            if(chk_rightBracket(str)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public bool chk_rightBracket(string s) {
        Stack<char> stack = new Stack<char>();
        char top = ' ';
        
        for(int i = 0; i < s.Length; i++) {
            if(s[i] == '(' || s[i] == '{' || s[i] == '[')
                stack.Push(s[i]);
            else {
                if(stack.Count < 1)
                    return false;
                top = stack.Pop();
                if(s[i] == ')' && top != '(')
                    return false;
                else if(s[i] == '}' && top != '{')
                    return false;
                else if(s[i] == ']' && top != '[')
                    return false;
            }
        }
        if(stack.Count > 0)
            return false;
        
        return true;
    }
}