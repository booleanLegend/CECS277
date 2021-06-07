/**
* SleepState - State in which the Puppy is asleep
*/
public class SleepState implements PuppyState {
	/**
	* play - Overriden method that calls play during the SleepState
	* @param p - Passes in the Puppy object
	*/
  	@Override
	public void play(Puppy p) {
		System.out.println("The puppy is asleep. It doesn't want to play right now.\n");
		p.setState(new PlayState());
	}
	/**
	* feed - Overriden method that calls feed during the SleepState
	* @param p - Passes in the Puppy object
	*/
	@Override
	public void feed(Puppy p) {
		System.out.println("The puppy wakes up and comes running to eat.\n");
		p.increaseFeedCount();
		p.setState(new FeedState());
	}
	/**
	* sleep - Overriden method that calls sleep during the SleepState
	* @param p - Passes in the Puppy object
	*/
	@Override
	public void sleep(Puppy p) {
		System.out.println("You can't make the puppy go to sleep when it's already asleep, you dork!\n");
	}
}