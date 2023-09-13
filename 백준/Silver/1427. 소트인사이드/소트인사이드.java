import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Integer[] arr = new Integer[s.length()];

		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i) - '0';
		}

		Arrays.sort(arr, Comparator.reverseOrder());

		for (int i : arr) {
			System.out.print(i);
		}
	}
}