public class Cell {
  public boolean mine; // this boolean determines if the cell is a mine (true) or not (false)
  public int minesAdjacent; // this int represents the number of adjacent cells that are mines
  public int xcor;
  public int ycor;

  public boolean isMine(){
    return mine;
  }

  public void setMine(boolean bool){
    mine = bool;
  }

  public void addMineNeighbor(){
    minesAdjacent++;
  }

  
