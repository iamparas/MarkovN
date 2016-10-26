package markovText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovWordOne implements IMarkovModel {

	String[] myText;
	Random myRandom;
	HashMap<String, ArrayList<String>> follows;
	
	public MarkovWordOne(){
		myRandom = new Random();
		follows = new HashMap<String, ArrayList<String>>();
	}
	@Override
	public void setTraining(String text) {
		// TODO Auto-generated method stub
		myText = text.split("\\s+");
	}
	

	@Override
	public String genRandomText(int num) {
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length - 1);
		String key = myText[index];
		sb.append(key + " ");
		for(int i = 0 ; i < num - 1; i++){
			ArrayList<String> followsStr = getFollows(key);
			if(followsStr.size() == 0) break;
			index = myRandom.nextInt(followsStr.size());
			String next = followsStr.get(index);
			sb.append(key + " ");
			key = next;
		}
		return sb.toString();
		
		
	}
	
	public ArrayList<String> getFollows(String key){
		if(follows.containsKey(key)){
			return follows.get(key);
		}
		ArrayList<String> followsStr = new ArrayList<String>();
		for(int i = 0; i < myText.length - 1; i++){
			if(key.equals(myText[i])){
				followsStr.add(myText[i + 1]);
			}
		}
		return followsStr;
	}
	
}
