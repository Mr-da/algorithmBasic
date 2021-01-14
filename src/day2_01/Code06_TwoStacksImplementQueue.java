package day2_01;

import java.util.Stack;

//两个栈实现队列
public class Code06_TwoStacksImplementQueue {
    public static class MyQueue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;
        public MyQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void pushToPop(){
            if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }
        public void add(int value){
            stackPush.push(value);
        }
        public int poll(){
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }
        public int peek(){
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.peek();
        }
        public static void main(String[] args) {
            MyQueue test = new MyQueue();
            test.add(1);
            test.add(2);
            test.add(3);
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
        }
    }
}
