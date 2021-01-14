package day2_01;

//
public class Code8_GetMax {
    public int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l==r){
            return arr[l];
        }
        int mid = l+((r-l)>>1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid+1, r);

        return Math.max(leftMax,rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,9,7,6,8,10,13,15,14,11};
        System.out.println(arr.length);
        System.out.println(process(arr,3,13));
    }
}
