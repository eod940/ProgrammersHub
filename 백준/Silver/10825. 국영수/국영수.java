import java.util.*;
import java.io.*;

public class Main {

	static int n;

	static class Elem implements Comparable<Elem> {
		public String name;
		public int ko, en, math;

		@Override
		public int compareTo(Elem other) {
			// 첫 번째 조건: 국어점수 감소 순
			if (ko != other.ko) return other.ko - ko;
			// 두 번째 조건: 영어점수 증가 순
			if (en != other.en) return en - other.en;
			// 세 번째 조건: 수학점수 감소 순
			if (math != other.math) return other.math - math;

			return name.compareTo(other.name);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Elem[] elem = new Elem[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			elem[i] = new Elem();
			elem[i].name = st.nextToken();
			elem[i].ko = Integer.parseInt(st.nextToken());
			elem[i].en = Integer.parseInt(st.nextToken());
			elem[i].math = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(elem);

		for (int i = 0; i < n; i++) {
			System.out.println(elem[i].name);
		}
	}
}