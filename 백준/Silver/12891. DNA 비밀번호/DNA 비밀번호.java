import java.util.*;
import java.io.*;

// dna 비밀번호
public class Main {

	static int n, m, result, checkS;
	static char[] dna;
	static int[] rule = new int[4], curCheck = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dna = new char[n];
		dna = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			// A, C, G, T 순으로 최소 몇 개인지
 			rule[i] = Integer.parseInt(st.nextToken());

			if (rule[i] == 0) checkS += 1;
		}

		// 부분 문자열 초기화
		for (int i = 0; i < m; i++) {
			add(dna[i]);
		}

		if (checkS == 4) result += 1;

		// Sliding Window
		for (int i = m; i < n; i++) {
			int j = i - m;
			add(dna[i]);
			del(dna[j]);

			if (checkS == 4) result += 1;
		}
		System.out.println(result);
	}

	public static void add(char c) {
		switch (c) {
		case 'A':
			curCheck[0] += 1;
			if (curCheck[0] == rule[0]) checkS += 1;
			break;
		case 'C':
			curCheck[1] += 1;
			if (curCheck[1] == rule[1]) checkS += 1;
			break;
		case 'G':
			curCheck[2] += 1;
			if (curCheck[2] == rule[2]) checkS += 1;
			break;
		case 'T':
			curCheck[3] += 1;
			if (curCheck[3] == rule[3]) checkS += 1;
			break;
		}
	}

	public static void del(char c) {
		switch (c) {
		case 'A':
			if (curCheck[0] == rule[0]) checkS -= 1;
			curCheck[0] -= 1;
			break;
		case 'C':
			if (curCheck[1] == rule[1]) checkS -= 1;
			curCheck[1] -= 1;
			break;
		case 'G':
			if (curCheck[2] == rule[2]) checkS -= 1;
			curCheck[2] -= 1;
			break;
		case 'T':
			if (curCheck[3] == rule[3]) checkS -= 1;
			curCheck[3] -= 1;
			break;
		}
	}
}