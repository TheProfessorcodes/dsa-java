import java.util.*;

public class ShipWithinDays{

    public static void main(String[] args){

        Solution obj=new Solution();

        int[] weights={1,2,3,4,5,6,7,8,9,10};
        int days=5;

        System.out.println(obj.shipWithinDays(weights,days));
    }
}

class Solution{

    public int shipWithinDays(int[] weights,int days){

        int l=Arrays.stream(weights).max().getAsInt();
        int h=Arrays.stream(weights).sum();

        int ans=0;

        while(l<=h){

            int mid=l+(h-l)/2;

            int day=calculate(weights,mid);

            if(day<=days){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return ans;
    }

    int calculate(int[] w,int max){

        int day=1,load=0;

        for(int i=0;i<w.length;i++){

            if(w[i]+load>max){
                day++;
                load=w[i];
            }
            else{
                load+=w[i];
            }
        }

        return day;
    }
}