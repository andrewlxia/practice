public class Solution {
    public int singleNumber2(int[] A) {
        Set <Integer> numbers = new HashSet<>();
        
        for(int a: A) {
            if(numbers.contains(a)) {
                numbers.remove(a);
            } else {
                numbers.add(a);
            }
        }
        
        Iterator itr = numbers.iterator();
        if(itr.hasNext())
        {
            return (int) itr.next();
        }
        return 0;
    }
    
    public int singleNumber(int[] A) {
        int ret = 0;
        for(int a: A) {
            ret ^= a;
        }
        return ret;
    }
}
