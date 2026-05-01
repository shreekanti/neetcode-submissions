class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        String[]  parts = path.split("/");
        Stack<String> s = new Stack<>();

        for(int i=0;i<parts.length;i++) {
            
            if(parts[i].equals("") || parts[i].equals(".")) {
                continue;
            }

            
            if(parts[i].equals("..")) {
                if(!s.isEmpty()) {
                    s.pop();
                }
            }else {
                s.push(parts[i]);
            }
        }

        StringBuilder sb =new StringBuilder();

        for(int i=0;i<s.size();i++) {
            sb.append("/").append(s.get(i));
        }

        return sb.length()==0?"/":sb.toString();




    }
}