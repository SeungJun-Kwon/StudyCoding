public class BiggestNumber {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution().solution(new int[] { 0, 0, 0 }));
    }

    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            quicksort(numbers, 0, numbers.length - 1);

            for (int number : numbers) {
                if(answer.isEmpty() && number == 0) {
                    continue;
                }

                answer += String.valueOf(number);
            }

            if(answer.isEmpty()) {
                answer = "0";
            }

            return answer;
        }

        // 퀵 정렬
        // 중간 요소를 pivot으로 설정
        public void quicksort(int[] numbers, int start, int end) {
            if(start >= end) {
                return;
            }

            int pivot = partition(numbers, start, end);

            quicksort(numbers, start, pivot);
            quicksort(numbers, pivot + 1, end);
        }

        public int partition(int[] numbers, int start, int end) {
            int pivot = numbers[(start + end) / 2];
            int l = start - 1;
            int r = end + 1;

            while (true) {
                do {
                    l++;
                } while (compare(numbers[l], pivot));

                do {
                    r--;
                } while (l <= r && compare(pivot, numbers[r]));

                if(l >= r) {
                    return r;
                }

                int tmp = numbers[l];
                numbers[l] = numbers[r];
                numbers[r] = tmp;
            }
        }

        public boolean compare(int a, int b) {
            String ab = String.valueOf(a) + String.valueOf(b);
            String ba = String.valueOf(b) + String.valueOf(a);

            return ab.compareTo(ba) > 0;
        }
    }
}