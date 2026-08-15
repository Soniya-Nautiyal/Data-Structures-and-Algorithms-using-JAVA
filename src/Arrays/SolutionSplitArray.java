import java.util.Arrays;

public class SolutionSplitArray {

	public boolean canSplit(int[] num) {
		
		
		int total =0;
		int prefSum = 0;
		for(int i =0 ; i <num.length ;i++) {
			total = total +num[i];
		}
		System.out.println("total="+total);
		
		for(int i =0 ; i <num.length ;i++) {
			
			if(total-prefSum == prefSum)
				return true;
			prefSum = prefSum+num[i];
		}
		
		return false;
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{4, 3, 2, 1};
		SolutionSplitArray arr= new SolutionSplitArray();
		
		
		System.out.println("input="+Arrays.toString(input));
		
		System.out.println("ans="+arr.canSplit(input));
		
	}

}
