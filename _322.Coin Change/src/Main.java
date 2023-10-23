class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minsum=new int[amount+1];
        for(int i=1;i<minsum.length;i++)
        {
            minsum[i]=Integer.MAX_VALUE;
        }
        boolean[] have=new boolean[amount+1];
        have[0]=true;
        int tmp;
        for(int i=0;i<minsum.length;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(i-coins[j]<0||have[i-coins[j]]==false)
                    continue;
                tmp=1+minsum[i-coins[j]];
                minsum[i]=Math.min(minsum[i],tmp);
                have[i]=true;
            }
        }
        if(have[amount])
        return minsum[amount];
        else return -1;
    }
}
public class Main {


    public static int countcoin (int[]coins,int sum)
    {

        int[] minsum=new int[sum+1];
        for(int i=1;i<minsum.length;i++)
        {
            minsum[i]=Integer.MAX_VALUE;
        }
        boolean[] have=new boolean[sum+1];
        boolean search=false;
        int tmp;
        for(int i=0;i<minsum.length;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(i-coins[j]<0)
                    continue;
                tmp=1+minsum[i-coins[j]];
                minsum[i]=Math.min(minsum[i],tmp);
            }
        }
        return minsum[sum];
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}