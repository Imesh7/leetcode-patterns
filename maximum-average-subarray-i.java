class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double max = Integer.MIN_VALUE;
        double sum = 0.0;

        for(int i = 0; i < k; i++){
            sum += nums[i];
            max = sum;
        }

        if(n <= k){
            return sum / k;
        } else {
            for(int i = k; i < n; i++){
                double val = nums[i] + (sum - nums[i-k]);
                max = Math.max(max, val);

                sum = val;
            }
        }

        return max / k;
    }
}
