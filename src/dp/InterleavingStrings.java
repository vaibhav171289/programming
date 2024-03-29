package dp;


public class InterleavingStrings {
	public static void main(String[] args) {
		System.out.println(new InterleavingStrings().isInterleave("noUdRp97xFvpifeSXGwOjcVNhHo9N2D",
				"6iZItw9A3fj86uYx04tvWKLtl9BK",
				"n6ioUdRpZ97ItwxF9Av3fj86upYxif0eS4XtvWKLtlG9wOBKjcVNhHo9N2D"));
		
	}
	public int isInterleave(String s1, String s2, String s3) {
		  if (s3.length() != s1.length() + s2.length()) {
	            return 0;
	        }
	        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
	        for (int i = 0; i <= s1.length(); i++) {
	            for (int j = 0; j <= s2.length(); j++) {
	                if (i == 0 && j == 0) {
	                    dp[i][j] = true;
	                } else if (i == 0) {
	                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
	                } else if (j == 0) {
	                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
	                } else {
	                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
	                }
	            }
	        }
	        if(dp[s1.length()][s2.length()] ==true)
	        	return 1;
	        else return 0;
	}
}
