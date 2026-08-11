package mergesortedarray;

import java.util.Arrays;
import java.util.HashMap;

class TwoSum{
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> cache = new HashMap<>();
        int i=0;
        int[] result= new int[2];

        while(i < nums.length){
    
            int searchE = target - nums[i];
            if(cache.containsKey(searchE)){
                result[0]= cache.get(searchE);
                result[1] = i;
            }else{
                cache.put(nums[i], i);
            }
             i++;

        }
        return result;
    }
    public static void main(String[] args)
	{
        int[] array1= new int[]{0,3,4,31};
        int target =7;
        TwoSum twosum = new TwoSum();
        System.out.println(Arrays.toString(twosum.twoSum(array1, target)));
    }
}