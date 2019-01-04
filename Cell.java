public class Cell{
  private int coorX;
  private int coorY;
  public boolean mine;// false means no mine; true means cell has mine
  public int coveredStatus;// positive means uncovered; 0 means covered; negative means flagged


  //constructors
  //default constructor: sets
  public Cell(){
    mine = false;
    coveredStatus = 0;
  }

  //methods start here






}



/*
public class Mine{
  //fields
  public int coorx;
  public int coory;
  public int numMines;

  //constructor
  //this is the default constructor that creates ten mines no matter how many cells are instantiated
  public Mine(){
    numMines = 10;
    //can't put randomizer here because cell is Mine's child
  }

  //swap IndexOut

  //
}
*/
