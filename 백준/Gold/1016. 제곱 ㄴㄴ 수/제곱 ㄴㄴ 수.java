import java.io.*;
import java.util.*;

public class Main {
	static long mn, mx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		mn = Long.parseLong(st.nextToken());
		mx = Long.parseLong(st.nextToken());
		boolean[] check = new boolean[(int) (mx - mn + 1)];
		
		for (long i = 2; i * i <= mx; i++) {
			long pow = i * i;
			long start_idx = mn / pow;

			if (mn % pow != 0) 
				start_idx += 1;
			for (long j = start_idx; pow * j <= mx; j++) {
				check[(int) ((j * pow) - mn)] = true;
			}
		}

		int count = 0;

		for (int i = 0; i <= mx - mn; i++) {
			if (!check[i]) count += 1;
		}
		System.out.println(count);
	}
}