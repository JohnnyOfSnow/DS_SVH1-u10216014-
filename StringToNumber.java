public class StringToNumber{
	public static void main(String[] args) {
		String[] tokens = "3,4,2,2,1,1,-5,0,2,-1".split(",");
		String[] tokens1 = "1,4,3,2,0,1,-2,0,3,-1".split(",");

		System.out.println("多項式1即將要被放入字串陣列");

		for (int i = 0; i < tokens.length; i++){
			System.out.println("Index: " + i + " is ==>" + tokens[i]);
		}
		System.out.println("多項式1已經完成放入字串陣列");

		System.out.println("多項式2即將要被放入字串陣列");
		for (int i = 0; i < tokens1.length; i++){
			System.out.println("Index: " + i + " is ==>" + tokens1[i]);
		}

		System.out.println("多項式2已經完成放入字串陣列");

		System.out.println("多項式1即將要被轉換成整數");
		int[] poly1 = new int[tokens.length];
		for (int i = 0; i < poly1.length; i++){
			poly1[i] = Integer.parseInt(tokens[i]);
			System.out.println("Poly1 Index: " + i + " is ==>" + poly1[i]);
		}
		System.out.println("多項式1已經完成轉換成整數陣列");

		System.out.println("多項式2即將要被轉換成整數");
		
		int[] poly2 = new int[tokens1.length];
		for (int i = 0; i < poly2.length; i++){
			poly2[i] = Integer.parseInt(tokens1[i]);
			System.out.println("Poly2 Index: " + i + " is ==>" + poly1[i]);
		}
		System.out.println("多項式2已經完成轉換成整數陣列");
	}
}
