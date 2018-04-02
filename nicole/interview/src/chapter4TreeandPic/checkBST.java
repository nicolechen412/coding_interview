package chapter4TreeandPic;

import java.util.ArrayList;

/**
 * @author NicoleChen
 * @date 2018/3/26 10:04
 */
public class checkBST {

    public checkBST() {
    }
   /*//可以使用静态变量的方式+数组代替传参+使用Arraylist
    public static boolean checkBST(TreeNode root){
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        copyBST(arrayList,root,0);
        for(int i = 1; i<arrayList.size(); i++){
            if(arrayList.get(i).val < arrayList.get(i - 1).val){
                return false;
            }
        }

        return true;
    }
    public static void copyBST(ArrayList<TreeNode> arrayList, TreeNode root,int level){
        if(root == null){
            return;
        }
        copyBST(arrayList,root.left,level+1);
        arrayList.add(root);
        copyBST(arrayList,root.right,level+1);
    }*/

    //方法二
   public static boolean checkBST(TreeNode root){
       return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

   }

    private static boolean checkBST(TreeNode root, int minValue, int maxValue) {
       if(root == null){
           return true;
       }

       if(root.val < minValue || root.val >= maxValue){
           return false;
       }

       if(!checkBST(root.left,minValue,root.val) || !checkBST(root.right,root.val,maxValue)){
           return false;
       }

       return true;
    }


    public static TreeNode createTree(){

        TreeNode root = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(5);
        TreeNode tn5 = new TreeNode(7);
        TreeNode tn6 = new TreeNode(9);
        TreeNode tn7 = new TreeNode(11);
        root.left = tn2;
        root.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        tn3.left = tn6;
        tn3.right = tn7;
        return root;



    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        //System.out.println(checkBST(root));
        int last_printed = Integer.MIN_VALUE;
        System.out.println(checkBST(root));

    }
}
