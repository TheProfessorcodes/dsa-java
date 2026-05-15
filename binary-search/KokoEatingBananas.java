import java.util.*;

public class KokoEatingBananas{

    public static void main(String[] args){

        Solution obj=new Solution();

        int[] piles={3,6,7,11};
        int h=8;

        System.out.println(obj.minEatingSpeed(piles,h));
    }
}

class Solution{

    public int minEatingSpeed(int[] piles,int h){

        int maxPile=Arrays.stream(piles).max().getAsInt();

        int l=1,hi=maxPile;
        int ans=Integer.MAX_VALUE;

        while(l<=hi){

            int mid=l+(hi-l)/2;

            long tot=calculate(piles,mid);

            if(tot<=h){
                ans=mid;
                hi=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return ans;
    }

    long calculate(int[] piles,int mid){

        long tot=0;

        for(int pile:piles){
            tot+=(pile+mid-1)/mid;  //or ceil can be used but that causes sometimes double conversion issue
        }

        return tot;
    }
}