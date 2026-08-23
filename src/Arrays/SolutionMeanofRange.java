
import java.util.Arrays;

public class SolutionMeanofRange {

	public boolean findMean(int[] num,
            int[][] queries) {
		
		int[] prefix= new int[num.length+1];
		
		
		for(int l =1 ; l <= num.length ;l++ ) {
			prefix[l]= prefix[l-1]+num[l-1];
		}
		
		
		
		System.out.println(Arrays.toString(prefix));
		
//		int total =0;
//		int prefSum = 0;
//		for(int i =0 ; i <=num.length ;i++) {
//			total = total +num[i];
//		}
//		System.out.println("total="+total);
		//[0, 3, 10, 12, 20, 0]
		
		for(int i =0 ; i <queries.length ;i++) {
			int totalsum = prefix[queries[i][1]+1] - prefix[queries[i][0]];
			System.out.println("total="+totalsum);
			System.out.println("total element ="+ (queries[i][1] - queries[i][0] +1));
		}
		
		return false;
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{3, 7, 2, 8, 2};
        int[][] queries = {{0, 1}, {1, 3}, {2, 4}};
        
        SolutionMeanofRange arr= new SolutionMeanofRange();
		
		
		System.out.println("input="+Arrays.toString(input));
		
		System.out.println("ans="+arr.findMean(input,queries));
		
	}

}
