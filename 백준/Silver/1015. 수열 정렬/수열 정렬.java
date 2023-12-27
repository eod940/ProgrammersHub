import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static Elem[] A;
	static int[] P;

	static class Elem implements Comparable<Elem> {
		public int idx, num;
		@Override
		public int compareTo(Elem other) {
			if (num == other.num) return idx - other.idx;
			return num - other.num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		A = new Elem[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = new Elem();
			A[i].idx = i;
			A[i].num = Integer.parseInt(st.nextToken());
		}

		pro(A);
	}

	public static void pro(Elem[] B) {
		Arrays.sort(B);
		P = new int[N];

		for (int i = 0; i < N; i++) {
			P[B[i].idx] = i;
		}

		for (int i = 0; i < N; i++) {
			System.out.print(P[i] + " ");
		}
	}
}