package Arrays;

public class StaticArray{

    private int length=0;
    private String[] arr ;

    public StaticArray(int length)
    {
        this.arr = new String[length];
       }

    public void push(String item){
        arr[length] = item;
        length++;
         }

    public String get(int index){
        return arr[index];
    }

    public void pop(){
        length--;
        arr[length] = null;
        
    }

    public void delete(int index){
    	
    	String data = arr[index];
    	shiftElements(index);
    	
    }
    
    public void shiftElements(int index)
    {
    	arr[index] = null;
    	for(int i= index ; i < arr.length-1; i++)
    		arr[i]=arr[i+1];
    	
    	arr[arr.length-1] = null;
    	
    	length --;
    }
    
    public static void main(String[] args) {
        StaticArray staticArray = new StaticArray(5);
        staticArray.push("item1");
        staticArray.push("item2");
        staticArray.push("item3");
        staticArray.push("item4");
        staticArray.push("item5");
        
        System.out.println("length = "+ staticArray.length + " arr ="+ java.util.Arrays.toString(staticArray.arr));

        staticArray.delete(4);
        System.out.println("length = "+ staticArray.length + " arr ="+ java.util.Arrays.toString(staticArray.arr));
    }

}
