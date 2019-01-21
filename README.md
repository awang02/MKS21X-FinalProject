# MKS21X-FinalProject
Team Gecko's Amazing Minesweeper !!!

1/3/18
Geena: I began writing up the class Mine and Cell (finished all the constructors and began methods). However, after reviewing our class structure, Allen and I decided to make the classes Cell and Board.

1/4/18
Geena: I mostly finished up the new default constructors for class Cell and Board. I also ironed out the new class format (fields & methods). I typed up the hasMine method. Allen and I both messed with the terminalDemo and jar file since it'll play a key role in how our project is presented.

1/7/18
Geena: Today, I coded the randomized mine assignments in the Board class. On top of that, I also wrote up the non-default constructors in both classes, a setMine statement in the Cell class, and a clear method in the Board class. I also imported a couple of packages.

Allen: I worked on the mineNum method which gives the cells on the board a number that indicates the number of mines that are adjacent.

1/8/18
Geena: I coded how each cell will keep track of the number of neighboring cells with mines (aka the mineNum): for each mine that gets placed, the mineNum of the surrounding cells increase by 1 (Board class class mineNumPlus from the Cell class). To eliminate all the edge cases and exception errors arising with this system, I coded 2 extra buffer rows and columns which will never have mines and never show up on the printed board the user will interact with. I coded the toString and toStringDebug methods and later updated the Board's toString to compensate for the extra buffer rows and columns.

1/9/18
Geena: I coded a helper function for the Board constructor called neighborMineNumsPlus. Also began the generic constructor that can take in any amount of numbers, I also added some exceptions there where it was applicable. Then I added a bunch of test cases, some of them still don't work which needs to be fixed.

1/10/18
Geena: Today, we created a driver class to test our code. Now our code can interact with the user with some instructions to guide them, this also makes testing our code a lot easier. I was also able to add in default values and try catch statements to make the code much more robust.

Allen: Worked on optimizing the helper functions in the board class.

1/14/18
I was able to move my files around so that lanterna could actually interact with my Board class over the weekend. I worked with Lanterna and got comfortable with what changing colors and commands did.

1/15/18
I created a new class TerminalBoard to do all the lanterna stuff but quickly realized I made the Driver class do a bunch of main(String[] args) stuff that I need. So I combined everything useful from TerminalBoard into the Driver. But before I did that, I tested a bunch of new cases (edge/exception/etc) using terminal inputs, everything seems pretty a-okay.

1/16/18
I got Lanterna to interact with my board and code! I fixed up the mine class toString and constructor because it was printing weirdly with lantern. The timer and cursor coordinates also show up on the terminal when it runs.

1/17/18
I made major movements in the Driver where I backtracked to printing actions and using keys to prompt the user for coordinates. I've decided I'm going to go through with lanterna and the cursor method of interacting with the game though. I've found some faults with my toString, since Strings are not immutable, using the printing would be very clumsy and ugly code. I've designated the Driver class for printing the grid and using the inputted coordinates way; the TerminalDemo class will be for lanterna stuff.


1/18/18
 I made a new toStringBoard method which covers all the cells (hides mines and numbers). Now I'm in the process of connecting lanterna to this code. I also made improvements in the initialization of the board. Inputting dimensions and number of mines works reliably now. 
