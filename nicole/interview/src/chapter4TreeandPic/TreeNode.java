package chapter4TreeandPic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;

/**
 * @author NicoleChen
 * @date 2018/3/23 15:09
 */
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void showList(TreeNode root){
        Queue<TreeNode> q = new LinkedBlockingQueue();
        q.add(root);

        while (!q.isEmpty()){
            TreeNode tmp = q.poll();
            System.out.println(tmp.val);

            if(tmp.left != null){
                q.add(tmp.left);
            }
            if(tmp.right != null){
                q.add(tmp.right);
            }
        }
    }



}
