package markovText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovN extends AbstractMarkovModel{
	String trainingText;
	HashMap<String, ArrayList<String>> follows;
	Random random; 
	private int N;
	
	public MarkovN(int N){
		/*
		 * Use four character to predict  the next character
		 * */
		this.N = N;
		trainingText = null;
		random = new Random();
		follows = new HashMap<String, ArrayList<String>>();
	}
	public void setRandom(long seed){
		random = new Random(seed);
	}
	public String genRandomText(int numChars){
		/**/
		StringBuilder sb = new StringBuilder();
		int index = random.nextInt(trainingText.length() - N);
		String key = trainingText.substring(index, index + N);
		sb.append(key);
		for(int start = 0; start < numChars - N; start++){

			 ArrayList<String> follows = getFollows(key);
			 if(follows.size() == 0) break;
			 index = random.nextInt(follows.size());
			 String next = follows.get(index);
			 sb.append(next);
			 key = next;
		}
		return sb.toString();
	}
	
}
