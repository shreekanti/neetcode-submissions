class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);

        int i=0;
        int j=n-1;
        int min =0;
        while(i<j) {
            if(people[i]+people[j]<limit) {
                i++;
                j--;
                min+=1;
            }else if(people[i] +people[j]>limit){
                if(people[j]<=limit) {
                    min+=1;
                    j--;
                }else if(people[i]<=limit){
                    min+=1;
                    i++;

                }
            }else{
                min+=1;
                i++;
                j--;
            }

        }
        if(i==j && people[i]<=limit) {
            min+=1;
        } 
        return min;
    }
}