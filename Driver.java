import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Driver{
  public static void main(String[] args) {
    //Board(int rows, int cols, int mines, int seeder): constructor for reference
    //rows & cols & mines
    int defaultRow = 10;
    int defaultCol = 10;
    int defaultMines = 10;
    //randSeed
    Random randooo = new Random();
    int seed = randooo.nextInt(1001);

    String instruction = "ENTER INSTRUCTION HERE L8TER";

    try{
    //if number of mines > number of cells existing, print error
    if((Integer.parseInt(args[0]) < 0) || (Integer.parseInt(args[1]) < 0)){
        System.out.println("The row and column must be positive" + '\n' + instruction);
        System.exit(1);
      }
    }
    catch(Exception e){
      System.out.println("You messed up somewhere hun. Check yo self" + '\n' + instruction);
    }



  /*  Board tester = new Board();
    System.out.println(tester);
    System.out.println(tester.toStringDebug());
    Board tester1 = new Board(15, 15, 10, 37253);
    System.out.println(tester1.toStringDebug());
    Board tester2 = new Board(15, 15, 10, 67223);
    System.out.println(tester2.toStringDebug());
    Board tester3 = new Board(15, 15, 10, 223);
    System.out.println(tester3.toStringDebug());
    Board tester4 = new Board(15, 15, 10, 3723);
    System.out.println(tester4.toStringDebug());
    Board tester5 = new Board(15, 15, 10, 37);
    System.out.println(tester5.toStringDebug());
    Board tester6 = new Board(6, 6, 10, 2);
    System.out.println(tester6.toStringDebug());
    */
  }


}
