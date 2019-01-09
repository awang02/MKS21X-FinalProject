# MKS21X-FinalProject
Team Gecko's Amazing Minesweeper !!!

1/3/18
Geena: I began writing up the class Mine and Cell (finished all the constructors and began methods). However, after reviewing our class structure, Allen and I decided to make the classes Cell and Board.

1/4/18
Geena: I mostly finished up the new default constructors for class Cell and Board. I also ironed out the new class format (fields & methods). I typed up the hasMine method. Allen and I both messed with the terminalDemo and jar file since it'll play a key role in how our project is presented.

Allen: He worked on the hasMine method.

1/7/18
Geena: Today, I coded the randomized mine assignments in the Board class. On top of that, I also wrote up the non-default constructors in both classes, a setMine statement in the Cell class, and a clear method in the Board class. I also imported a couple of packages.

1/8/18
Geena: I coded how each cell will keep track of the number of neighboring cells with mines (aka the mineNum): for each mine that gets placed, the mineNum of the surrounding cells increase by 1 (Board class calss mineNumPlus from the Cell class). To eliminate all the edge cases and exception errors arising with this system, I coded 2 extra buffer rows and columns which will never have mines and never show up on the printed board the user will interact with. I coded the toString and toStringDebug methods and later updated the Board's toString to compensate for the extra buffer rows and columns.
