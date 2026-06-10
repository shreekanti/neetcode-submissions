class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int sum =0;
        for(int i=0;i<matchsticks.length;i++) {
            sum+=matchsticks[i];
        }
        if(sum%4!=0) return false;

        int len = sum/4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides = new int[4];
        return f(0,sides,matchsticks,len);

    }

    public void reverse(int[] matchsticks) {
        int i=0;
        int j = matchsticks.length-1;
        while(i<j) {
            int temp = matchsticks[i];
            matchsticks[i]=matchsticks[j];
            matchsticks[j]=temp;
            i++;
            j--;
        }
    }

    public boolean f(int ind, int[] sides,int[] matchsticks,int len) {
        if(ind==matchsticks.length) {
            return true;
        }

        for(int i=0;i<4;i++) {
            if(sides[i]+matchsticks[ind]<=len) {
                sides[i]+=matchsticks[ind];
                if(f(ind+1,sides,matchsticks,len)) {
                    return true;
                }
                sides[i]-=matchsticks[ind];

            }
            
        }
        return false;
    }
}