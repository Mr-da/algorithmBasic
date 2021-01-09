package day1_01;

import java.util.Arrays;

public class Code6_NearRightExist {
    //在arr上，找满足<=value的最右位置 1 1 2 2 2  3  3 3 3 4 4 4  4 5 5 5 5 >>> 4
    public static int nearRightValue(int[] arr,int value){
        int r = arr.length-1;
        int l = 0;
        int index = -1;
        int mid;
        while (l<=r){
            mid = l+((r-l)>>1);
            if (arr[mid]<=value){
                index = mid;//
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return index;
    }

    public static int test(int[] arr,int value){
        for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i]<=value) return i;
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



    public static void main(String[] args) {
        int testTime = 100;
        int maxValue = 1000;
        int maxSize = 30;
        boolean flag = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int val = (int) ((maxValue + 1) * Math.random() - (maxValue) * Math.random());
            int i1 = test(arr, val);
            int i2 = nearRightValue(arr, val);
            if (test(arr, val) != nearRightValue(arr, val)) {
                flag = false;
                break;
            }

        }
        System.out.println(flag?"success!":"defeat!");
    }
}
