package day2_01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code07_TwoQueueImplementStack {
    //两个队列实现一个栈
    public static class MyStack<T>{//1.2.3.4
        public Queue<T> queue;
        public Queue<T> help;
        public MyStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }
        public void push(T t){
            queue.add(t);
        }

        public T pop(){
            while (queue.size()>1){
                help.add(queue.poll());
            }
            T val = queue.poll();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return val;
        }

        public T peek(){
            while (queue.size()>1){
                help.add(queue.poll());
            }
            T val = queue.poll();
            help.add(val);
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return val;
        }
        public static void main(String[] args) {
            System.out.println("test begin");
            MyStack<Integer> myStack = new MyStack<>();
            Stack<Integer> test = new Stack<>();
            int testTime = 1000000;
            int max = 1000000;
            for (int i = 0; i < testTime; i++) {
                if (myStack.isEmpty()) {
                    if (!test.isEmpty()) {
                        System.out.println("Oops");
                    }
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else {
                    if (Math.random() < 0.25) {
                        int num = (int) (Math.random() * max);
                        myStack.push(num);
                        test.push(num);
                    } else if (Math.random() < 0.5) {
                        if (!myStack.peek().equals(test.peek())) {
                            System.out.println("Oops");
                        }
                    } else if (Math.random() < 0.75) {
                        if (!myStack.pop().equals(test.pop())) {
                            System.out.println("Oops");
                        }
                    } else {
                        if (myStack.isEmpty() != test.isEmpty()) {
                            System.out.println("Oops");
                        }
                    }
                }
            }

            System.out.println("test finish!");
        }

        private boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
