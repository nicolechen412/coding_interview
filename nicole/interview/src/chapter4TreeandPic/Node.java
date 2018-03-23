package chapter4TreeandPic;

import chapter3StackAndQueue.Queue;

/**
 * @author NicoleChen
 * @date 2017/12/20 21:45
 * java:linkedlist
 */
public class Node {

    int parent;  //保存父节点的位置
    int data;
    boolean visited;


    public Node() {
    }

    public Node(int d,int parent){
        this.data = d;
        this.parent = parent;
    }



    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }


}
