import java.util.*;

public class MinimumDaysBouquets{

    public static void main(String[] args){

        Solution obj=new Solution();

        int[] bloomDay={1,10,3,10,2};
        int m=3;
        int k=1;

        System.out.println(obj.minDays(bloomDay,m,k));
    }
}

class Solution{

    public int minDays(int[] bloomDay,int m,int k){

        long total=(long)m*k;

        if(total>bloomDay.length)
            return -1;

        int min=Arrays.stream(bloomDay).min().getAsInt();
        int max=Arrays.stream(bloomDay).max().getAsInt();

        int l=min,h=max;
        int ans=-1;

        while(l<=h){

            int mid=l+(h-l)/2;

            int num=calculate(bloomDay,mid,k);

            if(num>=m){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return ans;
    }

    int calculate(int[] arr,int day,int k){

        int no=0,cnt=0;

        for(int i=0;i<arr.length;i++){

            if(arr[i]<=day){
                cnt++;
            }
            else{
                no+=cnt/k;
                cnt=0;
            }
        }

        no+=cnt/k;

        return no;
    }
}
