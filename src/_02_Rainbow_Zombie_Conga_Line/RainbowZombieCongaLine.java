package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    
    //
    //5
    //

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	Node<Zombie> head = congaLine.getHead();
    	Node<Zombie> newHead = new Node<Zombie>(dancer);
    	if(head == null) {
    		congaLine.add(dancer);
    	} else {
    	
    	head.setPrev(newHead);
    	newHead.setNext(head);
    	congaLine.setHead(newHead);
    	}
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	Node<Zombie> tail = congaLine.getTail();
    	Node<Zombie> newTail = new Node<Zombie>(dancer);
    	if(tail == null) {
    		congaLine.add(dancer);
    	} else {
    		tail.setNext(newTail);
    		newTail.setPrev(tail);
    		congaLine.setTail(newTail);
    	}
    }

    //  
    // 1 >> 5 >> 2
    
    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	LinkedList<Zombie> newConga = new LinkedList<Zombie>();
    	
    	for(int i = 0; i < congaLine.size(); i++) {
    		if(i == position) {
    			newConga.add(dancer);
    		}
    		Zombie head = congaLine.getHead().getValue();
    		newConga.add(head);
    		congaLine.remove(0);
    	}
    	congaLine = newConga;
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	LinkedList<Zombie> newConga = new LinkedList<Zombie>();
    	for(int i = 0; i < congaLine.size(); i++) {
    		Zombie head = congaLine.getHead().getValue();
    		if(head.getZombieHatColor() != dancer.getZombieHatColor()) {
    			newConga.add(head);
    		}
    		congaLine.remove(0);
    	}
    	congaLine = newConga;
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
    	LinkedList<Zombie> newConga = new LinkedList<Zombie>();
    	boolean done = false;
    	for(int i = 0; i < congaLine.size(); i++) {
    		
    			Zombie head = congaLine.getHead().getValue();
    			if(head.getZombieHatColor() != dancer.getZombieHatColor()) {
    				newConga.add(head);
    			} else {
    				if(!done) {
        				done = true;
    				} else {
        				newConga.add(head);
    				}
    			}
    			congaLine.remove(0);
    	}
    	congaLine = newConga;
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	ZombieHatColor hat = dancer.getZombieHatColor();
    	Zombie zombie = new Zombie(hat);
    	Zombie zombieTwo = new Zombie(hat);
    	int position = congaLine.size()/2;
    	engine(dancer);
    	caboose(zombie);
    	jumpInTheLine(zombieTwo, position);
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
    	engine(dancer);
    	ZombieHatColor hat = ZombieHatColor.R;
    	ZombieHatColor hat2 = ZombieHatColor.O;
    	ZombieHatColor hat3 = ZombieHatColor.G;
    	ZombieHatColor hat4 = ZombieHatColor.Y;
    	ZombieHatColor hat5 = ZombieHatColor.B;
    	ZombieHatColor hat6 = ZombieHatColor.I;
    	ZombieHatColor hat7 = ZombieHatColor.V;
    	caboose(new Zombie(hat));
    	caboose(new Zombie(hat2));
    	caboose(new Zombie(hat3));
    	caboose(new Zombie(hat4));
    	caboose(new Zombie(hat5));
    	caboose(new Zombie(hat6));
    	caboose(new Zombie(hat7));
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
