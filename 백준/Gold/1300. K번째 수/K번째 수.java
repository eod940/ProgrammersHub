import java.io.*;

public class Main {

	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		long start = 1;
		long end = k;
		long ans = 0;

		while (start <= end) {
			long mid = (start + end) / 2;
			long cnt = 0;
			// 중앙값보다 작은 수는 몇개인지 계산
			for (int i = 1; i <= n; i++) {
				cnt += Math.min(n, mid / i);  // 작은 수 카운트
			}

			if (cnt < k) {
				start = mid + 1;
			} else {
				ans = mid;  // 현재 중앙값을 일단 정답변수에 저장
				end = mid - 1;
			}
		}

		System.out.println(ans);
	}
}