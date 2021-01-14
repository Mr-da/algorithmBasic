package day2_01;

import java.util.Stack;

public class Code05_GetMinStack {
    public static class MyStack{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;
        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        public void push(int newNum){
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum < this.getmin()) {
                this.stackMin.push(newNum);
            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(newNum);
        }
        public int pop(){
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }
        public int getmin(){
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
        public static void main(String[] args) {
            MyStack stack1 = new MyStack();
            stack1.push(3);//3
            System.out.println(stack1.getmin());
            stack1.push(4);//3
            System.out.println(stack1.getmin());
            stack1.push(1);
            System.out.println(stack1.getmin());//1
            System.out.println(stack1.pop());//1
            System.out.println(stack1.getmin());//3

            System.out.println("=============");

            MyStack stack2 = new MyStack();
            stack2.push(3);
            System.out.println(stack2.getmin());
            stack2.push(4);
            System.out.println(stack2.getmin());
            stack2.push(1);
            System.out.println(stack2.getmin());
            System.out.println(stack2.pop());
            System.out.println(stack2.getmin());
        }
    }

}
