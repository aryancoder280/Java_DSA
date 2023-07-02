package arrays;
import java.util.*;

class PairSum {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new LinkedHashSet<Integer>();
        int first = -1,second = -1;
        int[] ans = new int[2];
        ans[1] = ans[2] = -1;
        for(int x: nums) {
        	if(set.contains(target-x)) {
        		first = x;
        		second = target-x;
        	}
        	set.add(x);	
        }
        if(first!=-1) {
        	for(int i=0;i<nums.length;i++) {
            	if(ans[0] == -1 && nums[i] == first) {
            		ans[0] = i;
            	}
            	else if(ans[1] == -1 && nums[i] == second) {
            		ans[1] = i;
            		break;
            	}
            }
        }
        return ans;
    }
}