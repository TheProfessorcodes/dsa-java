import java.util.*;

public class SmallestDivisor{

    public static void main(String[] args){

        Solution obj=new Solution();

        int[] nums={1,2,5,9};
        int threshold=6;

        System.out.println(obj.smallestDivisor(nums,threshold));
    }
}

class Solution{

    public int smallestDivisor(int[] nums,int threshold){

        int l=1;
        int h=Arrays.stream(nums).max().getAsInt();

        int ans=0;

        while(l<=h){

            int mid=l+(h-l)/2;

            int sum=calculate(nums,mid);

            if(sum<=threshold){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return ans;
    }

    int calculate(int[] nums,int mid){

        int sum=0;

        for(int n:nums){
            sum+=(n+mid-1)/mid;
        }

        return sum;
    }
}