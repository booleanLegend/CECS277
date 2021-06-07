/*
Lab 14				Name: _______________________
Tic-Tac-Toe – Memento Pattern

Necessary Components:
______ / .5		1.  Has: Board class, Memento class, and Main.
______ / .5		2.  Memento has char[][], constructor, and getState method.
______ /  1		3.  Board has char[][], placeToken, display, save, and restore.
______ / .5		4.  Main has a Stack of Mementos and a Board object.
______ / .5		5.  Main’s loop toggles between token ‘x’ and ‘o’.
______ / .5		6.  Main adds a Memento to the Stack at the start of x’s turn.
______ / .5		7.  Main reverts to previous state when user chooses.

Output:
______ / .5		8.  Prompts user to place token, revert, or to quit.
______ / .5		9.  Prompts user for row and column of token to add.
______ / .5		10.  Displays board with correct token placement.
______ /  1		11.  Displays board with correct token placement after reverting.
______ / .5		12.  Ends program when user chooses quit.
______ / .5		13.  Error checks all user input.

Formatting:
______ /  1		14.  Classes, instance variables, and methods are all Javadoced.
______ / .5		15.  Program has meaningful variable and method names
______ /  1		16.  Program has correct tabs and spacing

Extra Credit:
______ /  1		1.  Game randomly places ‘o’.
______ / .5		2.  Board class has methods to check for win and cat’s game.
______ / .5		3.  Game correctly detects a win or a cat’s game.

Total:
______ / 10 Points

*/