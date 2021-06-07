/** 
* Lasers-is a Decoration that extends MonsterDecorator
*/
public class Lasers extends MonsterDecorator{
  /**
  *Lasers constructor - Passes in Monster object method
  *super calls the constructor of the superclass
  *@param m is a monster
  */
  public Lasers(Monster m){
    super(m,"Laser" , 4);
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