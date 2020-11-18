// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
 

// Constraints:

// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105

class Solution {
    public int trap(int[] height) {
        int sum=0;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int[] a = new int[height.length];
        int[] b = new int[height.length];
        for(int i=0;i<height.length;i++){
            max1 = Math.max(height[i],max1);
            a[i] = max1;
        } 
        for(int i=height.length-1;i>=0;i--){
            max2 = Math.max(height[i],max2);
            b[i] = max2;
        }   
        for(int i=0;i<height.length;i++){
            sum += Math.min(a[i],b[i])-height[i];
        }
        return sum;
    }
}