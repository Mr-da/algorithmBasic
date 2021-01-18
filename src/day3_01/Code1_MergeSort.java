package day3_01;

//归并排序
public class Code1_MergeSort {
    public void sort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        process(arr,0,arr.length-1);
    }

    public void process(int[] arr, int l, int r) {
        if (arr==null||arr.length<2){
            return;
        }
        int mid = l + ((r-l)>>1);
        process(arr,l,mid);
        process(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int d1 = l;
        int d2 = mid+1;
        int i = 0;
        while (d1<=mid && d2<=r){
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

    }

    //非递归方法
    public void merge2(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N){
            int L = 0;
            while (L < N){
                if (mergeSize >= N - L) {
                    break;
                }
                int M = L+mergeSize-1;
                int R = M+Math.min(mergeSize , N - M - 1);//最后一次加mergeSize可能会超过数组长度
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N/2){
                return;
            }
            mergeSize >>=1;
        }

    }
}
