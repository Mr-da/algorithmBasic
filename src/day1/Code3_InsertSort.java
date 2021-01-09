package day1;

public class Code3_InsertSort {
    //0~i 做到有序，右边无序一个个比较插入
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0; j--) {
                if (arr[j]<arr[j-1]) {
                    swap(j,j-1,arr);
                }
            }
        }
    }

    private static void swap(int j, int i, int[] arr) {
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
            arr[i] = (int) ((maxValue + 1) * Math.random()-(maxValue) * Math.random());
            //arr[i] = random.nextInt(maxValue);
        }
        return arr;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            int [] arr = generateRandomArray(12,60);
            //printArray(arr);
            insertionSort(arr);
            printArray(arr);

        }
    }

}
