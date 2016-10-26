package markovText;

public interface IMarkovModel {
	public void setTraining(String text);
	public String genRandomText(int numChar);
}
