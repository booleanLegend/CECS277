/** 
* Fire-is a Decoration that extends MonsterDecorator
*/
public class Fire extends MonsterDecorator {
  /**
  *Fire constructor - Passes in Monster object method
  *super calls the constructor of the superclass
  *@param m is a monster
  */
	public Fire (Monster m){
    	super(m, "Fire ", 2);
  	}
  /**
  Attack() - Overrides the abstract attack method in the Monster Class
  @return Returns 2 and super adds more attack to the value returned.
  */
  	@Override
  	public int attack () {
    	return 2 + super.attack();
  	}
}