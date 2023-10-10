import java.util.*;
import java.io.*;

public class Main {
	static int t, n, m;
	static int[] a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			a = new int[n + 1];
			b = new int[m + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			// 시작
			Arrays.sort(b, 1, m + 1);

			int ans = 0;
			for (int i = 1; i <= n; i++) {
				ans += lower_bound(b, 1, m, a[i]);  // a[i]를 선택했을 때, b에서는 a[i]보다 작은 게 몇 개나 있는 지 count하기
			}
			System.out.println(ans);
		}
	}

	static int lower_bound(int[] A, int L, int R, int X) {
		// A[L ... R] 에서 X미만의 수 중 제일 오른쪽에 있는 수를 return하는 함수
		// 그런게 없다면 L-1 을 return 한다.

		int result = L - 1;
		while (L <= R) {
			int mid = (L + R) / 2;
			if (A[mid] < X) {
				result = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		return result;
	}
}