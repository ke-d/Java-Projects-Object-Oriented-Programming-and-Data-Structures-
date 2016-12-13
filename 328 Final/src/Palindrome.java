/**
 * This class finds the palindrome of a given string
 * @author Kenny Do
 *
 */
public class Palindrome {
	public static String longestPalindrome(String str) {
		//Set up variables and table
		int n = str.length();
		int i, j, charLength;
		int table[][] = new int[n][n];
		
		//Any 1 character string is a palindrome of itself
		for (i = 0; i < n; i++) {
			table[i][i] = 1;
		}
		
		//Creates the table
		for (charLength = 2; charLength <= n; charLength++) {
			for (i = 0; i < n - charLength + 1; i++) {
				j = i + charLength - 1;
				if (str.charAt(i) == str.charAt(j) && charLength == 2) {
					//Any 2 character substring with the same characters
					table[i][j] = 2;
				} else if (str.charAt(i) == str.charAt(j)) {
					//Inherit from the down left and add 2
					table[i][j] = table[i + 1][j - 1] + 2;
				} else {
					//Inherit the max of down or left
					table[i][j] = Math.max(table[i][j - 1], table[i + 1][j]);
				}
			}
		}
		
		//Trace through the table to find palindrome (longest palindrome sequence)
		StringBuilder lps = new StringBuilder();
		//Start from top right
		i = 0;
		j = n - 1;
		while(j >= 0 && i < n && table[i][j] > 0) {
			if(str.charAt(i) == str.charAt(j)) {
				//Add the solution to the lps then go down and then left
				lps.insert(lps.length(), str.charAt(i));
				i++;
				j--;
			} else {
				if(table[i][j-1] > table[i+1][j]) {
					//Go left
					j--;
				} else {
					//Go down
					i++;
				}
			}
		}
		
		//Appends the reverse of the current string depending if the lps number is even or odd
		if(table[0][n-1] % 2 == 0) {
			lps.append(lps.reverse());
		} else {
			StringBuilder temp = new StringBuilder();
			temp.append(lps.substring(0, lps.length() - 1));
			lps.append(temp.reverse());
		}
		
		return lps.toString();
	}

	public static void main(String args[]) {
		String str = "character";
		System.out.println("The longest palindrome for " + str + " is: " + longestPalindrome(str));
	}
}
