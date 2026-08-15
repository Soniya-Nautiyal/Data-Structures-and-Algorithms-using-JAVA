import java.util.Arrays;

public class PrefixSumArray {

	public int findEquilibrium(int[] num) {
		
		//num=[10, 20, 10, 5, 15]
		//output= [10, 30, 40, 45, 60]
//		
//		int[] prefix= new int[num.length];
//		prefix[0]= num[0];
//		
//		for(int l =1 ; l < num.length ;l++ ) {
//			prefix[l]= prefix[l-1]+num[l];
//		}
//		
//		
//		
//		System.out.println(Arrays.toString(prefix));
//		
		
		//approch 1
		/*
		int[] suffix= new int[num.length];
		suffix[num.length-1]= num[num.length-1];
		
		for(int l =num.length -2 ; l >=0 ;l--) {
			suffix[l]= suffix[l+1]+num[l];
		}
		System.out.println(Arrays.toString(suffix));
		
		for(int i =0 ; i <num.length ;i++) {
			if(prefix[i]== suffix[i])
				return i;
		}*/
		
		//approch 2
		int total =0;
		int prefSum = 0;
		for(int i =0 ; i <num.length ;i++) {
			total = total +num[i];
		}
		System.out.println("total="+total);
		
		for(int i =0 ; i <num.length ;i++) {
			
			int suffSum = total - prefSum - num[i];
			if(prefSum == suffSum)
				return i;
			prefSum = prefSum+num[i];
		}

		
		
		
		return -1;
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{-7, 1, 5, 2, -4, 3, 0};
		PrefixSumArray arr= new PrefixSumArray();
		
		
		System.out.println("input="+Arrays.toString(input));
		
		System.out.println("ans="+arr.findEquilibrium(input));
		
	}

}
