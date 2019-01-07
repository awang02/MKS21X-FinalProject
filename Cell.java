public class Cell{
  public boolean mine;// false means no mine; true means cell has mine
  public int coveredStatus;// positive means uncovered; 0 means covered; negative means flagged
  public int  mineNum;//the number of neighboring cells with mines; if cell has a mine, this number is negative
  public int coorX;
  public int coorY;


  //constructors
  //default constructor: covered cell with no mine, no neighbor mines at (0,0)
  public Cell(){
    mine = false;
    coveredStatus = 0;
    mineNum = 0;
    coorX = 0;
    coorY = 0;
  }

  public Cell(boolean aMine, int coveredStat, int mineNumber, int theX, int theY){
    mine = aMine;
    coveredStatus = coveredStat;
    coorX = theX;
    coorY = theY;
    if(mine == true){
      mineNum = (mineNum * 0) - 15; //mine cells have mineNum -15;
    }
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
