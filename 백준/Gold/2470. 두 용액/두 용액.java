import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, 1, n + 1);

		int min = Integer.MAX_VALUE;
		int v1 = 0, v2 = 0;
		for (int left = 1; left <= n - 1; left++) {
			// arr[left] 용액을 사용할 것이다. 따라서 -arr[left]와 가장 가까운 용액을 자신의 오른쪽 구간에서 찾자.
			int candidate = lower_bound(arr, left + 1, n, -arr[left]);

			// arr[candidate - 1]과 arr[candidate] 중에 arr[left]와 섞었을 때의 정보를 정답에 갱신시킨다.
			if (left < candidate - 1 && Math.abs(arr[left] + arr[candidate - 1]) < min) {
				min = Math.abs(arr[left] + arr[candidate - 1]);
				v1 = arr[left];
				v2 = arr[candidate - 1];
			}

			if (candidate <= n && Math.abs(arr[left] + arr[candidate]) < min) {
				min = Math.abs(arr[left] + arr[candidate]);
				v1 = arr[left];
				v2 = arr[candidate];
			}
		}
		System.out.print(v1 + " ");
		System.out.print(v2);
	}

	static int lower_bound(int[] A, int L, int R, int X) {
		// A[L...R] 에서 X 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 R + 1 을 return 한다.

		int result = R + 1;

		while (L <= R) {
			int mid = (L + R) / 2;

			// 내가 원하는 건 크거나 같은 값을 찾는 것이기 때문에 이를 먼저 찾아준다.
			if (A[mid] >= X) {
				result = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return result;
	}
}