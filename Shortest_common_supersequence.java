// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.

// (A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)

 

// Example 1:

// Input: str1 = "abac", str2 = "cab"
// Output: "cabac"
// Explanation: 
// str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
// str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
// The answer provided is the shortest such string that satisfies these properties.
 

// Note:

// 1 <= str1.length, str2.length <= 1000
// str1 and str2 consist of lowercase English letters.


class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
       int m = str1.length(), n = str2.length();
       int t[][] = new int[m+1][n+1];
       int i=0, j=0;
       StringBuilder s1 = new StringBuilder();
        for(i=1;i<=m;i++){
            for(j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
            }
        }
        i = m;
        j = n;
        while(i > 0 && j > 0){
            if(str1.charAt(i-1)==str2.charAt(j-1)) {
                s1.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else {
                if(t[i][j]>t[i-1][j])
                {
                    s1.append(str2.charAt(j-1));
                    j--;
                }
                else {
                    s1.append(str1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i-- > 0) {
            s1.append(str1.charAt(i));
        }
        while(j-- > 0) {
            s1.append(str2.charAt(j));
        }
        return s1.reverse().toString();
    }
}

