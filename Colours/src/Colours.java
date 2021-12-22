import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Colours {
	
	public static void main(String[] args) {
		
		//create a scanner for user input
		Scanner userInput = new Scanner(System.in);
		
		//get the users input
		System.out.println("Input names seperated by a comma: ");
		String keyInput = userInput.nextLine();
		System.out.println("Input corresponding colors seperated by a comma: ");
		String valueInput  = userInput.nextLine();
		
		//counting the commas in each string given by user
		int commasKeys = 0;
		for(int i = 0; i < keyInput.length(); i++) {
		    if(keyInput.charAt(i) == ',') commasKeys++;
		}
		int commasValues = 0;
		for(int i = 0; i < valueInput.length(); i++) {
		    if(valueInput.charAt(i) == ',') commasValues++;
		}
		
		//Check if number of commas are equal to confirm the lists were the same length
		if(commasKeys!=commasValues) {
			System.out.println("Sorry the lists must be of equal length");
		}
		else{
			
			//convert the comma separated values to a list
			List<String> keysArrayList = Arrays.asList(keyInput.split(",", -1));
			List<String> valuesArrayList = Arrays.asList(valueInput.split(",", -1));
			
			//use shuffle to randomize each list
			Collections.shuffle(keysArrayList);
			Collections.shuffle(valuesArrayList);
	
			//close the scanner
			userInput.close();
			
			//print the result
			for(int i = 0; i < keysArrayList.size(); i++) {
				System.out.println("Name: " + keysArrayList.get(i) + " Color: " + valuesArrayList.get(i));
			}
		}
	}
}

