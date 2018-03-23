package chapter4TreeandPic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NicoleChen
 * @date 2018/3/23 9:45
 * 错误的树结构
 */
public class Tree2 {

    int treeSize;
    int nodeNums;
    Node nodes[] = null;
    public Tree2() {
    }


    public Tree2(Node node,int treeSize) {
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = node;
        nodeNums++;
    }

    public void addNode(int date, int parent){
        for(int i = 0; i<treeSize; i++){
            if(nodes[i] == null){
                nodes[i] = new Node(date,parent);
                nodeNums++;
                return;
            }
        }
        throw new RuntimeException("栈已满");
    }

    public boolean isEmpty(){
        return nodes[0] == null;
    }

    public Node root(){
        return nodes[0];
    }

    public Node parent(Node node){
        return nodes[node.parent];
    }

    public List<Node> children(Node node){
        List<Node> list = new ArrayList();
        for(int i = 1; i<treeSize; i++){
            if(nodes[i] != null && parent(nodes[i]) == node){
                list.add(nodes[i]);
            }
        }
        return list;
    }

    public int deep(){
        int max= 0;
        for(int i = 0 ; i<treeSize; i++){
            int def = 0;
            int m = nodes[i].parent;
            while(m != -1 && nodes[m] != null){
                def++;
                m = nodes[m].parent;
            }
            if(max < def){
                max = def;
            }
        }
        return max;
    }

    public void showList(){
        Queue q = new Queue(nodeNums);
        List list = null;
        q.enqueue(nodes[0]);
        System.out.println(nodes[0]);
        while(!q.empty()){
            Node n = q.dequeue();
            list = children(n);
            System.out.println(children(n));
            for(int i = 0; i<list.size(); i++){
                q.enqueue((Node) list.get(i));
            }
        }

    }
}
