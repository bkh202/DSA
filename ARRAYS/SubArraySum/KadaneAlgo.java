package ARRAYS.SubArraySum;

public class KadaneAlgo {
    // brute force
    public static int sum(int arr[]){
        int n=arr.length;
         int max=0;
        for(int i=0; i< n;i++){
            for(int j=i; j<n;j++){
                int sum=0;
                for(int k=i; k<j;k++){
                    sum+=arr[k];
                    max=Math.max(sum,max);
                }
            }
        }
        return max;
    }
  // Better
     public static int sum2(int arr[]){
        int n=arr.length;
         int max=0;
        for(int i=0; i< n;i++){
            int sum=0;
            for(int j=i; j<n;j++){
                    sum+=arr[j];
                    max=Math.max(sum,max);
            }
        }
        return max;
    }

    // optimal
    public static int kadaneAlgo(int arr[]){
        int max=0;
        int sum=arr[0];
        for(int i=0;i<arr.length;i++){
            sum =Math.max(sum, sum+arr[i]);
            max= Math.max(max, sum);
        }
        return max;
    }
   public static void main(String[] args) {
    
   }
    
}