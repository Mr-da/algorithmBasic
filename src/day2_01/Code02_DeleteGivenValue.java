package day2_01;

//单向链表删掉一个数
public class Code02_DeleteGivenValue {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node deleteValue(int value,Node head){
        //让head来到第一个不需要被删的node，前面的都跳过
        //遍历
        while (head!=null){
            if (head.value!=value){
                break;
            }
            head = head.next;
        }
        Node pre = head;//上一个不为value的位置
        Node cur = head;//遍历节点所到达的位置
        while (cur!=null){
            if (cur.value==value){
                pre.next = cur.next;//直接跳过当前节点
            }else {
                pre = cur;//pre跟随cur来到下一个不为value的节点
            }
            cur = cur.next;
        }
        return head;
    }
}
