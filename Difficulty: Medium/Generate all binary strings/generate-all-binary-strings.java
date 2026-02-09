class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        
        ArrayList<String> ans = new ArrayList<>();
        helper(n, "", ans);
        
        return ans;
    }
    
    private void helper(int n, String current, ArrayList<String> ans) {
        if(current.length() == n) {
            ans.add(current);
            return;
        }
        
        helper(n, current + "0", ans);
        helper(n, current + '1', ans);
    }
}
