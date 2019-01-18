//to do list:
//make a board constructor that works
//for all cellGrid dimensions and number of mines (import scanner and do user input stuff)
//make the random seed not static and print it in the toString for reference
//get started on the coveredStat of the cell & how that's going to works
//lanterna and terminal stuff mastery
//in constructor, also assign each new cell a coorX and coorY (do we need these fields though? reconsider)

import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Board{
  //fields
  public Cell[][] cellGrid;
  private int seed;
  private Random randgen;


  //constructors
  //this is the default grid which instatiates a 10 by 10 grid and plants 10 random mines
  public Board(){
    //no mine, no num grid
    cellGrid = new Cell[12][12]; //buffer cells on edges
    for(int r = 0; r < cellGrid.length; r++){
      for(int c = 0; c < cellGrid[0].length; c++){
        cellGrid[r][c] = new Cell(false, 0, 0, r, c);
      }
    }
    //clear();
  //HOW TO RANDOMIZE SEED IN DEFAULT BOARD
  //  Random randoSeed = new Random(748);
  //  seed = Math.abs(randoSeed.nextInt())/10000;
    seed = 473; //static seed for now
    randgen = new Random(seed); //seed of randSeed is stored.
    placeMines(10); //this plants 10 random mines
  }

  public Board(int rows, int cols, int mines, int seeder){
    cellGrid = new Cell[rows][cols]; //buffer cells on edges
    for(int r = 0; r < cellGrid.length; r++){
      for(int c = 0; c < cellGrid[0].length; c++){
        cellGrid[r][c] = new Cell(false, 0, 0, r, c);
      }
    }
    //clear();
  //HOW TO RANDOMIZE SEED IN DEFAULT BOARD
  //  Random randoSeed = new Random(748);
  //  seed = Math.abs(randoSeed.nextInt())/10000;
    seed = seeder; //static seed for now
    randgen = new Random(seed); //seed of randSeed is stored.
    //this plants 10 random mines
    placeMines(mines);
  }

  // helper function that places mines on the board
  public void placeMines(int minesOnBoard) {
    int counter = 0;
    while (counter < minesOnBoard) {
      int coordX = Math.abs(randgen.nextInt(10)) + 1; //+1 to compensate buffer which shouldn't have mines
      int coordY = Math.abs(randgen.nextInt(10)) + 1; //+1 to compensate buffer which shouldn't have mines
      //System.out.println(coordX + "," + coordY); //debugging in driver
      if(!cellGrid[coordX][coordY].isMine()){
        cellGrid[coordX][coordY].setMine(true);
        neighborMineNumsPlus(coordX, coordY); // this helper function assigns minenums to all adjacent cells of a mine
        counter ++;
      }
    }
  }

/*  public void accessGrid(int r1, int c1, int CCC) {
    if(CCC < 0){
      return "";
    }
  }*/

  //helper funtion that makes assigns neighbor (adjacent) mineNums all go up
  public void neighborMineNumsPlus(int theXCoord, int theYCoord){
    //neighbor mineNums all go up
    cellGrid[theXCoord][theYCoord + 1].mineNumPlus();
    cellGrid[theXCoord][theYCoord - 1].mineNumPlus();
    cellGrid[theXCoord + 1][theYCoord].mineNumPlus();
    cellGrid[theXCoord - 1][theYCoord].mineNumPlus();
    cellGrid[theXCoord + 1][theYCoord + 1].mineNumPlus();
    cellGrid[theXCoord + 1][theYCoord - 1].mineNumPlus();
    cellGrid[theXCoord - 1][theYCoord + 1].mineNumPlus();
    cellGrid[theXCoord - 1][theYCoord - 1].mineNumPlus();
  }

  //in other constructors (esp ones with scanner user inputs),
  //don't forget to add 2 to rows & columns for the buffer

  //clean board
  private void clear(){
    for (int x = 0; x < cellGrid.length; x++){
      for (int y = 0; y < cellGrid[x].length; y++){
        cellGrid[x][y] = new Cell();
      }
    }
  }
  public void enterAction(int x_, int y_, int pick){
    //flag = -1 ; uncovered = 1
    cellGrid[x_][y_].setCovered(pick);
  }

  public String toString(){
    // the numbers in the for loops have been modefied to only show the main cells and none of the buffer
    String print = "";
    for (int t = 1; t < cellGrid.length - 1; t++){
      print += "|";
      for (int y = 1; y < cellGrid[t].length - 2; y++){
        //no show
        if(cellGrid[t][y].getCovered() == 0){
          print += cellGrid[t][y] + " ";
        }
        //flagged
        else if(cellGrid[t][y].getCovered() == -1){
          print += cellGrid[t][y] + "*";
        }
        //uncovered
        else{
          print += cellGrid[t][y] + " ";

        }
      }
      print += cellGrid[t][cellGrid[t].length - 2];
      print += "|\n";
    }
    return print + "\nSeed: " + seed +"\n";
  }

  public String toStringDebug(){
    //this one prints the entire cellGrid, including the edge buffers
    String print = "";
    for (int t = 0; t < cellGrid.length; t++){
      print += "|";
      for (int y = 0; y < cellGrid[t].length - 1; y++){
        print += cellGrid[t][y] + " ";
      }
      print += cellGrid[t][cellGrid[t].length - 1];
      print += "|\n";
    }
    return print + "\nSeed: " + seed;
  }


  public String toStringBoard(){
    // the numbers in the for loops have been modefied to only show the main cells and none of the buffer
    String print = "   ";
    for (int t = 1; t < cellGrid[0].length - 1; t++){
      print += t % 10 + " ";
    }
    print += '\n';
    for (int t = 1; t < cellGrid.length - 1; t++){
      if(cellGrid[t][1].getCovered() == 0 && t < 10){
        print += " " + t + "|" + " ";
      }
      else if(cellGrid[t][1].getCovered() == 0){
        print += t + "|" + " ";
      }
      else if(cellGrid[t][1].getCovered() < 0 && t < 10){
        print += " " + t + "|" + "#";
      }
      else if(cellGrid[t][1].getCovered() < 0){
        print +=  t + "|" + "#";
      }
      else if(t < 10){
        print += " " + t + "|" + cellGrid[t][1];
      }
      else{
        print += t + "|" + cellGrid[t][1];
      }
      for (int y = 1; y < cellGrid[t].length - 2; y++){
        if(cellGrid[t][y].getCovered() == 0){
          print +=  "|" + " ";
        }
        else if(cellGrid[t][y].getCovered() < 0){
          print +=  t + "|" + "#";
        }
        else{
          print += "|" + cellGrid[t][y];
        }
      }
      print += "|\n";
    }
    return print + "\nSeed: " + seed;
  }



}
