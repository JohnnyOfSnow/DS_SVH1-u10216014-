class TwoPolyAddOrSub2{

	static String poly1;
	static String poly2;
	static int times;
	

	TwoPolyAddOrSub2(){

	}

	TwoPolyAddOrSub2(String newpoly1, String newpoly2) {
		this.poly1 = newpoly1;
		this.poly2 = newpoly2;
	}

	public static int[] Poly1StringToInt() {
		String[] tokens = poly1.split(",");

		int[] poly1IntArray = new int[tokens.length];
		for (int i = 0; i < poly1IntArray.length; i++){
			poly1IntArray[i] = Integer.parseInt(tokens[i]);
		}
		
		return poly1IntArray;
	}

	public static int[] Poly2StringToInt() {
		String[] tokens = poly2.split(",");

		int[] poly1IntArray = new int[tokens.length];
		for (int i = 0; i < poly1IntArray.length; i++){
			poly1IntArray[i] = Integer.parseInt(tokens[i]);
		}

		
		return poly1IntArray;
	}


	static int findBiggestExp(int[] poly1, int[] poly2){
		int biggestExp = 0;

		for(int i = 1; i < poly1.length; i = i + 2){
			if (poly1[i] > biggestExp){
				biggestExp = poly1[i];
			}
		}

		for(int i = 1; i < poly2.length; i = i + 2){
			if (poly2[i] > biggestExp){
				biggestExp = poly2[i];
			}
		}
		
		return biggestExp;
	}

	static int findSmallestExp(int[] poly1, int[] poly2){
		int smallestExp = 0;

		for(int i = 1; i < poly1.length; i = i + 2){
			if (poly1[i] < smallestExp){
				smallestExp = poly1[i];
			}
		}

		for(int i = 1; i < poly2.length; i = i + 2){
			if (poly2[i] < smallestExp){
				smallestExp = poly2[i];
			}
		}

		

		return smallestExp;
	}

	static int polyAdd(int[] poly1, int[] poly2, int exp){
		int poly1Coef = 0;
		int poly2Coef = 0;

		for(int i = 1; i < poly1.length; i = i + 2){
			if (poly1[i] == exp){
				poly1Coef = poly1[i - 1];
				break;
			}
		}

		for(int i = 1; i < poly2.length; i = i + 2){
			if (poly2[i] == exp){
				poly2Coef = poly2[i - 1];
				break;
			}
		}

		return poly1Coef + poly2Coef;
	}

	static int polySub(int[] poly1, int[] poly2, int exp){
		int poly1Coef = 0;
		int poly2Coef = 0;

		for(int i = 1; i < poly1.length; i = i + 2){
			if (poly1[i] == exp){
				poly1Coef = poly1[i - 1];
				break;
			}
		}

		for(int i = 1; i < poly2.length; i = i + 2){
			if (poly2[i] == exp){
				poly2Coef = poly2[i - 1];
				break;
			}
		}

		return poly1Coef - poly2Coef;
	}

	

	public static void setTimes(int newTimes){
		times = newTimes;
	}

	static StringBuilder polyAddByStep(int[] poly1, int[] poly2, int exp, int step){
		int poly1Coef = 0;
		int poly2Coef = 0;

		int poly1CoefAddress = 0;
		int poly2CoefAddress = 0;

		StringBuilder stringBuilder1 = new StringBuilder();
		stringBuilder1.append("step" + step + ": process the x^" + exp + "\n");


		for(int i = 1; i < poly1.length; i = i + 2){
			if (poly1[i] == exp){
				poly1CoefAddress = i - 1;
				poly1Coef = poly1[poly1CoefAddress];
				stringBuilder1.append("    A: " + poly1Coef + "x^" + exp + "   (A[" + poly1CoefAddress + "]==" + poly1Coef + ",A[" + i  + "]==" + exp + ")\n");
				break;
			}
		}

		for(int i = 1; i < poly2.length; i = i + 2){
			if (poly2[i] == exp){
				poly2CoefAddress = i - 1;
				poly2Coef = poly2[poly2CoefAddress];
				stringBuilder1.append("    B: " + poly2Coef + "x^" + exp + "   (B[" + poly2CoefAddress + "]==" + poly2Coef + ",B[" + i  + "]==" + exp + ")\n");
				break;
			}
		}
		stringBuilder1.append("    A + B = (" + poly1Coef + " + " + poly2Coef + ")x^" + exp + "\n");
		stringBuilder1.append("-----------------------------------------------------------\n");
		return stringBuilder1;
		
	}

	static StringBuilder polySubByStep(int[] poly1, int[] poly2, int exp, int step){
		int poly1Coef = 0;
		int poly2Coef = 0;

		int poly1CoefAddress = 0;
		int poly2CoefAddress = 0;

		StringBuilder stringBuilder2 = new StringBuilder();
		stringBuilder2.append("step" + step + ": process the x^" + exp + "\n");
		

		for(int i = 1; i < poly1.length; i = i + 2){
			if (poly1[i] == exp){
				poly1CoefAddress = i - 1;
				poly1Coef = poly1[poly1CoefAddress];
				stringBuilder2.append("    A: " + poly1Coef + "x^" + exp + "   (A[" + poly1CoefAddress + "]==" + poly1Coef + ",A[" + i  + "]==" + exp + ")\n");
				break;
			}
		}

		for(int i = 1; i < poly2.length; i = i + 2){
			if (poly2[i] == exp){
				poly2CoefAddress = i - 1;
				poly2Coef = poly2[poly2CoefAddress];
				stringBuilder2.append("    B: " + poly2Coef + "x^" + exp + "   (B[" + poly2CoefAddress + "]==" + poly2Coef + ",B[" + i  + "]==" + exp + ")\n");
				
				break;
			}
		}

		stringBuilder2.append("    A - B = (" + poly1Coef + " - " + poly2Coef + ")x^" + exp + "\n");
		stringBuilder2.append("-----------------------------------------------------------\n");
		return stringBuilder2;
	}



}

public class TestPoly{
	public static void main(String[] args) {
		TwoPolyAddOrSub2 poly = new TwoPolyAddOrSub2("1,4,2,3,3,2,1,0,4,-1","2,3,1,2,5,0,4,-1");
		int[] poly1 = poly.Poly1StringToInt();
		int[] poly2 = poly.Poly2StringToInt();

		int biggestExp = poly.findBiggestExp(poly1, poly2);
		int smallestExp = poly.findSmallestExp(poly1, poly2);

		TestPoly myApp = new TestPoly(poly1, poly2, biggestExp, smallestExp);
		
	}

	TestPoly(int [] poly1, int[] poly2, int biggestExp, int smallestExp){
		Thread thread1 = new Thread(new printPolyByStep(poly1, poly2, biggestExp, smallestExp));
		thread1.start();
	}

	/**
	 *   Class printPolyByStep is used to handle the process step by step. 
	 */
	public class printPolyByStep implements Runnable{
		private int[] poly1;
		private int[] poly2;
		private int biggestExp;
		private int smallestExp;

		// set the variable's value.
		printPolyByStep(int [] newpoly1, int[] newpoly2, int newbiggestExp, int newsmallestExp){
			poly1 = newpoly1;
			poly2 = newpoly2;
			biggestExp = newbiggestExp;
			smallestExp = newsmallestExp;
		}

		public void run() {
		  TwoPolyAddOrSub2 poly = new TwoPolyAddOrSub2(); // create a object poly in order to use the method polyAddByStep defined in class TwoPolyAddOrSub2.
		  int exp = biggestExp;
		  int times = biggestExp - smallestExp + 1;
		  StringBuilder stringBuilder = new StringBuilder(); // a stringBuilder that we can connect the string(Because a String object is immutable.)

          	  for( int i = 1 ; i <= times ; i++ ) {
            		stringBuilder.append(poly.polyAddByStep(poly1,poly2,exp,i));
            		exp = exp - 1; // Control the exp's value.
            		String polyAdd = new String(stringBuilder); // Convert stringBuilder into String data type
			System.out.print(polyAdd);
            		try {
              			Thread.currentThread().sleep(2000); // Pause two seconds (currentThread------> thread1)
            		} catch(InterruptedException ie) {
              			ie.printStackTrace(); //  prints the Exception and the call stack (stack trace) to Standard Error output. 
            		}
          	  } // for
        	} // run
	}
}
