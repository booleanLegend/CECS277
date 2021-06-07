/**
* PlayState - State in which the Puppy is playing
*/
public class PlayState implements PuppyState {
	/**
	* play - Overriden method that calls play during the PlayState
	* @param p - Passes in the Puppy object
	*/
	@Override
	public void play(Puppy p) {
		if (p.getPlayCount() < 3) {
			System.out.println("You throw the ball again and the puppy excitedly chases it.");
			p.increasePlayCount();
			if (p.getPlayCount() == 3) {
				System.out.println("The puppy played so much it fell asleep.");
				p.resetPlayCount();
				p.resetFeedCount();
				p.setState(new SleepState());
			} else {
				p.setState(new PlayState()); 
			}	
		}
	}

	/**
	* play - Overriden method that calls feed during the PlayState
	* @param p - Passes in the Puppy object
	*/
	@Override
	public void feed(Puppy p) {
		System.out.println("\nThe puppy wakes up and comes running to eat.");
		p.increaseFeedCount();
		p.setState(new FeedState()); //puppy now goes to the feedstate
	}

	/* sleep - Overriden method that calls sleep during the PlayState
	 * @param p - Passes in the Puppy object
	 */
	@Override
	public void sleep(Puppy p) {
		if (p.getPlayCount() == 3) {
			System.out.println("The puppy played so much it fell asleep.");
			p.setState(new SleepState()); 
		}
	}
}