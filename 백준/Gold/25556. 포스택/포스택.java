import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] n = makeNumArray();
        String result = isCleanUp(n);
        System.out.println(result);
    }

    public static int[] makeNumArray() {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();  // 순열의 길이 N 입력
        int[] numArray = new int[n];  // 길이가 N인 수열 생성

        // 1 이상 N 이하의 서로 다른 정수 N개가 임의로 나열된 수열 만들기
        for (int i = 0; i < numArray.length; i++) {
            int nums = input.nextInt();
            numArray[i] = nums;
        }
        return numArray;
    }

    public static String isCleanUp(int[] n) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();
        String result = "YES";

        // 비어있거나, 나오려는 애가 들어가려는 애보다 작아야 한다.
        for (int i : n) {
            if (stack1.isEmpty() || stack1.peek() < i) {
                stack1.push(i);
            }
            else if (stack2.isEmpty() || stack2.peek() < i) {
                stack2.push(i);
            }
            else if (stack3.isEmpty() || stack3.peek() < i) {
                stack3.push(i);
            }
            else if (stack4.isEmpty() || stack4.peek() < i) {
                stack4.push(i);
            }
            else {
                result = "NO";
            }
        }
        return result;
    }
}
