/**
* FeedState - State in which the Puppy is being fed
*/
public class FeedState implements PuppyState {
	/**
	* play - Overriden method that calls play during the FeedState
	* @param p - Passes in the Puppy object
	*/
	@Override
	public void play(Puppy p) {
		System.out.println("The puppy looks up from its food and chases the ball you threw.\n");
		p.increasePlayCount();
		p.setState(new PlayState());
	}
	/**
	* feed - Overriden method that calls feed during the FeedState
	* @param p - Passes in the Puppy object
	*/
	@Override
	public void feed(Puppy p) {
		if (p.getFeedCount() < 3) {
			System.out.println("The puppy continues to eat as you add another scoop of kibble to its bowl.\n");
			p.increaseFeedCount();
			if (p.getFeedCount() == 3) {
				System.out.println("The puppy ate so much it fell asleep!\n");
				p.resetFeedCount();
				p.resetPlayCount();
				p.setState(new SleepState());
			} else {
				p.setState(new FeedState());
			}
		}
	}
	/**
	* sleep - Overriden method that calls sleep during the FeedState
	* @param p - Passes in the Puppy object
	*/
	@Override
	public void sleep(Puppy p) {
		if (p.getFeedCount() == 3) {
			System.out.println("You can't make the puppy go to sleep if it's already asleep!\n");
		}
	}
}