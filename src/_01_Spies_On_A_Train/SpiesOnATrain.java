 package _01_Spies_On_A_Train;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	ArrayList<String> suspects = new ArrayList<String>();
    	HashMap<String, Integer> suspectCount = new HashMap<String, Integer>();
    	train.print();
    	Node<TrainCar> current = train.getHead();
    	for(int i = 0; i < clues.length; i++) {
    		System.out.println(clues[i]);
    	}
    	while(current != null) {
    		String info = current.getValue().questionPassenger();
    		int spaces = 0;
    		String important = "";
    		String person = null;
    		Boolean suspicious = false;
    		for(int i = 0; i < info.length(); i++) {
    			if(info.substring(i, i+1).equals(" ") && spaces != 14) {
    				spaces++;
    			}
    			if(spaces == 14) {
    				important+=info.substring(i, i+1);
    			}
    		}
    		important = important.substring(1, important.length()-1);
    		for(int i = 0; i < clues.length; i++) {
        		if(important.equals(clues[i])) {
        			suspicious = true;
        		}
        	}
    		if(suspicious) {
    			spaces = 0;
    			person = "";
    			for(int i = 0; i < info.length(); i++) {
    				if(info.substring(i, i+1).equals(" ")) {
    					spaces++;
    				}
    				if(spaces == 13) {
    					person+=info.substring(i, i+1);
    				}
    			}
        		person = person.substring(1, person.length()-1);
    			suspects.add(person);
    		}
    		current = current.getNext();
    		
    	}
        for(int i = 0; i < suspects.size(); i++) {
        	if(!suspectCount.containsValue(suspects.get(i))) {
        		suspectCount.put(suspects.get(i), 1);
        	} else {
        		for(Entry<String, Integer> suspect : suspectCount.entrySet()) {
        			if(suspect.getValue() == someValue) {
        				key = suspect.getKey();
        			}
        		}
        	}
        }
    	return "";

    }
    

}
