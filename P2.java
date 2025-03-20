/*
DP Bottom Up

Time Complexity: 
O(N^2 )
Outer loop runs N times.
Inner loop runs N times in the worst case.
Checking substring in HashSet takes O(1).

Space Complexity: 
O(N)
dp array of size N+1.
HashSet storing wordDict.

The code iterates through s, checking if any prefix s[j:i] is in wordDict and if dp[j] is true. 
If both conditions hold, dp[i] is marked true, meaning s[0:i] is breakable. Finally, dp[s.length()] is returned as the result.
 */

 class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean [] dp = new boolean [s.length() + 1];

        HashSet <String> set = new HashSet<>(wordDict);

        dp[0] = true;

        for(int i = 1; i < dp.length; i++){

            for(int j = 0; j < i; j++){

                if(dp[j] && set.contains(s.substring(j,i))){

                    dp[i] = true;

                }

            }

        }

        return dp[dp.length - 1];

    }

}
