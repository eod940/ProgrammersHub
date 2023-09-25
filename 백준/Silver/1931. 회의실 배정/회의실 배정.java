import java.util.*;
import java.io.*;

public class Main {
	static int n, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int[][] time = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] S, int[] E) {
				if (S[1] == E[1]) {  // 종료 시간이 같을 때
					return S[0] - E[0];
				}
				return S[1] - E[1];
			}
		});

		int end = -1;
		for (int i = 0; i < n; i++) {
			if (time[i][0] >= end) {  // 겹치지 않는 다음 회의가 나온 경우
				end = time[i][1];  // 종료시간 업데이트
				count += 1;
			}
		}
		System.out.println(count);
	}
}