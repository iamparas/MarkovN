package markovText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MarkovRunner {
	public void runMarkov(String trainingFileName){
		String trainingText = read(trainingFileName);
		MarkovN markov = new MarkovN(20);
		markov.setTraining(trainingText);
		markov.setRandom(25);
		System.out.println(markov.genRandomText(100));
		
	}
	
	public String read(String fileName){
		StringBuilder builder = new StringBuilder();
		try{
			BufferedReader read = new BufferedReader(new FileReader(fileName));
			String ln = read.readLine();
			while(ln != null){
				builder.append(ln.replace("\n", ""));
				ln = read.readLine();
			}
		}catch(IOException e){
			System.out.println(e);
		}
		return builder.toString();
	}
	public static void main(String[] args){
		MarkovRunner mv = new MarkovRunner();
		mv.runMarkov("/Users/parash/Documents/workspace/GenRandomText/src/markovText/romeo_and_juliet");
	}
}
