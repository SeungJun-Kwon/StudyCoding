public class BiggestNumber {
    public static void main(String[] args) throws Exception {
        // 1. 문자열이 다를 경우
        String s1 = "cd";
        String s2 = "abcdefg";

        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s2 + "e"));

        // 2. 비교 문자열에 포함된 경우
        s1 = "ab";
        s2 = "abcd";

        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s2 + "e"));
        System.out.println(s1.compareTo("abc"));
    }

    static class Solution {
        public String solution(int[] numbers) {
            return "";
        }
    }
}