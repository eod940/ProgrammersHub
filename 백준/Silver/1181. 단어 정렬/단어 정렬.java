import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static String[] S;
	static StringBuilder sb = new StringBuilder();

	static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String lhs, String rhs) {
            if (lhs.length() != rhs.length())
                return lhs.length() - rhs.length();
            return lhs.compareTo(rhs);
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new String[N];

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			S[i] = word;
		}

		Arrays.sort(S, new MyComparator());

		for (int i = 0; i < N; i++) {
            if (i == 0 || S[i].compareTo(S[i - 1]) != 0)
                sb.append(S[i]).append('\n');
        }
        System.out.println(sb.toString());
	}
}