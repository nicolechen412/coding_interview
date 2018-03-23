package chapter4treemap;

import chapter2linklist.LinkList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.System.out;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/23 11:20
 */
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20);
        TreeNode node18 = new TreeNode(18);
        TreeNode node22 = new TreeNode(22);
        root.left = node5; root.right = node20;
        node5.left = node4; node5.right = node7;
        node20.left = node18; node20.right = node22;


//        out.println(depth(node22));
//        out.println(root.isBalance(root));
//        out.println(isBalanceByDepth(root));
//        levelTraversal(root);

        /*int[] arr = new int[]{1,4,5,5,7,8,10,19};
        levelTraversal(createMinimalBST(arr, 0, arr.length-1));*/
//        createLevelLinkedList1(root);

        ArrayList<Integer> values = new ArrayList<>();
        rootMiddleTraversal(root, values);
        out.println(values);

        out.println(checkBST(root));
    }

    public boolean isBalance(TreeNode root) {
        if(root == null)
            return true;
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        if(Math.abs(lDepth-rDepth) <= 1){
            return isBalance(root.left)&&isBalance(root.right);
        }else
            return false;

    }
    public static int depth(TreeNode root){
        if(root == null)
            return 0;
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
    }
    //isBalance中调用的depth，几乎每次都要遍历分支，效率低，O(nlogn)
    //其实在计算depth的时候就可以知道树是否平衡

    public static int isBalanceByDepth(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = isBalanceByDepth(root.left);
        if(leftHeight == -1)
            return -1;
        int rightHeight = isBalanceByDepth(root.right);
        if(rightHeight == -1)
            return -1;

        if(Math.abs(leftHeight-rightHeight) > 1)
            return -1;
        else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    public static void levelTraversal(TreeNode root){
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        TreeNode currentNode;
        while(!queue.isEmpty()){
            currentNode = queue.poll();
            if(currentNode.left != null)
                queue.add(currentNode.left);
            if(currentNode.right != null)
                queue.add(currentNode.right);
            System.out.println(currentNode.val);
        }
    }

    public static TreeNode createMinimalBST(int[] arr, int start, int end){
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createMinimalBST(arr, start, mid-1);
        node.right = createMinimalBST(arr, mid+1, end);
        return node;
    }

    //层序遍历
    public static void createLevelLinkedList1(TreeNode root){
        if(root == null)
            return;
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();


        LinkedList<TreeNode> currentLevel;
        currentLevel = new LinkedList<>();
        currentLevel.add(root);
        result.add(currentLevel); //把第一层加入到结果中去

        queue.add(root);

        while(!queue.isEmpty()){
            currentLevel = new LinkedList<>();
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                TreeNode tmp = queue.get(0);
                if(tmp.left != null){
                    currentLevel.add(tmp.left);
                    queue.add(tmp.left);
                }
                if(tmp.right != null) {
                    currentLevel.add(tmp.right);
                    queue.add(tmp.right);
                }
                queue.removeFirst();
            }
            result.add(currentLevel);
        }
        result.remove(result.size()-1);
        System.out.println(result.get(0).size());

    }
    //深度优先遍历
    public static void createLevelLinkedList2(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        createLevelLinkedList(root, result, 0);
    }
    private static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int level) {
        if(root == null)
            return;
        LinkedList<TreeNode> list = null;
        if(result.size() == level){
            list = new LinkedList<>();
            result.add(list);
        }else{
            list = result.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, result, level+1);
        createLevelLinkedList(root.right, result, level+1);

    }

/*
 * 检查一课二叉树是否为二叉查找树
 * 1. 中序遍历，如果结果是递增的，那么就是。前提是没有重复的数值
 * 2. 还是中序遍历，但是不要中途就可以判断，记录上一个节点的值，只要下一个比上一个大，那么就没问题
 */
//方法1
    public static void rootMiddleTraversal(TreeNode root, ArrayList<Integer> values){
        if(root == null)
            return;
        rootMiddleTraversal(root.left, values);
        values.add(root.val);
        rootMiddleTraversal(root.right, values);
    }
//方法2
    public static int lastPrepareValue = Integer.MIN_VALUE;
    public static boolean checkBST(TreeNode root){
        if(root == null)
            return true;
        //先左边，正常会返回true
        if(!checkBST(root.left))
            return false;

        //根节点和上一次的值比较，大的话就可以
        if(root.val <= lastPrepareValue)
            return false;
        lastPrepareValue = root.val;

        //最后右边
        if(!checkBST(root.right))
            return false;
        return true;
    }



}
