class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> s = new Stack<>();

        

        for(int i=0;i<n;i++) {

            
            boolean current = false;
            while(!s.isEmpty() && ((s.peek()>0 && asteroids[i]<0) )) {
                if(Math.abs(s.peek())<Math.abs(asteroids[i])) {
                    s.pop();
                }else if(Math.abs(s.peek())==Math.abs(asteroids[i])) {
                    s.pop();
                    current = true;
                    break;
                }else {
                    current = true;
                    break;
                }
            }
            if(!current) {
                s.push(asteroids[i]);
            }
            
            
        }

        int[] res = new int[s.size()];
        int ind=0;

        for(int i=s.size()-1;i>=0;i--) {
            res[i] =s.pop();
        }
        
        return res;

    }
}