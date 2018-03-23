package chapter4TreeandPic;

import sun.reflect.generics.tree.Tree;

/**
 * @author NicoleChen
 * @date 2018/3/23 15:10
 */
public class isBalanced {
    public static void main(String[] args) {

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);

        tn1.setLeft(tn2);
        tn1.setRight(tn3);
        tn2.setLeft(tn4);
        tn2.setRight(tn5);
        tn3.setLeft(tn6);
        tn3.setRight(tn7);

        System.out.println(isBalanced(tn1));
    }


    public static boolean isBalanced(TreeNode node){
        if(checkHeight(node) == -1){
            return false;
        }else{
            return true;
        }
    }

    private static int checkHeight(TreeNode node) {

        if(node == null){
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = checkHeight(node.right);
        if(rightHeight == -1){
            return -1;
        }
        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1){
            return -1;
        }else{
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
}
