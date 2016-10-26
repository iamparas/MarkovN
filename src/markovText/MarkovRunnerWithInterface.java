package markovText;

public class MarkovRunnerWithInterface {

	public void runModel(IMarkovModel markov, String text, int n){
		markov.setTraining(text);
		printOut(markov.genRandomText(n));
	}
	
	public void runMarkov(){
		IMarkovModel[] markovModels = {new MarkovOne(), new MarkovTwo(), new MarkovFour(), new MarkovWordOne()};
		
		for(IMarkovModel m : markovModels){
			runModel(m, "hello hello hello ke cha bello mellow sello tello kello", 5);
		}
		
	}
	
	public void printOut(String text){
		System.out.println(text);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarkovRunnerWithInterface mr = new MarkovRunnerWithInterface();
		mr.runMarkov();
	}

}
