
public class LinearProbing {

	//method to search for a key value pair in a hashMap using linear probing technique
	
	public static String getValue(HashMapper mapName, String userKey) {
		String userValue = "";
		
		//get the hash value
		int code = userKey.length();
		
		//start searching using the hash value
		for(int i = code; i < mapName.keys.length; i++) {
		    if(mapName.keys[i].equals(userKey)) {
		    	userValue = mapName.values[i];
		    	break;
		    }
		    // if not found start search from beginning of array
		    if(i == mapName.keys.length-1) {
				for(i = 0; i < code; i++) {
				    if(mapName.keys[i].equals(userKey)) {
				    	userValue = mapName.values[i];
				    	break;
				    }
				}
			break;
		    }
		}
		return userValue;
	}
	

	public static void main(String[] args) {
		
		//create a test map
		HashMapper testHashMap = new HashMapper(6);
		
		//add some test values, exceed initial array size to check that array resizing is working
		testHashMap.printMap();
		testHashMap.addItem("test1", "1");
		testHashMap.addItem("test2", "2");
		testHashMap.addItem("test3", "3");
		testHashMap.addItem("test4", "4");
		testHashMap.printMap();
		testHashMap.addItem("test5", "5");
		testHashMap.addItem("test6", "6");
		testHashMap.addItem("test7", "7");
		testHashMap.printMap();
		
		//try to override/re-write some of the values
		testHashMap.addItem("test5", "8");
		testHashMap.addItem("test6", "9");
		testHashMap.addItem("test7", "10");
		testHashMap.printMap();
		
		//use linear probing to search for key value pairs
		System.out.println("Key 'test2' value = " + LinearProbing.getValue(testHashMap,"test2"));
		System.out.println("Key 'test1' value = " + LinearProbing.getValue(testHashMap,"test1"));
		System.out.println("Key 'test7' value = " + LinearProbing.getValue(testHashMap,"test7"));
		System.out.println("Key 'test3' value = " + LinearProbing.getValue(testHashMap,"test3"));
		System.out.println("Key 'test6' value = " + LinearProbing.getValue(testHashMap,"test6"));
		
		//test removal function
		testHashMap.removeItem("test5");
		testHashMap.printMap();
		
		testHashMap.removeItem("itemthatshouldnotbeinmap");		
	}
}
