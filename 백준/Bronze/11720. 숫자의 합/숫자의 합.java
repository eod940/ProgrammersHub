import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = st.nextToken();

		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			ans += s.charAt(i) - '0';
		}
		System.out.print(ans);
	}
}