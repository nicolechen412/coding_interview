package chapter1;

import static java.lang.System.out;
/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/20 16:00
 */
public class LinkList {
    public int value;
    public LinkList next;

    public LinkList(int value) {
        this.value = value;
    }

    public static void main(String[] args){
        LinkList head = new LinkList(1);
//        out.println(addToTail(null, 2).value);
        addToTail(head, 3);
        addToTail(head, 3);
        showList(addToTail(head, 2));
    }

    public static LinkList addToTail(LinkList head, int value) {
        if(head == null){
            head = new LinkList(value);
        }else {
            LinkList tail = new LinkList(value);
            LinkList tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = tail;
        }
        return head;
    }

    public static LinkList delByValue(LinkList head, int value){
        if(head == null)
            return null;
        LinkList pre = new LinkList(-1);
        pre.next = head;
        LinkList tmp = pre;
        while(tmp.next != null){
            if(tmp.next.value == value){
                tmp.next = tmp.next.next;
                break;
            }else{
                tmp = tmp.next;
            }
        }
        return pre.next;

    }


    public static void showList(LinkList head){
        if(head == null){
            out.println("Empty LinkList");
            return;
        }
        while(head != null){
            out.print(head.value + "\t");
            head = head.next;
        }
        out.println();
    }

    public static void delDuplica(LinkList head){

    }
}
