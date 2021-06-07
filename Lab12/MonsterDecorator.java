/**
* MonsterDecorator - Abstract class that extends abstract class Monster
* Decorates the monster by adding a bigger name and hp 
*/
public abstract class MonsterDecorator extends Monster {
	//	monster - Instance variable of type Monster
	private Monster monster;
	/**
	* MonsterDecorator - Constructor that uses super to pass updated name and hp to Monster class
	* @param m - Monster variable 
	* @param n - Name of monster (m)
	* @param hp - hp of monster (m)
	*/
	public MonsterDecorator(Monster m, String n, int hp) {
		super(n + " " + m.getName(), m.getHp() + hp);
		monster = m;
	}
	/**
	*Attack() - Overrides the abstract attack method in the Monster Class
	*/
	@Override
	public int attack() {
		return monster.attack();
	}
}