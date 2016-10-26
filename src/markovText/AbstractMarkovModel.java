package markovText;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractMarkovModel implements IMarkovModel{
	protected String myText;
	protected Random myRandom;
	
	public AbstractMarkovModel(){
		myRandom = new Random();
	}
	
	abstract public String genRandomText(int numChars);
	
	protected ArrayList<String> getFollows(String key){
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
		return followsStr;
	}
	
	public void setTraining(String text){
		myText = text;
	}
}
