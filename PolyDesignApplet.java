import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.*;


public class PolyDesignApplet extends JApplet {
	private Thread thread1;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextArea textArea;
	JButton btnNewButton = new JButton("\u5169\u5F0F\u76F8\u52A0");
	JButton btnNewButton_1 = new JButton("\u5169\u5F0F\u76F8\u6E1B");
	JButton btnNewButton_2 = new JButton("\u5168\u90E8\u6E05\u9664");
	JButton btnNewButton_3 = new JButton("\u986F\u793A\u6B65\u9A5F");
	private static int choice = 0;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Two Polynomial's addition or subtraction");

		PolyDesignApplet applet = new PolyDesignApplet();

		frame.add(applet);

		frame.setSize(452,753);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
	public void init(){
		resize(450,752);
	}

	/**
	 * Create the applet.
	 */
	public PolyDesignApplet() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u9019\u662F\u5169\u500B\u6709\u7406\u4FC2\u6578\u591A\u9805\u5F0F\u52A0\u6216\u6E1B\u6CD5\u7684\u7A0B\u5F0F");
		lblNewLabel.setBounds(10, 10, 430, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u60A8\u9700\u8981\u5728\u4EE5\u4E0B\u76842\u500B\u7A7A\u683C\u4E2D\u8F38\u5165\u6709\u7406\u4FC2\u6578\u591A\u9805\u5F0F");
		lblNewLabel_1.setBounds(10, 35, 430, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8F38\u5165\u7BC4\u4F8B\uFF1A   2X^3 + 7 + (-1)X^(-4)  \u60A8\u8981\u8F38\u5165\u6210  2,3,7,0,-1,-4");
		lblNewLabel_2.setBounds(10, 60, 430, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u591A\u9805\u5F0FA\uFF1A");
		lblNewLabel_3.setBounds(10, 95, 57, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u591A\u9805\u5F0FB\uFF1A");
		lblNewLabel_4.setBounds(10, 120, 57, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u7D50\u679C");
		lblNewLabel_5.setBounds(10, 145, 57, 15);
		panel.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(66, 92, 374, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 117, 374, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 142, 374, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		
		btnNewButton.setBounds(62, 183, 87, 23);
		panel.add(btnNewButton);
		
		
		btnNewButton_1.setBounds(159, 183, 87, 23);
		panel.add(btnNewButton_1);
		
		
		btnNewButton_2.setBounds(256, 183, 87, 23);
		panel.add(btnNewButton_2);
		
		
		btnNewButton_3.setBounds(353, 183, 87, 23);
		panel.add(btnNewButton_3);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 217, 430, 519);
		panel.add(textArea);

		btnNewButton.addActionListener(new ButtonListener()); // Register listener.
		btnNewButton_1.addActionListener(new ButtonListener()); // Register listener.
		btnNewButton_2.addActionListener(new ButtonListener()); // Register listener.
		btnNewButton_3.addActionListener(new ButtonListener()); // Register listener.

	}

	private class ButtonListener implements ActionListener {
		String check = " ";
		String polyA = " ";
		String polyB = " ";
	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnNewButton){
				// These action is two Polynomial's addition.    		
				setChoice(1); // Choice 1 is for addition.
					
				polyA = textField.getText();
				polyB = textField_1.getText();
				TwoPolyAddOrSub2 poly = new TwoPolyAddOrSub2(polyA,polyB);
				int[] poly1 = poly.Poly1StringToInt();
				int[] poly2 = poly.Poly2StringToInt();
				int biggestExp = poly.findBiggestExp(poly1, poly2);
				int smallestExp = poly.findSmallestExp(poly1, poly2);

				StringBuilder stringBuilder = new StringBuilder();
				for(int k = biggestExp; k >= smallestExp; k--){
					stringBuilder.append(poly.polyAdd(poly1,poly2,k));
				}

				String polyForAdd = new String(stringBuilder); // Convert stringBuilder into String data type
				textField_2.setText(polyForAdd);		        		
			}else if(e.getSource() == btnNewButton_1){
				// These action is two Polynomial's subtraction.       		
				setChoice(2); // Choice 2 is for subtraction.

				String polyA = textField.getText();
				String polyB = textField_1.getText();
				TwoPolyAddOrSub2 poly = new TwoPolyAddOrSub2(polyA,polyB);
				int[] poly1 = poly.Poly1StringToInt();
				int[] poly2 = poly.Poly2StringToInt();
				int biggestExp = poly.findBiggestExp(poly1, poly2);
				int smallestExp = poly.findSmallestExp(poly1, poly2);

				StringBuilder stringBuilder = new StringBuilder();
				for(int k = biggestExp; k >= smallestExp; k--){
					stringBuilder.append(poly.polySub(poly1,poly2,k));
				}

				String polyForSub = new String(stringBuilder); // Convert stringBuilder into String data type
				textField_2.setText(polyForSub);
			}else if(e.getSource() == btnNewButton_2){
				// Clear all string on the frame.
				textField_2.setText("");
				textArea.setText("");
				setChoice(0); // Choice 0 is for clear. 
			}else if(e.getSource() == btnNewButton_3){
				// These action can display the process of addition or subtraction step by step.
				String polyA = textField.getText();
				String polyB = textField_1.getText();
				TwoPolyAddOrSub2 poly = new TwoPolyAddOrSub2(polyA,polyB);
				int[] poly1 = poly.Poly1StringToInt();
				int[] poly2 = poly.Poly2StringToInt();
				int biggestExp = poly.findBiggestExp(poly1, poly2);
				int smallestExp = poly.findSmallestExp(poly1, poly2);

				//      Create a thread to use the method (sleep) that we can set the time of interval,
				//  and let the user can see the operation of two Polynomial's addition or subtraction step by step.
				thread1 = new Thread(new printPolyByStep(poly1, poly2, biggestExp, smallestExp,choice));
				thread1.start();
			}else{
				textArea.setText("Wromg"); // A check statement for ButtonListener.
			}     	
		}// end method actionPerformed
	} // end class ButtonListener

	/**
	 *   Class printPolyByStep is used to handle the process step by step. 
	 */
	public class printPolyByStep implements Runnable{
		private int[] poly1;
		private int[] poly2;
		private int biggestExp;
		private int smallestExp;
		private int choice;

		// set the variable's value.
		printPolyByStep(int [] newpoly1, int[] newpoly2, int newbiggestExp, int newsmallestExp, int newchoice){
			poly1 = newpoly1;
			poly2 = newpoly2;
			biggestExp = newbiggestExp;
			smallestExp = newsmallestExp;
			choice = newchoice;
		}

		public void run() {
			TwoPolyAddOrSub2 poly = new TwoPolyAddOrSub2(); // create a object poly in order to use the method polyAddByStep defined in class TwoPolyAddOrSub2.
			int exp = biggestExp;
			int times = biggestExp - smallestExp + 1;
			StringBuilder stringBuilder = new StringBuilder(); // a stringBuilder that we can connect the string(Because a String object is immutable.)
			String polyAdd = " ";
			String polySub = " ";
			int peopleChoice = getChoice();

			if(peopleChoice == 1){
				for( int i = 1 ; i <= times ; i++ ) {
					stringBuilder.append(poly.polyAddByStep(poly1,poly2,exp,i));
					exp = exp - 1; // Control the exp's value.
					polyAdd = new String(stringBuilder); // Convert stringBuilder into String data type
					textArea.setText(polyAdd);
					try {
						//Thread.currentThread().sleep(2000); // Pause two seconds (currentThread------> thread1, 2000ms = 2s)
						thread1.sleep(2000);
					} catch(InterruptedException ie) {
						ie.printStackTrace(); //  prints the Exception and the call stack (stack trace) to Standard Error output. 
					}
				} // for
			} else if(peopleChoice == 2){
				for( int i = 1 ; i <= times ; i++ ) {
					stringBuilder.append(poly.polySubByStep(poly1,poly2,exp,i));
					exp = exp - 1; // Control the exp's value.
					polySub = new String(stringBuilder); // Convert stringBuilder into String data type
					textArea.setText(polySub);
					try {
						//Thread.currentThread().sleep(2000); // Pause two seconds (currentThread------> thread1, 2000ms = 2s)
						thread1.sleep(2000);
					} catch(InterruptedException ie) {
						ie.printStackTrace(); //  prints the Exception and the call stack (stack trace) to Standard Error output. 
					}
				} // for
			} else {
				textArea.setText("You haven't clicked the button for addition or subtraction");
			}// end if    
		} // end method run
	}// end class printPolyByStep

	// A mutator can set the choice(1---> addition, 2---> subtraction, 0---> initialization)
	public void setChoice(int newChoice){
		choice = newChoice;
	}

	// A accessor can get the choice
	public int getChoice(){
		return choice;
	}
}

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

	// The method can get the biggest exp between two Polynomial.
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

	// The method can get the smallest exp between two Polynomial.
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

	// According to the argument, the method can connect the result(two exp's coefficient are added.) and the exp
	// Returning a string to caller.
	static StringBuilder polyAdd(int[] poly1, int[] poly2, int exp){
		StringBuilder stringBuilderForAdd = new StringBuilder();
		int poly1Coef = 0;
		int poly2Coef = 0;
		int add = 0;
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

		add = poly1Coef + poly2Coef; // the result(two exp's coefficient are added.)

		/**
		 *  For exp
		 *           1. exp > 0, should connect X^exp
		 *           2. exp = 0, we don't connect X^exp
		 *           3. exp < 0, should connect X^(exp)
		 *
		 *  For coefficient
		 *	         1. coefficient > 0, should connect +coefficient
		 *           2. coefficient = 0, we don't connect this result
		 *           3. coefficient < 0, should connect coefficient
		 *
		 */

		if(exp > 0){
			if (add !=0){
				if (add > 0){
					stringBuilderForAdd.append("+" + add + "X^" + exp);
				}else{
					stringBuilderForAdd.append(add + "X^" + exp);
				}
				
			}else{

			}
		}else if(exp < 0){
			if (add !=0){
				if (add > 0){
					stringBuilderForAdd.append("+" + add + "X^" + "(" + exp + ")");
				}else{
					stringBuilderForAdd.append(add + "X^" + "(" + exp + ")");
				}
				
			}else{

			}
		}else{
			if (add !=0){
				if (add > 0){
					stringBuilderForAdd.append("+" + add );
				}else{
					stringBuilderForAdd.append(add + "X^");
				}
				
			}else{

			}
		}

		return stringBuilderForAdd;
	}// end method polyAdd

	// According to the argument, the method can connect the result(two exp's coefficient are substruced.) and the exp
	// Returning a string to caller.
	static StringBuilder polySub(int[] poly1, int[] poly2, int exp){
		StringBuilder stringBuilderForAdd = new StringBuilder();
		int poly1Coef = 0;
		int poly2Coef = 0;
		int sub = 0;
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

		sub = poly1Coef - poly2Coef; // the result(two exp's coefficient are substruced.)

		if(exp > 0){
			if (sub !=0){
				if (sub > 0){
					stringBuilderForAdd.append("+" + sub + "X^" + exp);
				}else{
					stringBuilderForAdd.append(sub + "X^" + exp);
				}
				
			}else{

			}
		}else if(exp < 0){
			if (sub !=0){
				if (sub > 0){
					stringBuilderForAdd.append("+" + sub + "X^" + "(" + exp + ")");
				}else{
					stringBuilderForAdd.append(sub + "X^" + "(" + exp + ")");
				}
				
			}else{

			}
		}else{
			if (sub !=0){
				if (sub > 0){
					stringBuilderForAdd.append("+" + sub );
				}else{
					stringBuilderForAdd.append(sub + "X^");
				}
				
			}else{

			}
		}

		return stringBuilderForAdd;
	}// end method polySub

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
				stringBuilder1.append("    A: " + poly1Coef + "x^" + exp + "   (A[" + poly1CoefAddress + "] == " + poly1Coef + ",A[" + i  + "] == " + exp + ")\n");
				break;
			}
		}

		for(int i = 1; i < poly2.length; i = i + 2){
			if (poly2[i] == exp){
				poly2CoefAddress = i - 1;
				poly2Coef = poly2[poly2CoefAddress];
				stringBuilder1.append("    B: " + poly2Coef + "x^" + exp + "   (B[" + poly2CoefAddress + "] == " + poly2Coef + ",B[" + i  + "] == " + exp + ")\n");
				break;
			}
		}
		stringBuilder1.append("    A + B = (" + poly1Coef + " + " + poly2Coef + ")x^" + exp + "\n");
		stringBuilder1.append("-----------------------------------------------------------\n");
		return stringBuilder1;
		
	}// end method polyAddByStep

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
				stringBuilder2.append("    A: " + poly1Coef + "x^" + exp + "   (A[" + poly1CoefAddress + "] == " + poly1Coef + ",A[" + i  + "] == " + exp + ")\n");
				break;
			}
		}

		for(int i = 1; i < poly2.length; i = i + 2){
			if (poly2[i] == exp){
				poly2CoefAddress = i - 1;
				poly2Coef = poly2[poly2CoefAddress];
				stringBuilder2.append("    B: " + poly2Coef + "x^" + exp + "   (B[" + poly2CoefAddress + "] == " + poly2Coef + ",B[" + i  + "] == " + exp + ")\n");
				
				break;
			}
		}

		stringBuilder2.append("    A - B = (" + poly1Coef + " - " + poly2Coef + ")x^" + exp + "\n");
		stringBuilder2.append("-----------------------------------------------------------\n");
		return stringBuilder2;
	} // end method polySubByStep
} // end class TwoPolyAddOrSub2
