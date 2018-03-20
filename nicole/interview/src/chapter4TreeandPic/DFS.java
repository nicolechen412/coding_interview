package chapter4TreeandPic;


import java.util.TreeMap;

/**
 * @author NicoleChen
 * @date 2018/3/19 8:39
 */
public class DFS {
    void search(Node root){
        if(root == null){
            return;
        }
        visit(root);
        root.visited = true;

        TreeMap tm = new TreeMap();

    }

    int visit(Node n){
        return n.getData();
    }
}
