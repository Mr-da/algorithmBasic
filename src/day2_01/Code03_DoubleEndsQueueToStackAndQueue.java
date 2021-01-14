package day2_01;

public class Code03_DoubleEndsQueueToStackAndQueue {
    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T data) {
            value = data;
        }
    }

    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T value) {//1   2,4,
            Node node = new Node(value);
            if (head==null){
                tail = node;
            }else {
                head.last = node;
                node.next = head;
            }
            head = node;
        }

        public void addFromBottom(T value) {
            Node node = new Node(value);
            if (head==null){
                head = node;
            }else {
                tail.next = node;
                node.last = tail;
            }
            tail = node;
        }

        public T popFromHead() {
            T value;
            if (head == null){
                return null;
            }else {
                value = head.value;
                Node next = head.next;
                next.last = null;
                head = next;
            }
            return value;
        }

        public T popFromBottom() {
            return null;
        }

        public boolean isEmpty() {
            return head == null;
        }

    }

    public static class MyStack<T> {


    }

    public static class MyQueue<T> {

    }
}
