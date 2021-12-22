import java.util.Arrays;

public class HashMapper {
	
	//Attributes of a hashMapper object
	int startinglength;
	String[] keys;
	String[] values;
	boolean found = false;

	//Constructor to make a hashMapper object
	public HashMapper () {
		this.startinglength = 996; //largest prime under 1000
		this.keys = new String[startinglength];
		this.values = new String[startinglength];
	}
	
	//method to print the map for the user
	public void printMap() {
		for(int i = 0; i < keys.length; i++) {
			System.out.println(i + ", " + keys[i] + ", " + values[i]);
		}
		System.out.println();
	}
	
	
	//method to place new items in the map, the key is the length of the string
	public void addItem(String keyInput, String valueInput) {
		//get the key
		int code = Math.abs(keyInput.hashCode()) % 997;
		
		//if the key value is larger than the array, increase the size of the array
		if (code > keys.length) {
			String[] nkeys = Arrays.copyOf(keys, keys.length + ((code - keys.length)+1));
			String[] nvalues = Arrays.copyOf(values, keys.length + ((code - keys.length)+1));
			keys = nkeys;
			values = nvalues;
		}
		
		//try to place the key into the array, by finding the next open spot or if the key is already added just update the value
		for(int i = code; i < keys.length; i++) {
		    if(keys[i] == null || keys[i].equals(keyInput)) {
		    	keys[i] = keyInput;
		    	values[i] = valueInput;
		    	break;
		    }
		    //if the end of the array is reached loop back to the start to find a open spot
		    if(i == keys.length-1) {
				for(i = 0; i < code; i++) {
				    if(keys[i] == null || keys[i].equals(keyInput)) {
				    	keys[i] = keyInput;
				    	values[i] = valueInput;
				    	break;
				    }
				    //if there are no open spots in the entire array, increase the array size by 1 and use that spot
				    if(i == code-1) {
						String[] nkeys = Arrays.copyOf(keys, keys.length + 1);
						String[] nvalues = Arrays.copyOf(values, keys.length + 1);
						keys = nkeys;
						values = nvalues;
				    	keys[keys.length-1] = keyInput;
				    	values[keys.length-1] = valueInput;
				    	break;
				    }
				}
			break;
		    }
		}
	}
	
	//method to remove item (issue - L2T13#1)
	public void removeItem(String keyInput) {
		//get the key
		found = false;
		int code = Math.abs(keyInput.hashCode()) % 997;
				
		//find the index of the key starting from the hash value then delete both the key and the value
		for(int i = code; i < keys.length; i++) {
			if(keys[i] == null) {
			}
			else if(keys[i].equals(keyInput)){
		    	keys[i] = null;
		    	values[i] = null;
		    	found = true;
		    	System.out.println("Success: '" + keyInput +"' removed.");
		    }
		}
		//if the end of the array is reached loop back to the start to search for the key
	    if(found == false) {
			for(int i = 0; i < code; i++) {
				if(keys[i] == null) {
				}
				else if(keys[i].equals(keyInput)){
					keys[i] = null;
			    	values[i] = null;
			    	found = true;
			    	System.out.println("Success: '" + keyInput +"' removed.");
			    }
			}
	    }
		//if the value in not found alert the user.
	    if(found == false) {
	    	System.out.println("Error: '" + keyInput +"' not found.");
	    }
	}
}
