import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[] arr;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		
		int sum = 1, count = 1, i = 1, j = 1;

		while (j != n) {
			if (sum > n) {
				sum -= i;
				i += 1;
			} else if (sum < n) {
				j += 1;
				sum += j;
			} else {
				count += 1;
				j += 1;
				sum += j;
			}
		}
		
		System.out.print(count);
	}
}