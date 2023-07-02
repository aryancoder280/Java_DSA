package arrays;

import java.util.*;

public class SubArrayWithZeroSum {
	static boolean findsum(int arr[],int n)
    {
		boolean present = false;
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		for(int x: arr) {
			sum+=x;
			if(sum == 0 || set.contains(sum)) {
				present = true;
				break;
			}
			set.add(sum);
		}
		return present;
    }
}
