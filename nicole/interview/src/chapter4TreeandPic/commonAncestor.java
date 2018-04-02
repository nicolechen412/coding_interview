package chapter4TreeandPic;

/**
 * @author NicoleChen
 * @date 2018/3/27 10:23
 */
public class commonAncestor {
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(!cover(root,p) || !cover(root,q)){
            return null;
        }else{
            return commonAncestorHelper(root,p,q);
        }

    }

    private TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        boolean is_p_on_left = cover(root.left,p);
        boolean is_q_on_left = cover(root.left,q);
        if(is_p_on_left != is_q_on_left) return root;
        TreeNode childSide = is_p_on_left?root.left:root.right;
        return commonAncestorHelper(childSide,p,q);
    }

    private boolean cover(TreeNode root, TreeNode p) {
        if(root == null) return false;
        if(root == p) return true;
        return cover(root.left,p) || cover(root.right,p);
    }
}
