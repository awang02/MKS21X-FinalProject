public class Cell{
  public boolean mine;// false means no mine; true means cell has mine
  public int coveredStatus;// positive means uncovered; 0 means covered; negative means flagged
  public int  mineNum;


  //constructors
  //default constructor: sets
  public Cell(){
    mine = false;
    coveredStatus = 0;
  }

  //methods start here
  public boolean hasMine(){
    return mine;
  }

/*  public int coveredStatus(){
    if()
    return
  }
  */

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
