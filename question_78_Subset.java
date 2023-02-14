import java.util.*;
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        ans.add(list1);
        int n = nums.length;

        for (int i = 1; i < (1 << n); i++) {
            List<Integer> ds = new ArrayList<Integer>();
            for (int j = 0; j < n; j++){
                if ((i & (1 << j)) > 0){
                    ds.add(nums[j]);     
                }
            }
            ans.add(ds);
        }
        return ans;
    }
}
