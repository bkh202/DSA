package ARRAYS.Permutation;

public class NextPermutation {
    public static void reverse(int arr[], int st, int ed) {
        while (st < ed) {
            swap(arr, st++, ed--);
        }   
    }

    public static void swap(int arr[], int st, int ed) {
        int temp = arr[st];
        arr[st] = arr[ed];
        arr[ed] = temp;
    }

    public static void nextPermutation(int arr[]) {
        int pivot = -1;
        int n = arr.length;
        // to find pivot Index
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }
        // if not find the revese the whole array
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
        }

        // if found the index the swap
        for (int i = n - 1; i > pivot; i--) {
             if(arr[i] > arr[pivot]){
               swap(arr, i, pivot);
                break;
             }
        }
        // and reverse the pivot+1 to n-1
        reverse(arr, pivot + 1, n - 1);
    }

    public static void main(String[] args) {
            int arr[]={2, 4, 1, 7, 5, 0};
            nextPermutation(arr);
            for(int ans : arr){
                System.out.print(ans +" ");
            }
    }
}
