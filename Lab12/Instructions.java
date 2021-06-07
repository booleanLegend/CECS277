/*
CECS 277– Lab 12
Monster Maker–Decorator Pattern

Using the Decorator Pattern, create a monster maker program that uses three base types of monsters (ex. Alien, Beast, Zombie, Vampire, Mummy, etc.). Those monsters can then be decorated with at least three different monster abilities (ex. lasers, poison, flying, speed, strength, fire, etc.). 

Rather than an interface, you should create an abstract Monster class. A monster has a name and hp. The Monster should have a getName and getHP methods, as well as an abstract attack method. Your base monster classes should extend from the abstract class, set the name and hp, and should override the attack method (give each of your monsters different names, hp, and attack damage).

The MonsterDecorator class’s constructor should pass in the Monster, the updated name for the monster, and the updated hp of the monster.

The Monster abilities (decorations) classes should each have a constructor that passes the updated name and hp to the MonsterDecorator. They should also each override the attack method to add more attack damage to the value returned.

The main method should present the user with a menu to choose the base monster type, and display the stats of the monster. Then repeatedly allow the user to choose an ability to apply to their monster, and then display the monster’s updated stats. Also allow the user to quit.

Example Output:
Monster Creator!
Choose a base monster:
1. Alien
2. Beast	
3. Undead
1
Alien has 6 hp, and attacks for 1 damage.
Add an ability:
1. Fire
2. Flying
3. Lasers
4. Poison
5. Quit
2
Flying Alien has 8 hp, and attacks for 4 damage.
Add an ability:
1. Fire
2. Flying
3. Lasers
4. Poison
5. Quit
1
Firey Flying Alien has 10 hp, and attacks for 9 damage.
Add an ability:
1. Fire
2. Flying	
3. Lasers
4. Poison
5. Quit
1
Firey Firey Flying Alien has 12 hp, and attacks for 14 damage.
Add an ability:
1. Fire
2. Flying
3. Lasers
4. Poison
5. Quit
3
Firey Firey Flying Alien with Laser Beams has 13 hp, and attacks for 18 damage.
Add an ability:
1. Fire
2. Flying
3. Lasers
4. Poison
5. Quit
4
Poison Fanged Firey Firey Flying Alien with Laser Beams has 14 hp, and attacks for 22 damage.
Add an ability:
1. Fire
2. Flying
3. Lasers
4. Poison
5. Quit
5
Exiting
*/