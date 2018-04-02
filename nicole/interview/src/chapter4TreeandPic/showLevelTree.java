package chapter4TreeandPic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author NicoleChen
 * @date 2018/3/26 10:08
 */
public class showLevelTree {
    public showLevelTree(TreeNode n) {
    }

    //题目4.4，若一棵树的深度为D，则创建D个链表(广度搜索)
    public void showLevelTree(TreeNode root){
        ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<>();
        LinkedList<TreeNode> linkedList;
        Queue<TreeNode> q = new LinkedBlockingQueue();

        q.add(root);
        linkedList = new LinkedList<>();
        linkedList.add(root);
        arrayList.add(linkedList);

        while(!q.isEmpty()){
            linkedList = new LinkedList<>();
            while (!q.isEmpty()){
                TreeNode tmp = q.poll();
                if(tmp.left != null){
                    linkedList.add(tmp.left);
                }
                if(tmp.right != null){
                    linkedList.add(tmp.right);
                }
            }
            for(TreeNode tn : linkedList){
                q.add(tn);
            }
            arrayList.add(linkedList);
        }

        for(LinkedList<TreeNode> list: arrayList){
            for(TreeNode tn : list){
                System.out.print(tn.val+" ");
            }
            System.out.println();
        }

    }
    //方法二(广度搜索)
    public void showLevelTree3(TreeNode root){
        ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root != null){
            current.add(root);
        }
        while(current.size() > 0){
            arrayList.add(current);
            LinkedList<TreeNode> parent = current;
            current = new LinkedList<>();
            for(TreeNode tn : parent){
                if(tn.left != null){
                    current.add(tn.left);
                }
                if(tn.right != null){
                    current.add(tn.right);
                }
            }

        }
        for(LinkedList<TreeNode> list: arrayList){
            for(TreeNode tn : list){
                System.out.print(tn.val+" ");
            }
            System.out.println();
        }

    }
    //题目4.4 (深度搜索)
    public void showLevelTree2(TreeNode root){
        ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<>();

        createLevelLinkedList(root,arrayList,0);
        for(LinkedList<TreeNode> list: arrayList){
            for(TreeNode tn : list){
                System.out.print(tn.val+" ");
            }
            System.out.println();
        }
    }

    private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> arrayList, int level) {

        if(root == null) return;
        LinkedList<TreeNode> list;
        if(level == arrayList.size()){
            list = new LinkedList<>();
            arrayList.add(list);
        }else{
            list = arrayList.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left,arrayList,level+1);
        createLevelLinkedList(root.right,arrayList,level+1);


    }
}
