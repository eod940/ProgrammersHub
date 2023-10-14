import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static long[] arr, brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new long[n];
		brr = new long[m];
		long answer = 0;

		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < n; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {  // 합배열의 모든 값에 %연산 수행
			int remainder = (int) (arr[i] % m);

			if (remainder == 0) answer += 1;
			brr[remainder] += 1;
		}

		for (int i = 0; i < m; i++) {
			if (brr[i] > 1) {
				// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 더하기
				answer += (brr[i] * (brr[i] - 1) / 2);
			}
		}

		System.out.println(answer);
	}
}