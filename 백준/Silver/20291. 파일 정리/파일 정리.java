import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static String[] str;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = new String[N];

		for (int i = 0; i < N; i++) {
			// . 으로 나누어 확장자 가져오기
			st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();
			str[i] = st.nextToken();
		}

		pro();
	}

	static void pro() {
		Arrays.sort(str);

		// cnt: 확장자 개수
		int cnt = 1;

		for (int i = 1; i <= N-1; i++) {
			if (str[i].equals(str[i-1])) {
				cnt += 1;
			} else {
				System.out.print(str[i-1] + " ");
				System.out.println(cnt);
				cnt = 1;
			}
			if (i == N-1) {
				System.out.print(str[i] + " ");
				System.out.println(cnt);
			}
		}

	}
}