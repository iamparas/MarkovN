package markovText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovFour implements IMarkovModel {
	
	String trainingText;
	HashMap<String, ArrayList<String>> follows;
	Random random; 
	
	public MarkovFour(){
		/*
		 * Use four character to predict  the next character
		 * */
		trainingText = null;
		random = new Random();
		follows = new HashMap<String, ArrayList<String>>();
	}
	public void setRandom(long seed){
		random = new Random(seed);
	}
	public void setTraining(String trainingText){
		this.trainingText = trainingText;
	}
	
	public String genRandomText(int numChars){
		/**/
		StringBuilder sb = new StringBuilder();
		int index = random.nextInt(trainingText.length() - 4);
		String key = trainingText.substring(index, index + 4);
		sb.append(key);
		for(int start = 0; start < numChars - 4; start++){

			 ArrayList<String> follows = getFollows(key);
			 if(follows.size() == 0) break;
			 index = random.nextInt(follows.size());
			 String next = follows.get(index);
			 sb.append(next);
			 key = next;
		}
		return sb.toString();
	}
	
	private ArrayList<String> getFollows(String key){
		if(follows.containsKey(key)){
			return follows.get(key);
		}
		ArrayList<String> followsStr = new ArrayList<String>();
		int pos = 0;
	
		while(pos < trainingText.length()){
			int start = trainingText.indexOf(key, pos);
			
			if(start == -1) break;
			
			if((start + key.length() + 1) > trainingText.length()) break;
			
			String next = trainingText.substring(start + key.length(), start + key.length() + 1);
			followsStr.add(next);
			pos = start + key.length();
		}
		follows.put(key, followsStr);
		return followsStr;
	}
}
