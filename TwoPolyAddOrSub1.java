public class TwoPolyAddOrSub1{
	public static void main(String[] args) {
		String[] tokens = "3,4,-2,3,7,1,9,0,2,-1,6,-2".split(",");
		String[] tokens1 = "1,4,-3,3,-2,0,-3,-1,-4,-3".split(",");

		StringBuilder stringBuilder = new StringBuilder();

		StringBuilder stringBuilder3 = new StringBuilder();


		int[] poly1 = new int[tokens.length];
		for (int i = 0; i < poly1.length; i++){
			poly1[i] = Integer.parseInt(tokens[i]);
		}

		int[] poly2 = new int[tokens1.length];
		for (int i = 0; i < poly2.length; i++){
			poly2[i] = Integer.parseInt(tokens1[i]);
		}

		int biggestExp = findBiggestExp(poly1, poly2);
		int smallestExp = findSmallestExp(poly1, poly2);
		
		int count = 1;
		for(int i = biggestExp; i >= smallestExp; i--){
			stringBuilder.append(polyAddByStep(poly1, poly2, i, count));
			String polyAdd = new String(stringBuilder); // Convert stringBuilder into String data type
			System.out.print(polyAdd);
			count = count + 1;
		}

		count = 1;
		for(int i = biggestExp; i >= smallestExp; i--){
			stringBuilder3.append(polySubByStep(poly1, poly2, i, count));
			String polySub = new String(stringBuilder3); // Convert stringBuilder3 into String data type
			System.out.print(polySub);	
			count = count + 1;
		}

		
			

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
