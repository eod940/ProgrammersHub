import java.util.*;
import java.io.*;

// 주몽의 명령
public class Main {

	static int n, m, count;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int i = 0;
		int j = n - 1;
		while (i < j) {
			if (arr[i] + arr[j] < m) {
				i += 1;
			} else if (arr[i] + arr[j] > m) {
				j -= 1;
			} else {
				i += 1;
				j -= 1;
				count += 1;
			}
		}

		System.out.print(count);
	}
}