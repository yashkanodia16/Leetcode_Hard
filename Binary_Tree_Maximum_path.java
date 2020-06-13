// Given a non-empty binary tree, find the maximum path sum.

// For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

// Example 1:

// Input: [1,2,3]

//        1
//       / \
//      2   3

// Output: 6
// Example 2:

// Input: [-10,9,20,null,null,15,7]

//    -10
//    / \
//   9  20
//     /  \
//    15   7

// Output: 42

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        int arr[] = new int[1];
        arr[0] = Integer.MIN_VALUE;
        maxPathDown(root, arr);
        return arr[0];
    }
    private int maxPathDown(TreeNode root, int[] res) {
        if (root == null) 
            return 0;
        int left = maxPathDown(root.left, res);
        int right = maxPathDown(root.right, res);
        int temp= Math.max(Math.max(left,right) + root.val, root.val);
        int ans=  Math.max(temp, left+right+root.val);
        res[0] = Math.max(ans, res[0]);  
        return temp;
    }
}