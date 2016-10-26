package markovText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovTwo implements IMarkovModel{
	private Random random;
	private String myText;
	private HashMap<String, ArrayList<String>> follows;
	
	public MarkovTwo(){
		random = new Random();
		follows = new HashMap<String, ArrayList<String>>();
	}
	
	public void setRandom(int seed){
		random = new Random(seed);
	}
	public void setTraining(String trainingText){
		this.myText = trainingText;
	}
	
	
	public String genRandomText(int numChars){
		
		StringBuilder builder = new StringBuilder();
		int index = random.nextInt(myText.length() - 2);
		String key = myText.substring(index, index + 2);
		builder.append(key);
		for(int i=0; i < numChars - 2; i++){
			ArrayList<String> followsList = getFollows(key);
			if(followsList.size() == 0) break;
			index = random.nextInt(followsList.size());
			String next = followsList.get(index);
			builder.append(next);
			key = next;
		}
		
		return builder.toString();
	}
	
	private ArrayList<String> getFollows(String key){
		if(follows.containsKey(key)){
			return follows.get(key);
		}
		ArrayList<String> followsStr = new ArrayList<String>();
		int pos = 0;
	
		while(pos < myText.length()){
			int start = myText.indexOf(key, pos);
			
			if(start == -1) break;
			
			if((start + key.length() + 1) > myText.length()) break;
			
			String next = myText.substring(start + key.length(), start + key.length() + 1);
			followsStr.add(next);
			pos = start + key.length();
		}
		follows.put(key, followsStr);
		return followsStr;
	}
	
//	public static void main(String[] args){
//		MarkovTwo markov = new MarkovTwo();
//		markov.setRandom(25);
//		markov.setTraining("A long hair black blonde in the west as than therapeutic thin the humphrey of the test can be the usual supsecy I sucpey of the nanci people the hello has the most the character of the nasty");
//		markov.getFollows("th");
//	}
}
