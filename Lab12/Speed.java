/** 
* Speed-is a Decoration that extends MonsterDecorator
*/
public class Speed extends MonsterDecorator{
  /**
  *Speed constructor - Passes in Monster object method
  *super calls the constructor of the superclass
  *@param m is a monster
  */
  public Speed(Monster m){
    super(m, "Speed ", 1);
  }
  /**
  Attack() - Overrides the abstract attack method in the Monster Class
  @return Returns 2 and super adds more attack to the value returned.
  */
  @Override
  public int attack(){
    return 2 + super.attack();

  }
  
}