public class Board{
  //fields
  private Cell[][] cellGrid;
  private String[][] printCell;

  //constructors
  //this is the default grid which instatiates a 10 by 10 grid and plants 10 random mines
  public Board(){
    cellGrid = new Cell[10][10];
    clear();
  }

  private void clear(){
    for (int x = 0; x < cellGrid.length; x++){
      for (int y = 0; y < cellGrid[x].length; y++){
        cellGrid[x][y] = new Cell();
      }
    }
  }


}
