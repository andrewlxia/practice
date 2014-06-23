public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        
        int closest = num[0] + num[1] + num[2];
        for(int i=0; i<num.length-2; i++) {
            int j=i+1, k=num.length-1;
            while(j < k) {
                int sum = num[i] + num[j] + num[k];
                if (Math.abs(sum-target) < Math.abs(closest-target)) {
                    closest = sum;
                } 
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return closest;
    }
}
