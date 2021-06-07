/**
* interface Magical - interface that constructs abstract methods to use when magical attacks are used
*/
public interface Magical {
	/*
	* Menu that displays when hero encounters a Magical Enemy
	*/
	public static final String MAGIC_MENU = "1. Magic Missile\n2. Fireball\n3. Thunderclap";
	/*
	* Method that uses a magicMissile against the Entity passed in 
	* @param e - Entity passed in such as hero object
	*/
	public String magicMissile(Entity e);
	/*
	* Method that uses a fireball against the Entity passed in
	* @param e - Entity passed in such as hero object
	*/
	public String fireball(Entity e);
	/*
	* Method that uses a thunderclap against the Entity passed in
	* @param e - Entity passed in such as hero object
	*/
	public String thunderclap(Entity e);
}