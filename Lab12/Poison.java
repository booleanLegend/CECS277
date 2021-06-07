/** 
* Poison-is a Decoration that extends MonsterDecorator
*/
public class Poison extends MonsterDecorator{
  /**
  *Speed constructor - Passes in Monster object method
  *super calls the constructor of the superclass
  *@param m is a monster
  */
  public Poison(Monster m){
    super(m,"Poison ", 5);
  }
  /**
  Attack() - Overrides the abstract attack method in the Monster Class
  @return Returns 3 and super adds more attack to the value returned.
  */
  @Override
  public int attack(){
    return 3 + super.attack();

  }
  
}