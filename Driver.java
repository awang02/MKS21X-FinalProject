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

    //CREATE BETTER INSTRUCTIONS L8ER
    String instruction = "enter number of rows, number of columns and number of mines. optional: enter seed num";

    try{

    //if number of mines > number of cells existing, print error
      if((Integer.parseInt(args[0]) < 0) || (Integer.parseInt(args[1]) < 0)){
        System.out.println("The row and column must be positive" + '\n' + instruction);
        System.exit(1);
      }
      if (args.length > 2 && Integer.parseInt(args[0]) * Integer.parseInt(args[1]) < Integer.parseInt(args[2])){
        System.out.println("The number of mines exceeds the number of cells" + '\n' + instruction);
        System.exit(1);
      }
      if (args.length < 3){
        System.out.println(instruction);
      }
      if (args.length == 3){
        defaultRow = Integer.parseInt(args[0]);
        defaultCol = Integer.parseInt(args[1]);
        defaultMines = Integer.parseInt(args[2]);
        System.out.println(new Board(defaultRow, defaultCol, defaultMines, seed));
      }
      if (args.length >= 4 && (Integer.parseInt(args[4]) < 0 || Integer.parseInt(args[4]) > 10000 )){
        System.out.println("The seed (fourth argument) must be between 0 and 10000 inclusive" + '\n' + instruction);
        System.exit(1);
      }
      if (args.length == 4 || args.length > 4){
        defaultRow = Integer.parseInt(args[0]);
        defaultCol = Integer.parseInt(args[1]);
        defaultMines = Integer.parseInt(args[2]);
        seed = Integer.parseInt(args[3]);
        System.out.println(new Board(defaultRow, defaultCol, defaultMines, seed));
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
