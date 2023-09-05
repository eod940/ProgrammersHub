import java.util.*;
import java.io.*;

public class Main {

	static int n, max;
	static int[] arr;
	static double ave;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {	
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		for (int i = 0; i < n; i++) {
			ave += (double) arr[i] / max * 100;
		}

		System.out.print(ave / n);
	}
}