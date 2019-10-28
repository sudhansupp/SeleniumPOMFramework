package Learning;

public class ToStringUse {
	String y;
	 public String toString(){//overriding the toString() method  
		  return y;  
		 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ToStringUse s= new ToStringUse();
		//System.out.println("s =: "+s);
		String s = "Sharma is a good player and he is so punctual";  
        String words[] = s.split(" ");  
        System.out.println("The Number of words present in the string are : "+words.length);

	}

}
