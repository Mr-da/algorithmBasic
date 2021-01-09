package day1_01;

import java.util.Arrays;

//二分法找存在数
public class Code4_BSExist {
    public static boolean exist(int[] arr,int num){
        int L = 0;
        int R = arr.length-1;
        int mid;
        while (L<=R){
            mid = L+((R-L)>>1);
            if (arr[mid]==num){
                return true;
            }else if (arr[mid]>num){
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return false;
    }

    public static boolean test(int[] arr,int num){
        for (int i : arr) {
            if (i==num) return true;
        }
        return false;
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
        int testTime = 1000;
        int maxValue = 1000;
        int maxSize  = 30;
        boolean flag = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr,value)!=exist(arr,value)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag?"success!":"defeat!");
    }
}
