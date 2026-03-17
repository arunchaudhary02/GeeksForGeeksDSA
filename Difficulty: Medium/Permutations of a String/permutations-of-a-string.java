/*

class Solution {
    
    ArrayList<String> result = new ArrayList<>();
    
    public ArrayList<String> findPermutation(String s) {
        // Code here
        
        if(s.length() == 0) {
            return result;
        }
        
        backtrack(new StringBuilder(), s, new boolean[s.length()]);
        
        return result;
    }
    
    private void backtrack(StringBuilder perm, String s, boolean[] visited) {
        
        if(perm.length() == s.length() && !result.contains(perm.toString())) {
            result.add(perm.toString());
            return;
        }
        
        for(int i = 0; i < s.length(); i++) {
            
            if(visited[i]) {
                continue;
            }
            
            visited[i] = true;
            perm.append(s.charAt(i));
            
            backtrack(perm, s, visited);
            
            visited[i] = false;
            perm.deleteCharAt(perm.length() - 1);
        }
    }
    
}

*/




class Solution {
    
    ArrayList<String> result = new ArrayList<>();
    
    public ArrayList<String> findPermutation(String s) {
        
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // IMPORTANT
        
        backtrack(new StringBuilder(), chars, new boolean[chars.length]);
        
        return result;
    }
    
    private void backtrack(StringBuilder perm, char[] chars, boolean[] visited) {
        
        if(perm.length() == chars.length) {
            result.add(perm.toString());
            return;
        }
        
        for(int i = 0; i < chars.length; i++) {
            
            if(visited[i]) continue;
            
            // 🔥 Skip duplicates
            if(i > 0 && chars[i] == chars[i-1] && !visited[i-1]) continue;
            
            visited[i] = true;
            perm.append(chars[i]);
            
            backtrack(perm, chars, visited);
            
            visited[i] = false;
            perm.deleteCharAt(perm.length() - 1);
        }
    }
}

