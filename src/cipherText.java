import java.util.ArrayList;

public class cipherText {

	ArrayList<String> plain_text;
	public static char[][] matrix;

	public cipherText(ArrayList<String> arr, char[][] mat) {
		plain_text = arr;
		matrix = mat;
	}

	public String findCipherText() {

		char first_letter, second_letter;
		int first_row, first_col, second_row, second_col;
		String ret = "";
		String temp = "";

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				temp = temp + matrix[i][j];
			}
		}

		for (int i = 0; i < plain_text.size(); i++) {
			// System.out.println(temp);
			first_letter = plain_text.get(i).charAt(0);
			second_letter = plain_text.get(i).charAt(1);
			if(first_letter == 'j')
				first_letter ='i';
			if(second_letter == 'j')
				second_letter ='i';
			// System.out.println(plain_text.get(i));
			first_row = temp.indexOf(first_letter);
			// System.out.println(first_row);
			first_row = first_row / 5;
			first_col = temp.indexOf(first_letter);
			first_col = first_col % 5;
			second_row = temp.indexOf(second_letter);
			second_row = second_row / 5;
			second_col = temp.indexOf(second_letter);
			second_col = second_col % 5;
			// System.out.println(first_row + " "+ second_row);

			if (first_row == second_row) {
				ret = ret + matrix[first_row][(first_col + 1) % 5] + ""
						+ matrix[second_row][(second_col + 1) % 5] + " ";
			} else if (first_col == second_col) {
				ret = ret + matrix[(first_row + 1) % 5][first_col] + ""
						+ matrix[(second_row + 1) % 5][second_col] + " ";
			} else {
				ret = ret + matrix[first_row][second_col] + ""
						+ matrix[second_row][first_col] + " ";
			}
		}

		return ret;
	}

	public static ArrayList<String> subPlain(String str) {

		ArrayList<String> ret = new ArrayList<String>();
		String temp ="";
		
		while(str.length() >=1){
			if (str.length() ==1) {
				str = str + "x";
			}
			temp = str.substring(0,2);
			if (temp.charAt(0) == temp.charAt(1)) {
				str = str.substring(2,str.length());
				str=temp.charAt(0) +"x"+ temp.charAt(1) +str;
				ret.add(str.substring(0,2));
				str = str.substring(2,str.length());
			}
			else{
				ret.add(temp);
				str = str.substring(2,str.length());
			}
		}
		
		
		
		return ret;

	}

	static ArrayList<String> new_sub = new ArrayList<String>();
	static int Index = 0;

	public static ArrayList<String> checkDouplicate(ArrayList<String> sub) {
		String str = "";

		System.out.println(sub);

		if (sub.size() < 1)
			return new_sub;
		else {
			for (int i = 0; i < sub.size(); i++) {
				int t = i;
				if (sub.get(i).charAt(0) == sub.get(i).charAt(1)) {
					str = sub.get(i).charAt(0) + "x" + sub.get(i).charAt(1);
					for (int j = i + 1; j < sub.size(); j++) {
						str += sub.get(j);
					}

					sub = cipherText.subPlain(str);
					break;
				} else {
					new_sub.add(Index, sub.get(i));
					Index++;
				}
			}
			
		}

		return new_sub;
	}

	public static String cipherDecryption(ArrayList<String> cipher) {

		char first_letter, second_letter;
		int first_row, first_col, second_row, second_col;
		String ret = "";
		String temp = "";

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				temp = temp + matrix[i][j];
			}
		}

		for (int i = 0; i < cipher.size(); i++) {
			// System.out.println(temp);
			first_letter = cipher.get(i).charAt(0);
			second_letter = cipher.get(i).charAt(1);
			// System.out.println(plain_text.get(i));
			if(first_letter == 'j')
				first_letter ='i';
			if(second_letter == 'j')
				second_letter ='i';
			
			first_row = temp.indexOf(first_letter);
			// System.out.println(first_row);
			first_row = first_row / 5;
			first_col = temp.indexOf(first_letter);
			first_col = first_col % 5;
			second_row = temp.indexOf(second_letter);
			second_row = second_row / 5;
			second_col = temp.indexOf(second_letter);
			second_col = second_col % 5;
			// System.out.println(first_row + " "+ second_row);

			if (first_row == second_row) {
				ret = ret + matrix[first_row][((first_col - 1) + 5) % 5] + ""
						+ matrix[second_row][((second_col - 1) + 5) % 5] + " ";
			} else if (first_col == second_col) {
				ret = ret + matrix[((first_row - 1) + 5) % 5][first_col] + ""
						+ matrix[((second_row - 1) + 5) % 5][second_col] + " ";
			} else {
				ret = ret + matrix[first_row][second_col] + ""
						+ matrix[second_row][first_col] + " ";
			}
		}
		return ret;
	}

	public static String removeDumiLetters(String original) {
		if (original != "") {
			String ret_str = original.charAt(0) + "";
			int temp;
			for (int i = 1; i < original.length(); i++) {
				temp = i + 1;
				if (original.charAt(i) == 'x' && i != original.length()) {
					if (original.charAt(temp) == original.charAt(i - 1))
						continue;
				} else
					ret_str += original.charAt(i);

			}
			return ret_str;
		} else
			return "";
	}

}
