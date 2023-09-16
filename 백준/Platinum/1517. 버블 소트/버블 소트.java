import java.util.*;
import java.io.*;

public class Main {

	static long result;
	static int[] arr, tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		tmp = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		result = 0;
		merges(1, n);  // 병합정렬 수행

		System.out.println(result);
	}

	public static void merges(int s, int e) {

		if (e - s < 1) { return; }

		int mid = s + (e - s) / 2;

		// 재귀 함수 형태로 구현
		merges(s, mid);
		merges(mid + 1, e);

		for (int i = s; i <= e; i++) {
			tmp[i] = arr[i];
		}

		int k = s;
		int idx1 = s;
		int idx2 = mid + 1;
		while (idx1 <= mid && idx2 <= e) {  // 두 그룹을 병합하는 로직
			if (tmp[idx1] > tmp[idx2]) {
				arr[k] = tmp[idx2];

				result += idx2 - k;  // 뒤쪽 데이터 값이 작은 경우 result 업데이트

				k += 1;
				idx2 += 1;
			} else {
				arr[k] = tmp[idx1];
				k += 1;
				idx1 += 1;
			}
		}

		while (idx1 <= mid) {
			arr[k] = tmp[idx1];
			k += 1;
			idx1 += 1;
		}

		while (idx2 <= e) {
			arr[k] = tmp[idx2];
			k += 1;
			idx2 += 1;
		}

	}
}