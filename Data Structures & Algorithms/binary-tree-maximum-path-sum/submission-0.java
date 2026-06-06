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

class Solution {
    int sum=Integer.MIN_VALUE;
    private int check(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int lh=check(root.left);
        int rh=check(root.right);
        lh=Math.max(lh,0);
        rh=Math.max(rh,0);
        sum=Math.max(sum,root.val+lh+rh);
        return root.val+Math.max(lh,rh);
    }
    public int maxPathSum(TreeNode root) {
       check(root);
       return sum; 
    }
}
