package day2_01;

public class Code4_RingArray {
    //环形数组
    public static class MyQueue{
        public int arr[];
        public int pushi;
        public int polli;
        public int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value){
            if (size==limit){
                throw new RuntimeException("队列已经满了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextInt(pushi);
        }

        public int pop(){
            if (size==0){
                throw new RuntimeException("没有了，没有奇迹了");
            }
            size--;
            int value = arr[polli];
            polli = nextInt(polli);
            return value;
        }
        private int nextInt(int i) {
            return i < limit-1 ? i+1:0;
        }
    }
}
