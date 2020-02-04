package Anagrams;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class wordSearch {

	static boolean duplicate(int x, char letter, String word)//where x is the location of letter
	{
		if(word.substring(x+1, word.length()).indexOf(letter)!=-1)
			return true;
		
		return false;
	}
	public static char[] searchLetters(String word)
	{
		String searchLetters ="";
		for(int i=0;i<word.length();i++)
		{
			char letter = word.charAt(i);
			if(!duplicate(i,letter,word))
				searchLetters+=letter;
		}
		char search[] = searchLetters.toCharArray();
		Arrays.sort(search);
		return search;
	}
	public static boolean finder(String word, String dw, int length)
	{
		char arrW[] = word.toCharArray();
		char arrD[] = dw.toCharArray();
		Arrays.sort(arrW);
		Arrays.sort(arrD);
		for(int i=0;i<length;i++)
		{
			if(arrW[i]!=arrD[i])
			{
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner scan = new Scanner(System.in);
		String word;
		do {
				System.out.println("Enter the Anagram.");
				word = scan.next();
				scan.nextLine();
			char letters[] = searchLetters(word);
			
			File file = new File("dictionary.txt");
			
			Scanner sc = new Scanner(file);
	    	int count=0;
		    while(sc.hasNextLine())
		    {
			    	String dw = sc.nextLine().toLowerCase();//dictionary word
		        for(char i : letters)
				{
		        	if(dw.charAt(0)==i && dw.length()==word.length())
					{
						boolean isAnagram = finder(word, dw, dw.length());
						if(isAnagram)
						{
							count++;
							System.out.println(count+": "+dw);
						}
						break;
					}
				}
		    }
		    if(count==0)
		    {
		    	System.out.println("No Match!");
		    }
		}while(!word.equals(""));
	}
	
	
}
