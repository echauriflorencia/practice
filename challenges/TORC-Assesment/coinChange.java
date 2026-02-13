public static int MathChallenge(int num) {
    int[] coins = {1, 5, 7, 9, 11};
    int[] dp = new int[num + 1];

    for (int i = 1; i <= num; i++) {
        dp[i] = Integer.MAX_VALUE;
    }

    dp[0] = 0;

    for (int i = 1; i <= num; i++) {
        for (int coin : coins) {
            if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }

    return dp[num];
}
