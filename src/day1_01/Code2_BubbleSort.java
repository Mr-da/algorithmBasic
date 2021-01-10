package day1_01;

import java.util.Random;

public class Code2_BubbleSort {
    static Random random = new Random();
    //让一个数组里最大/最小的数像冒泡一样跑到右边（或者左边）
    //e-1..0 相邻元素比较，前面较大则交换位置
    //e-2..0
    //...0
    public static void bubbleSort(int [] arr){
        if (arr==null||arr.length<2) return;
        for (int  i= arr.length-1; i>0; i--) {//7 6 5 4 3 2 1
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]) {
                    swap(j,j+1,arr);
                }
            }
        }
    }

    private static void swap(int i, int j, int[] arr) {
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
            //arr[i] = random.nextInt(maxValue);
        }
        return arr;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int [] arr = generateRandomArray(10,60);
            printArray(arr);
            bubbleSort(arr);
            printArray(arr);

        }
    }

}
