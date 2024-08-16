import java.util.*;
import java.io.*;

public class Main {

  static int CASES, N, M;
  static int[][] dp = new int[30][30];

  static int combination(int n, int m) {
    // 중복인 경우 반환
    if (dp[n][m] > 0)
      return dp[n][m];

    // 가장자리는 1
    if (n == m || m == 0)
      return dp[n][m] = 1;

    // n, m의 이항계수 구하기
    return dp[n][m] = combination(n - 1, m - 1) + combination(n - 1, m);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    CASES = Integer.parseInt(br.readLine());
    int[] answer = new int[CASES];

    for (int i = 0; i < CASES; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());

      answer[i] = combination(N, M);
    }

    for (int output : answer) {
      System.out.println(output);
    }
  }
}
