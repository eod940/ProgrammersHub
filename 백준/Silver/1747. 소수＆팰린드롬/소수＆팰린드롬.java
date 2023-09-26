import java.util.*;
import java.io.*;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int[] arr = new int[10_000_001];

		for (int i = 2; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int i = 2; i < Math.sqrt(arr.length); i++) {
			if (arr[i] == 0) continue;

			for (int j = 2 * i; j < arr.length; j += i) {
				arr[j] = 0;
			}
		}

		int i = n;
		while (true) {
			if (arr[i] != 0) {
				int cur = arr[i];
				if (isPalindrome(cur)) {
					System.out.println(cur);
					break;
				}
			}
			i += 1;
		}

	}

	static boolean isPalindrome(int target) {
		char[] temp = String.valueOf(target).toCharArray();
		int start = 0;
		int end = temp.length - 1;
		while (start < end) {
			if (temp[start] != temp[end])
				return false;
			start += 1;
			end -= 1;
		}
		return true;
	}
}