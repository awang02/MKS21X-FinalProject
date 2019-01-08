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
    //no mine, no num grid
    cellGrid = new Cell[10][10];
    for(int r = 0; r < cellGrid.length; r++){
      for(int c = 0; c < cellGrid[0].length; c++){
        cellGrid[r][c] = new Cell(false, 0, 0, r, c);
      }
    }
    //clear();
    seed = 182; //random static integer for now
    randgen = new Random(seed); //seed of randSeed is stored.
    //this plants 10 random mines
    int counter = 0;
    while (counter < 11){
      int coordX = Math.abs(randgen.nextInt(10));
      int coordY = Math.abs(randgen.nextInt(10));
      if(!cellGrid[coordX][coordY].hasMine()){
        cellGrid[coordX][coordY].setMine(true);
        //need to do a neighbor number assigning method here
        counter ++;
      }
    }
  }

  //clean board
  private void clear(){
    for (int x = 0; x < cellGrid.length; x++){
      for (int y = 0; y < cellGrid[x].length; y++){
        cellGrid[x][y] = new Cell();
      }
    }
  }

  public int setNumber(){
    // calculates the number of mines that are adjacent to the current cell.
    int mineCount = 0;
    int height = 10;
    int width = 10;
    for (int x = 0; x<height; x++){
      for (int y = 0; y<width; y++){
        if ( (x>0 && y>0 && cellGrid[x-1][y-1].hasMine()) ||
        (y>0 && cellGrid[x][y-1].hasMine()) ||
        (x<height-1 && y>0 && cellGrid[x+1][y-1].hasMine()) ||
        (x>0 && cellGrid[x-1][y].hasMine()) ||
        (x<10 && cellGrid[x+1][y].hasMine()) ||
        (x>0 && y<width-1 && cellGrid[x-1][y+1].hasMine()) ||
        (y<width-1 && cellGrid[x][y+1].hasMine()) ||
        (x<height-1 && y<width-1 && cellGrid[x+1][y+1].hasMine()) ) {
          mineCount++;
        }
      }
    }
    return mineCount;
  }


  public String toString(){
    String print = "";
    for (int t = 0; t < cellGrid.length; t++){
      print += "|";
      for (int y = 0; y < cellGrid[t].length - 1; y++){
        print += cellGrid[t][y] + " ";
      }
      print += cellGrid[t][cellGrid[t].length - 1];
      print += "|\n";
    }
    return print;
  }


  public static void main(String[] args) {
    Board tester = new Board();
    System.out.println(tester);
  }







}
