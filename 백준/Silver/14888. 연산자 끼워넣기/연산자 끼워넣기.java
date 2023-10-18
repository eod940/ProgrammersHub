import java.util.*;
import java.io.*;

public class Main {
	static int n, max, min;
	static int[] nums, operators, order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		nums = new int[n + 1];
		operators = new int[5];
		order = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) 
			nums[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 4; i++)
			operators[i] = Integer.parseInt(st.nextToken());

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		recur(1);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}
	static int calculator() {
		// nums, order
		int value = nums[1];
		for (int i = 1; i <= n - 1; i++) {
			// value, order[i], num[i + 1]
			if (order[i] == 1) // +
				value += nums[i + 1];
			if (order[i] == 2) // -
				value -= nums[i + 1];
			if (order[i] == 3) // *
				value *= nums[i + 1];
			if (order[i] == 4) // /
				value /= nums[i + 1];
		}
		return value;
	}

	static void recur(int k) {
		if (k == n) {
			// 완성된 식에 맞게 게산을 해서 정답에 갱신하는 작업
			int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			// k번째 연산자는 무엇을 선택할 것인가?
			for (int i = 1; i <= 4; i++) {
				if (operators[i] >= 1) {
					operators[i] -= 1;
					order[k] = i;
					recur(k + 1);
					operators[i] += 1;
					order[k] = 0;
				}
			}
		}
	}
}