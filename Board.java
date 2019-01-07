import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Board{
  //fields
  private Cell[][] cellGrid;
  private int seed;
  private Random randgen;


  //constructors
  //this is the default grid which instatiates a 10 by 10 grid and plants 10 random mines
  public Board(){
    cellGrid = new Cell[10][10];
    clear();
  }

  //clean board
  private void clear(){
    for (int x = 0; x < cellGrid.length; x++){
      for (int y = 0; y < cellGrid[x].length; y++){
        cellGrid[x][y] = new Cell();
      }
    }
  }



  public String toString(){
    String print = "";
    return "blah";
  }





}
