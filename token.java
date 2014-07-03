public class token{
	public static void main(String[] args) {
		String[] tokens = "3,4,2,2,1,1,-5,0,2,-1".split(",");
		for (int i = 0; i < tokens.length; i++){
			System.out.println("Index: " + i + " is ==>" + tokens[i]);
		}
	}
}
