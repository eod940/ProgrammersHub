import java.util.*;
import java.io.*;

public class Main {

	static int n, max;

	static class MyArr implements Comparable<MyArr> {
		int index;
		int value;

		public MyArr(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(MyArr o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		MyArr[] arr = new MyArr[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new MyArr(i, Integer.parseInt(br.readLine()));
		}

		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			max = Math.max(arr[i].index - i, max);
		}

		System.out.println(max + 1);
	}
}