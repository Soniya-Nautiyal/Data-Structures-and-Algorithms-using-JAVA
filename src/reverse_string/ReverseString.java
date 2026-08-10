package reverse_string;

public class ReverseString {

	public String reverse(String str) {
		char[] strAsChar = str.toCharArray();
		char[] reverseStr = new char[strAsChar.length];
		for (int j=0, i = strAsChar.length-1 ; i >= 0 ; i--,j++) {
			reverseStr[j]= strAsChar[i];
		}
		return new String(reverseStr);
	}

	public String reverseWithTwoPointers(String str) {
		char[] strAsChar = str.toCharArray();
		int right=strAsChar.length-1;
		int left=0;
		
		while(left<right) {
			char temp = strAsChar[left];
			strAsChar[left] = strAsChar[right];
			strAsChar[right]= temp;
			left ++;
			right --;
		}
				
		return new String(strAsChar);

	}

	public static void main(String[] args) {
		// lets run our functions
		String str = "Hello World";
		ReverseString reverseString = new ReverseString();
		System.out.println(reverseString.reverse(str));
		System.out.println(reverseString.reverseWithTwoPointers(str));
	}
}