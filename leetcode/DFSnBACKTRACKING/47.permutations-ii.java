import java.util.ArrayList;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (41.59%)
 * Likes:    1136
 * Dislikes: 46
 * Total Accepted:    262.1K
 * Total Submissions: 629.9K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int[] checkArr = new int[nums.length];
        Arrays.sort(nums);
        dfs(nums, res, checkArr, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, int[] checkArr, ArrayList<Integer> path) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            //remove duplicate 
            // if (checkArr[i] == 1 || (i>0 && nums[i]==nums[i-1] && checkArr[i-1]==0)) continue;
            if (checkArr[i] == 1) continue;
            path.add(nums[i]);
            checkArr[i] = 1;
            dfs(nums, res, checkArr, path);
            path.remove(path.size()-1);
            checkArr[i] = 0;
            while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
        }
    }
}

