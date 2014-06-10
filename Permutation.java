public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> allPerms = new ArrayList<List<Integer>> ();
        List<Integer> curPerm = new ArrayList <> ();
        
        boolean [] picked = new boolean[num.length];
        for (int i=0; i<picked.length; i++){
            picked[i] = false;
        }
        
        permuteRecur(num, picked, 0, allPerms, curPerm);
        return allPerms;
    }
    
    private void permuteRecur(int [] num, boolean [] picked, int numPicked, List<List<Integer>> allPerms, List<Integer> curPerm) {
        if (numPicked == num.length) {
            allPerms.add(new ArrayList(curPerm));
        }
        
        for (int i=0; i<num.length; i++) {
            if(picked[i] != true) {
                picked[i] = true;
                curPerm.add(num[i]);
                permuteRecur(num, picked, numPicked+1, allPerms, curPerm);
                curPerm.remove(curPerm.size()-1);
                picked[i] = false;
            }
        }
    }
}
