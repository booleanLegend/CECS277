/** 
* Strength-is a Decoration that extends MonsterDecorator
*/
public class Strength extends MonsterDecorator{
  /**
  *Strength constructor - Passes in Monster object method
  *super calls the constructor of the superclass
  *@param m is a monster
  */
  public Strength(Monster m){
    super(m, "Strength " , 5);
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