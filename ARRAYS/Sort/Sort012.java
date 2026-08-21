package ARRAYS.Sort;

public class Sort012 {
    // brute force 
    public static void sort(int arr[]) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                count0++;
            else if (arr[i] == 1)
                count1++;
            else
                count2++;
        }

        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }
        for (int i = count0; i < count0 + count1; i++) {
            arr[i] = 1;
        }
        for (int i = count0 + count1; i < n; i++) {
            arr[i] = 2;
        }

    }
       // optimal
    public static int[] Sort0s1s2s(int arr[]) {

        int nextZero = 0;
        int nextTwo = arr.length - 1;
        int i = 0;
        while (i <= nextZero) {
            if (arr[i] == 0) {
                int temp = arr[nextZero];
                arr[nextZero] = arr[i];
                arr[i] = temp;
                nextZero++;
                i++;

            } else if (arr[i] == 2) {
                int temp = arr[nextTwo];
                arr[nextTwo] = arr[i];
                arr[i] = temp;
                nextTwo--;
            } else {
                i++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 0, 1, 2, 1, 0 };
        int ans[] = Sort0s1s2s(arr);

        for (int res : ans) {
            System.out.print(res + " ");
        }

    }
}
