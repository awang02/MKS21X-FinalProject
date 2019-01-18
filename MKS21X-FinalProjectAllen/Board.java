public class Board {
  private Cell[][] grid;

  // constructors
  public Board(){
    grid = new Cell[12][12]; // a playable 10 x 10 grid is created; the outermost edges are borders
    for (int x = 0; x < grid.length; x++) {
      for (int y = 0; y < grid[0].length; y++) {
        grid [x][y] = new Cell(//insert fields here);
      }
    }
    setMines(10);
  }

// helper function that places mines on the game grid
  public void setMines (int numOfMines){
    int counter = 0;
    while (counter < numOfMines) {
      int coordX = Math.abs(randgen.nextInt(10)) + 1; //+1 to compensate buffer which shouldn't have mines
      int coordY = Math.abs(randgen.nextInt(10)) + 1; //+1 to compensate buffer which shouldn't have mines
      //System.out.println(coordX + "," + coordY); //debugging in driver
      if(!grid[coordX][coordY].isMine()){
        grid[coordX][coordY].setMine(true);
        neighborMineNumsPlus(coordX, coordY); // this helper function assigns minenums to all adjacent cells of a mine
        counter ++;
      }
    }
  }

  public void adjacentMinesCounter (int xcor, int ycor){
    //8 cells surrounding once cell
    grid[xcor][ycor + 1].addMineNeighbor();
    grid[xcor][ycor - 1].addMineNeighbor();
    grid[xcor + 1][ycor].addMineNeighbor();
    grid[xcor - 1][ycor].addMineNeighbor();
    grid[xcor + 1][ycor + 1].addMineNeighbor();
    grid[xcor + 1][ycor - 1].addMineNeighbor();
    grid[xcor - 1][ycor + 1].addMineNeighbor()
    grid[xcor - 1][ycor - 1].addMineNeighbor();
}
  }
}
