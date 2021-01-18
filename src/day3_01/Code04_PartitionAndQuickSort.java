package day3_01;
//递归方法帮我们记下划分的位置|=x|,左侧右侧继续执行递归
public class Code04_PartitionAndQuickSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // arr[L..R]上，以arr[R]位置的数做划分值
    public static int partition(int[] arr, int L, int R){
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessLine = L-1;
        int index = L;
        //5 4 1 3 7 8 3
        while (index<R){
            if (arr[index]<=arr[R]){
                swap(arr,index,++lessLine);
            }
            index++;
        }
        swap(arr,R,++lessLine);
        return lessLine;
    }


    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    //1.0 返回x的位置
    //时间复杂度n2，差情况必命中
    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // L..R partition arr[R] [ <=arr[R] arr[R] >arr[R] ]
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    // arr[L...R] 排有序，快排2.0方式
    //时间复杂度n2，差情况必命中
    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // [ equalArea[0]  ,  equalArea[0]]
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }

    //荷兰国旗 <x|=x|>x 三分 指定最右边为筛选参数
    //2.返回=x的索引数组
    public static int[] netherlandsFlag(int[] arr, int l, int r) {
        if (l>r){
            return new int[]{-1,-1};
        }
        if (l==r){
            return new int[]{l,r};
        }
        int less = l-1;
        int more = r;
        int index = l;
        while (index < more){//2 3 4 1 2 5 6 3 == 2 2  1 3 3 5 6 4
            if (arr[index]==arr[r]){
                index++;
            }else if (arr[index]<arr[r]){
                swap(arr,index++,less++);
            }else {
                swap(arr,index,more--);
            }
        }
        swap(arr,r,more);
        return new int[]{less+1,more};
    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    //3.随机筛选参数
    public static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, R, (int) (Math.random()*(R-L+1)));//时间复杂度N*logN，所有随机数的期望结果(T(N/3)+T(2N/3)+O(N)等式子)
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
    }
}
