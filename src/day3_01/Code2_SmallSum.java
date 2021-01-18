package day3_01;

//每个数找出左边比自己小的数的和，累加
public class Code2_SmallSum {
    public int smallSum(int[] arr){
        if (arr==null||arr.length<2){
            return 0;
        }
        return process(arr, 0, arr.length-1);
    }

    public int process(int[] arr, int l, int r) {
        if (l==r){
            return 0;
        }

        int mid = l + ((r-l)>>1);

        return process(arr,l,mid)
                + process(arr,mid+1,r)
                + merge(arr,l,mid,r);
    }

    private int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int d1 = l;
        int d2 = mid+1;
        int i = 0;
        int res = 0;
        while (d1<=mid && d2<=r){//1 2 2 3 || 2 2 3 4
            res += arr[d1] < arr[d2] ? (r - d2 + 1) * arr[d1] : 0;
            help[i++] = arr[d1] < arr[d2] ? arr[d1++]:arr[d2++];
        }

        while (d1<=mid){
            help[i++] = arr[d1++];
        }

        while (d2<=r){
            help[i++] = arr[d2++];
        }

        for (i = 0; i < help.length ; i++) {
            arr[l+i] = help[i];
        }
        return res;
    }
}
