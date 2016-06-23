import java.*;
import java.util.*;

import javax.*;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		System.out.print("Enter The Original Message : ");
		String plain_text = s.next();
		System.out.print("Enter The Key : ");
		String key = s.next();
		String distinct_key = "";

		for (int j = 0; j < key.length(); j++) {
			if (!distinct_key.contains(key.charAt(j) + ""))
				distinct_key = distinct_key + key.charAt(j);
		}

		// System.out.println(distinct_key);

		GenerateMatrix obj = new GenerateMatrix(distinct_key);
		char[][] matrix = new char[5][5];
		matrix = obj.keyMatrix();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}

		//System.out.println(plain_text);
		
		//System.out.println(new_plain);
		ArrayList<String> sub = cipherText.subPlain(plain_text);
		//ArrayList<String> new_sub = cipherText.checkDouplicate(sub);
		System.out.println(sub);

		/*String splited_string = Arrays
				.toString(new_plain.split("(?<=\\G.{2})"));
		ArrayList<String> str_arr = new ArrayList<String>(
				Arrays.asList(splited_string.split(",")));
		System.out.println(str_arr);*/

		String cipher = new cipherText(sub, matrix).findCipherText();
		if(plain_text.contains("j"))
			cipher=cipher.replaceAll("i","j");
		System.out.println("The Cipher Text is : "+cipher);
		
		cipher=cipher.replaceAll("\\s+","");
		ArrayList<String> sub_cipher = cipherText.subPlain(cipher);
		String plain= cipherText.cipherDecryption(sub_cipher);
		plain=plain.replaceAll("\\s+","");
		System.out.println("plain ==" +plain);
		if(plain.length() > plain_text.length() && plain.charAt(plain.length()-1) =='x')
			plain=plain.substring(0,plain_text.length());
		plain = cipherText.removeDumiLetters(plain);
		if(plain_text.contains("j"))
			plain=plain.replaceAll("i","j");
		System.out.print("The Original Text is : "+ plain);

	}
}
