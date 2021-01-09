package day1_01;

import java.util.Arrays;

// 在arr上，找满足>=value的最左位置 1 1 2 2 2 3 3 3 3 4 5 6 7 7 8 8 8 8 8 9 9 9 9 9
public class Code5_NearLeafExist {
    public static int nearLeftIndex(int[] arr,int val){
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        int mid;
        while (l<=r){
            mid = l + ((r-l)>>1);
            if (arr[mid]>=val){
                index = mid;//达标的记录
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return index;
    }

    public static int test(int[] arr,int val){
        for (int i = 0; i < arr.length; i++) {
            if (val <= arr[i]) return i;//1 1 2 2 2
        }
        return -1;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()-(maxValue) * Math.random());
            //arr[i] = random.nextInt(maxValue);
        }
        return arr;
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

    public static void main(String[] args) {
        int testTime = 100;
        int maxValue = 1000;
        int maxSize  = 30;
        boolean flag = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int val = (int) ((maxValue + 1) * Math.random()-(maxValue) * Math.random());
            int i1 = test(arr, val);
            int i2 = nearLeftIndex(arr, val);
            if (test(arr,val)!=nearLeftIndex(arr,val)){
                flag = false;
                printArray(arr);
                System.out.println(val);
                System.out.println(test(arr, val));
                System.out.println(nearLeftIndex(arr, val));
                System.out.println(i);
                break;
            }

        }
        System.out.println(flag?"success!":"defeat!");
    }
}
