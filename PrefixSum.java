import java.util.*;
public class PrefixSum {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter length of the Array");
        int N=sc.nextInt();
        int[] arr=new int[N];
        System.out.println("Enter elements of an array");
        for(int i=0;i<N;i++){
            arr[i]= sc.nextInt();
        }
        int[] prefixSum=new int[N];
        prefixSum[0]=arr[0];
        for(int i=1;i<N;i++){
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }
        System.out.println("Enter number of queries");
        int Q= sc.nextInt();
        for(int i=0;i<Q;i++){
            System.out.println("Enter L");
            int L= sc.nextInt();
            System.out.println("Enter R");
            int R= sc.nextInt();
            int sum;
            if(L==0){
                sum=prefixSum[R];
            } else{
                sum=prefixSum[R]-prefixSum[L-1];
            }
            System.out.println("Sum" + sum);
        }
    }
}
//Time Complexity= O(N+Q)
//Space Complexity= O(N)
// Algorithm
//Read integer N – length of array
//Read N elements into array arr[]
//Create array prefixSum[] of size N
//
//Set prefixSum[0] = arr[0]
//
//For i = 1 to N-1:
//prefixSum[i] = prefixSum[i-1] + arr[i]
//Read integer Q – number of queries
//
//For each query:
//
//Read integers L and R
//
//If L == 0:
//sum = prefixSum[R]
//
//Else:
//sum = prefixSum[R] - prefixSum[L-1]
//
//Print the result
