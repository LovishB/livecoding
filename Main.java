package livecoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	    public static void main(String[] args) {
	    	
	    	correctDatabase();
	    	
	    	pickDressColor();
	    }
	    
	    public static void correctDatabase() {
	    	String keysDatabase[] = {"idea", "idae", "bsnl", "nsbl", "grasim", "bata"}; 
	    	HashMap<String, List<String>> correctKeys = new HashMap<>();
	    	
	    	System.out.println("Anagrams printing: ");
	    	//iterating wrong database keys
	    	for(int i =0; i<keysDatabase.length; i++) {
	    		//sorting each key String based on ASCII
	    		char[] key = keysDatabase[i].toCharArray();
	    		Arrays.sort(key);
	    		String sortedKey = new String(key);
	    		
	    		//Putting new key in hashmap
	    		if(correctKeys.containsKey(sortedKey)) {
	    			correctKeys.get(sortedKey).add(keysDatabase[i]);
	    		} else {
	    			List<String> list =  new ArrayList<>();
	    			list.add(keysDatabase[i]);
	    			correctKeys.put(sortedKey, list);
	    		}
	    		
	    		//printing anagram keys from list
	    		for(String check : correctKeys.keySet()) {
	    			if(correctKeys.get(check).size() > 1) {
	    				System.out.println(correctKeys.get(check));  				
	    			}
	    		}
	    	}   	
	    }
	    
	    public static void pickDressColor() {
	    	int colors[] = {1, 2, 1, 2, 1};
	    	int pairs = 0;
	    	
	    	//using hashmap to track frequency of colors
	    	Map<Integer,Integer> mapToTrackFrequency = new HashMap<>();
	    	for(int i =0; i<colors.length; i ++) {
	    		int num = colors[i];
	    		if(mapToTrackFrequency.containsKey(num)) {
	    			int freq = mapToTrackFrequency.get(num);
	    			freq ++;
	    			mapToTrackFrequency.put(num, freq);
	    		} else {
	    			mapToTrackFrequency.put(num, 1);    			    			
	    		}
	    	}
	    	
	    	//interating and getting all pairs that are possible (working of identifying pairs)
	    	for(Entry<Integer, Integer> check : mapToTrackFrequency.entrySet()) {
	    		pairs = pairs + (check.getValue()/2);
	    	}

	    	System.out.println("Total colors pair possible: " + pairs);
	    }
}
