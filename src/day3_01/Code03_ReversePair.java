package day3_01;

public class Code03_ReversePair {
    //找出逆序对的数量
    public static int reversePairNum(int[] arr){
        if (arr==null||arr.length<2){
            return 0;
        }
        return process(arr,0,arr.length-1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l==r) return 0;
        int m = l + ((r-l) >> 1);
        return process(arr,l,m)+process(arr,m+1,r)+merge(arr,l,m,r);
    }

    private static int merge(int[] arr, int l, int m, int r) {
        //2 3 3 5 6 | 1 2 2 3 3
        //........m | ........r
        int p1 = m;
        int p2 = r;
        int[] help = new int[r-l+1];
        int i = r-l;
        int num = 0;
        while (p1>=l && p2>=m+1){
            num += arr[p1] > arr[p2] ? (p2 - m) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= l){
            help[i--] = arr[p1--];
        }
        while (p2 > m){
            help[i--] = arr[p2--];
        }
        for (i = 0;i<help.length;i++){
            arr[i+l] = help[i];
        }
        return num;
    }
}
