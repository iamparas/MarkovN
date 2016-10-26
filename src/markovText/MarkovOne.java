package markovText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class MarkovOne implements IMarkovModel{
	private Random random;
	private String myText;
	private HashMap<Character, ArrayList<Character>> follows;
	
	public MarkovOne(){
		random = new Random();
		follows = new HashMap<Character, ArrayList<Character>>();
	}
	
	public void setRandom(int seed){
		random = new Random(seed);
	}
	public void setTraining(String trainingText){
		this.myText = trainingText;
	}
	
	
	public String genRandomText(int numChars){
		
		MarkovZero markovZero =  new MarkovZero();
		markovZero.setTraining(myText);
		Character currentChar = markovZero.genRandomText(1).charAt(0);
		
		StringBuilder builder = new StringBuilder();
		builder.append(currentChar);
		for(int i=0; i<numChars - 1; i++){
			builder.append(getNextChar(currentChar));
		}
		
		return builder.toString();
	}
	
	private Character getNextChar(Character c){
		ArrayList<Character> probchars = new ArrayList<Character>();
		if(follows.containsKey(c)){
			 probchars = follows.get(c);
			
		}else{
			for(int i=0; i<myText.length() - 1; i++){
				if(c == myText.charAt(i)){
					probchars.add(this.myText.charAt(i+1));
				}
			}
			follows.put(c, probchars);
		}
		return probchars.get(random.nextInt(probchars.size()));
	}
	
	

}
