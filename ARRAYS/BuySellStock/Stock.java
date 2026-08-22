package ARRAYS.BuySellStock;

public class Stock {
    // brute force Only Single Transation Allowed
    public static int buyStock(int arr[]) {
        int maxPro = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; i < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    maxPro = Math.max(arr[j] - arr[i], maxPro);
                }
            }
        }
        return maxPro;
    }

    // Optimal that also single Transcation allowed

    public static int buySellstock(int arr[]) {
        int maxpro = 0;
        int minPrice = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(arr[i], minPrice);
            maxpro = Math.max(maxpro, arr[i] - minPrice);
        }
        return minPrice;
    }

    // In this the Multiple Transaction Allowed
    public static int buySellStockMulti(int arr[]) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {

    }
}
