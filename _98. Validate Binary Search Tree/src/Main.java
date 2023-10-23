class Solution {
    public boolean isValidBST(TreeNode root) {
    return recur(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean recur(TreeNode current,long l,long r)
    {
        if(current==null)
            return true;
        if(!(current.val<r&&current.val>l))
            return false;
        return recur(current.left,l,current.val)&&recur(current.right,current.val,r);
    }
}

 class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}