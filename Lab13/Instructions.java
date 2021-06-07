/*
CECS 277– Lab 13
Puppy Simulator – State Pattern
Using the State Pattern, create a puppy simulator program that has two basic functions: feed or play with the puppy. 
The puppy will react differently to these functions based on which state it is in. 
The puppy has three possible states: asleep, eating, or playing.  
The puppy simulator begins in the asleep state.
When the puppy is asleep, the only way to wake it up is to feed it.  
It will come running when it hears its food bowl being filled.
When the puppy is eating, it can continue to eat until it’s so full that it will fall back asleep (~2 or 3 times), or if you can distract it with a ball, then it will play with you.
When the puppy is playing, you can continue playing with it until they get so tired that it falls asleep again (~3 times).
The Puppy class will require instance variables to keep track of the number of times it has been fed and played with, functions to increment, access, and reset those values when needed.  
Example Output:
Congratulations on your new puppy!
What would you like to do?
1. Feed
2. Play
3. Quit
2
The puppy is asleep.
It doesn't want to play right now.
What would you like to do?
1. Feed
2. Play
3. Quit
1
The puppy wakes up and comes running to eat.
What would you like to do?
1. Feed
2. Play
3. Quit
1
The puppy continues to eat as you add another scoop of kibble to its bowl.
What would you like to do?
1. Feed
2. Play
3. Quit
1
The puppy continues to eat as you add another scoop of kibble to its bowl.
The puppy ate so much it fell asleep!
What would you like to do?
1. Feed
2. Play
3. Quit
2
The puppy is asleep. It doesn't want to play right now.
What would you like to do?
1. Feed
2. Play
3. Quit
1
The puppy wakes up and comes running to eat.
What would you like to do?
1. Feed
2. Play
3. Quit
2
The puppy looks up from its food and chases the ball you threw.
What would you like to do?
1. Feed
2. Play
3. Quit
2
You throw the ball again and the puppy excitedly chases it.
What would you like to do?
1. Feed
2. Play
3. Quit
2
You throw the ball again and the puppy excitedly chases it.
The puppy played so much it fell asleep. 
What would you like to do?
1. Feed
2. Play
3. Quit
1
The puppy wakes up and comes running to eat.
What would you like to do ? 
1. Feed
2. Play
3. Quit
1
The puppy continues to eat as you add another scoop of kibble to its bowl.
What would you like to do?
1. Feed
2. Play
3. Quit
1
The puppy continues to eat as you add another scoop of kibble to its bowl.
The puppy ate so much it fell asleep!
What would you like to do?
1. Feed
2. Play
3. Quit
3
*/