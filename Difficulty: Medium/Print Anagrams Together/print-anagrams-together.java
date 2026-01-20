class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        for(String str : arr) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortedStr = new String(array);
            
            if(map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            }
        }
        
        return new ArrayList<>(map.values());
    }
}
