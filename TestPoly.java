import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;

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

		add = poly1Coef + poly2Coef;

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

	}

	static StringBuilder polySub(int[] poly1, int[] poly2, int exp){
		/*
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

		return poly1Coef - poly2Coef;*/
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

		add = poly1Coef - poly2Coef;

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
	}
}

public class TestPoly extends JFrame{
	private static JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField txtnn;
	private static JTextField textField_2;
	JButton btnNewButton = new JButton("\u4E8C\u5F0F\u76F8\u52A0");
	JButton btnNewButton_1 = new JButton("\u4E8C\u5F0F\u76F8\u6E1B");
	JButton btnNewButton_2 = new JButton("\u5168\u90E8\u6E05\u9664");
	JButton btnNewButton_3 = new JButton("\u6B65\u9A5F");
	private Thread thread1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestPoly frame = new TestPoly();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		TwoPolyAddOrSub2 poly = new TwoPolyAddOrSub2("1,4,2,3,3,2,1,0,4,-1","2,3,1,2,5,0,4,-1");
		int[] poly1 = poly.Poly1StringToInt();
		int[] poly2 = poly.Poly2StringToInt();

		int biggestExp = poly.findBiggestExp(poly1, poly2);
		int smallestExp = poly.findSmallestExp(poly1, poly2);

		TestPoly myApp = new TestPoly(poly1, poly2, biggestExp, smallestExp);

		
		
		
	}// end main


	TestPoly(){
		setTitle("\u5169\u500B\u6709\u7406\u4FC2\u6578\u591A\u9805\u5F0F\u7684\u52A0\u6CD5\u6E1B\u6CD5\u7A0B\u5F0F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u9019\u662F\u3127\u500B\u53EF\u4EE5\u8A08\u7B972\u500B\u6709\u7406\u4FC2\u6578\u591A\u9805\u5F0F\u7684\u7A0B\u5F0F\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 432, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u60A8\u53EF\u4EE5\u5728\u4E0B\u65B9\u7684\u7A7A\u683C\u4E2D\u8F38\u5165\u4F60\u60F3\u8A08\u7B97\u7684\u591A\u9805\u5F0F");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 21, 432, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8209\u4F8B\uFF1A2X^4+5X+7X^(-1)   (\u60A8\u8981\u5728\u7A7A\u683C\u4E2D\u5165\u6210  2,4,5,1,7,-1)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 42, 432, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u591A\u9805\u5F0FA\uFF1A");
		lblNewLabel_3.setBounds(0, 67, 66, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u591A\u9805\u5F0FB\uFF1A");
		lblNewLabel_4.setBounds(0, 92, 66, 15);
		panel.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(62, 64, 370, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(62, 89, 370, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		
		btnNewButton.setBounds(32, 154, 87, 23);
		panel.add(btnNewButton);
		
		
		btnNewButton_1.setBounds(129, 154, 87, 23);
		panel.add(btnNewButton_1);
		
		
		btnNewButton_2.setBounds(226, 154, 87, 23);
		panel.add(btnNewButton_2);
		
		
		btnNewButton_3.setBounds(323, 154, 87, 23);
		panel.add(btnNewButton_3);
		
		txtnn = new JTextField();
		txtnn.setHorizontalAlignment(SwingConstants.CENTER);
		txtnn.setEditable(true);
		txtnn.setText("");
		txtnn.setBounds(0, 194, 432, 472);
		panel.add(txtnn);
		txtnn.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(62, 117, 370, 21);
		textField_2.setEditable(false);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u7D50\u679C\uFF1A");
		lblNewLabel_5.setBounds(0, 117, 36, 22);
		panel.add(lblNewLabel_5);

		btnNewButton.addActionListener(new ButtonListener()); // Register listener.
		btnNewButton_1.addActionListener(new ButtonListener()); // Register listener.
		btnNewButton_2.addActionListener(new ButtonListener()); // Register listener.
		btnNewButton_3.addActionListener(new ButtonListener()); // Register listener.


	}
	
	TestPoly(int [] poly1, int[] poly2, int biggestExp, int smallestExp){
		thread1 = new Thread(new printPolyByStep(poly1, poly2, biggestExp, smallestExp));
		thread1.start();
	}

	private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if(e.getSource() == btnNewButton){
        		txtnn.setText("Addition");
        		String polyA = textField.getText();
        		String polyB = textField_1.getText();
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
        		txtnn.setText("Sub");
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
        		textField_2.setText("");
        		txtnn.setText("Clear");
        	}else if(e.getSource() == btnNewButton_3){
        		
        	}else{
        		txtnn.setText("Wromg");
        	}

        	
        }
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
		  String polyAdd = " ";

          for( int i = 1 ; i <= times ; i++ ) {
            stringBuilder.append(poly.polyAddByStep(poly1,poly2,exp,i));
            exp = exp - 1; // Control the exp's value.
            polyAdd = new String(stringBuilder); // Convert stringBuilder into String data type
			System.out.print(polyAdd);
            try {
              //Thread.currentThread().sleep(2000); // Pause two seconds (currentThread------> thread1)
            	thread1.sleep(2000);
            } catch(InterruptedException ie) {
              ie.printStackTrace(); //  prints the Exception and the call stack (stack trace) to Standard Error output. 
            }
          } // for
        } // run
	}// end class printPolyByStep
}// end class TestPoly
