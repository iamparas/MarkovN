package markovText;

import java.util.Random;

public class MarkovZero {
	private Random myRandom;
	private String myText;
	
	public MarkovZero(){
		myRandom = new Random();
		
	}
	
	public void setTraining(String trainingText){
		this.myText = trainingText;
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public String genRandomText(int numChars){
		if(myText == null){
			myText = "";
		}
		StringBuilder randomText = new StringBuilder(numChars);
		for(int i = 0; i < numChars; i++){
			int r = myRandom.nextInt(myText.length() - 1);
			randomText.append(myText.charAt(r));
		}
		return randomText.toString();
	}
	
	
}
