//Prefix sum approad O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] front = new int[n];
        int[] back = new int[n];

        front[0] = nums[0];
        back[n-1] = nums[n-1];

        for(int i = 1; i < n; i++){
            front[i] = front[i-1] * nums[i];   
        }

        for(int i = n-2; i >= 0; i--){
            back[i] = back[i+1] * nums[i];   
        }

        res[0] = back[1];
        res[n-1] = front[n-2];

        for(int i = 1; i < n-1; i++){
            res[i] = front[i-1] * back[i+1];
        }
        return res;
    }
}


//Optimal Solution O(n) & space conplexity O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int cur = 1;
        Arrays.fill(res, 1);

        for(int i = 0; i < n; i++){
            res[i] *= cur;
            cur *= nums[i];
        }

        cur = 1;
        for(int i = n-1; i >= 0; i--){
             res[i] *= cur;
             cur *= nums[i];
        }

        return res;
    }
}
