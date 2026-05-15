import java.util.*;

public class KthMissingPositive{

    public static void main(String[] args){

        Solution obj=new Solution();

        int[] arr={2,3,4,7,11};
        int k=5;

        System.out.println(obj.findKthPositive(arr,k));
    }
}

class Solution{

    public int findKthPositive(int[] arr,int k){

        int l=0,h=arr.length-1;

        while(l<=h){

            int mid=l+(h-l)/2;

            int missing=arr[mid]-(mid+1);

            if(missing<k){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }

        return h+1+k;
    }
}