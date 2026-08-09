class Result {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
    // Write your code here
    
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0 ;i<arr.size(); i++){
        int need = m - arr.get(i);
        if(need >0){
            if(map.containsKey(need)){
                return List.of(map.get(need) + 1, i + 1);
            }
        }
        map.put(arr.get(i), i);
    }
    return List.of();
    }

}
