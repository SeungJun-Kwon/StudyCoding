using System;
using System.Collections.Generic;

public class Solution
{
    public int solution(int storey)
    {
        int answer = 0;
        int cal_storey = storey;

        while (cal_storey > 0)
        {
            int r = cal_storey % 10;

            cal_storey /= 10;

            if (r < 5)
            {
                answer += r;
            }
            else if (r > 5)
            {
                answer += (10 - r);
                cal_storey += 1;
            }
            else
            {
                answer += r;
                if (cal_storey % 10 >= 5)
                    cal_storey += 1;
            }
        }

        return answer;
    }
}