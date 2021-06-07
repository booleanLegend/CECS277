/** Puppy class*/
public class Puppy {
	/**
	* ps - Instance of PuppyState 
	*/
	private PuppyState ps;
	/** 
	* feedCount - number of times Puppy has been fed
	*/
	private int feedCount = 0;
	/**
	* playCount - number of times Puppy has played
	*/
	private int playCount = 0;
	/**
	* Puppy - Constructor, sets the puppy to sleep state.
	*/
	public Puppy() {
		ps = new SleepState(); //Puppy Simulator beings in asleep state.
	}
	/** setState - Method puppy to set  
	* @param s - passes in PuppyState 
	*/
	public void setState(PuppyState s) {
		ps = s;
	}

	/**
	* play - Method puppy will execute play 
	*/
	public void play() {
		ps.play( this );
	}
	
	/**
	* feed - Method puppy will execute feed 
	*/
	public void feed() {
		ps.feed(this);
	}

	/**
	* increaseFeedCount - Method the increments the feedCount
	*/
	public void increaseFeedCount() {
		feedCount++;
	}
	/**
	* getFeedCount - Method that returns the feedCount
	* @return Returns an int
	*/
	public int getFeedCount() {
		return feedCount;
	}
	/**
	* resetFeedCount - Method that resetFeedCount once it reaches 3
	*/
	public void resetFeedCount() {
		feedCount = 0;
	}
	/**
	* increasePlayCount - Method that increases playCount
	*/
	public void increasePlayCount(){
		playCount++;
	}
	/**
	* getPlayCount - Method that returns the amount of times that puppy has played
	* @return Returns an int
	*/
	public int getPlayCount() {
		return playCount;
	}

	/**
	* resetPlayCount - Method that resets the playCount to 0
	* @return Returns an int
	*/
	public void resetPlayCount() {
		playCount = 0;
	}
}