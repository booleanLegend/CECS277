/** PuppyState interface that the three state classes will implement */
public interface PuppyState {
	public void play(Puppy p);
	public void feed(Puppy p);
	public void sleep(Puppy p);
}