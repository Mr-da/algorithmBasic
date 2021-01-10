package day1_01;


public class Code1_SelectionSort {
    //选择排序：把arr[i]~arr[n]最小的选出来放在左边
    //0 找到最小值，在哪，放到0位置上
    //1 找到最小值，在哪，放到1位置上
    //...
    public static void selectionSort(int [] arr){
        if (arr ==null || arr.length<2) return;
        for (int i = 0; i < arr.length; i++) {
            int min=i;
            for (int j = i+1; j < arr.length; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            swap(min,i,arr);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        int [] arr = {2,-4,3,5,-1,4,-3,8,6,1,7,9,11};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }

}
