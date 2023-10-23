class Solution {
    private  TreeNode LCA;
    Solution()
    {
        this.LCA=null;
    }
    public int recur(TreeNode root, TreeNode p, TreeNode q)
    {
    
        int l=0;
        int r=0;
        int self=0;
        if(root==p)
        self=1;
        if(root==q)
        self=2;
        if(root.left!=null)
        {
            l=recur(root.left,p,q);
            if(l==3&&this.LCA==null)
            {
                this.LCA=root.left;
            }
        }
        
        if(root.right!=null)
        {
            r=recur(root.right,p,q);
            if(r==3&&this.LCA==null)
            {
                this.LCA=root.right;
            }
        }
        if(l+r+self==3&&this.LCA==null)
        this.LCA=root;

        return(r+l+self);

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recur(root,p,q);
        TreeNode result=this.LCA;
        this.LCA=null;
        return result;
    }
}
class Solution{
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    }
}