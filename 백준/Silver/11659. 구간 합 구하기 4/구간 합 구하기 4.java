import java.util.*;
import java.io.*;

public class Main{

	static int n, m, i, j;
	static int[] arr;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n + 1];

		for(int k = 1; k <= n; k++) {
			arr[k] = arr[k - 1] + Integer.parseInt(st.nextToken());
		}
		
		for(int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
 			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());

			System.out.println(arr[j] - arr[i - 1]);
		}
	}
}