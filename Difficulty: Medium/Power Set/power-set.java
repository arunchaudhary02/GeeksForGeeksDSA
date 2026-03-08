// User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        // Code here
        
        List<String> result = new ArrayList<>();
        
        recursion(s, 0, result, new StringBuilder());
        
        Collections.sort(result); // required for GFG
        
        return result;
    }
    
    private void recursion(String s, int index, List<String> result, StringBuilder currentStr) {
        
        if(index >= s.length()) {
            if(currentStr.length() > 0) {
                result.add(currentStr.toString());
            }
            return;
        }
        
        currentStr.append(s.charAt(index)); // taking
        recursion(s, index + 1, result, currentStr);
        
        currentStr.deleteCharAt(currentStr.length() - 1);
        recursion(s, index + 1, result, currentStr); // Not taking
    }
}