# MKS21X-FinalProject
Team Gecko's Amazing Minesweeper !!!

1/3/18
Geena: I began writing up the class Mine and Cell (finished all the constructors and began methods). However, after reviewing our class structure, Allen and I decided to make the classes Cell and Board.

1/4/18
Geena: I mostly finished up the new default constructors for class Cell and Board. I also ironed out the new class format (fields & methods). I typed up the hasMine method. Allen and I both messed with the terminalDemo and jar file since it'll play a key role in how our project is presented.

Allen: He worked on the hasMine method.

1/7/18
Geena: Today, I coded the randomized mine assignments in the Board class. On top of that, I also wrote up the non-default constructors in both classes, a setMine statement in the Cell class, and a clear method in the Board class. I also imported a couple of packages.

Allen: I worked on the mineNum method which gives the cells on the board a number that indicates the number of mines that are adjacent.

1/8/18
Geena: I coded how each cell will keep track of the number of neighboring cells with mines (aka the mineNum): for each mine that gets placed, the mineNum of the surrounding cells increase by 1 (Board class class mineNumPlus from the Cell class). To eliminate all the edge cases and exception errors arising with this system, I coded 2 extra buffer rows and columns which will never have mines and never show up on the printed board the user will interact with. I coded the toString and toStringDebug methods and later updated the Board's toString to compensate for the extra buffer rows and columns.

1/9/18
Geena: I coded a helper function for the Board constructor called neighborMineNumsPlus. Also began the generic constructor that can take in any amount of numbers, I also added some exceptions there where it was applicable. Then I added a bunch of test cases, some of them still don't work which needs to be fixed.

Allen: Worked on trying to implement lanterna with the existing board and cell classes.

1/10/18
Geena: Today, we created a driver class to test our code. Now our code can interact with the user with some instructions to guide them, this also makes testing our code a lot easier. I was also able to add in default values and try catch statements to make the code much more robust.


Allen: Worked on optimizing the helper functions in the board class.
