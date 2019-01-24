/* //******* COMPILE AND RUN VIA LINES BELOW YO
//javac -cp lanterna.jar:. Driver.java
//java -cp lanterna.jar:. Driver

//API : http://mabe02.github.io/lanterna/apidocs/2.1/
import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;
*/
import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Driver extends Board{
  public static void main(String[] args){
    //USER INPUT SYSTEM BEING WORKED ON FOR LATERS
      //Board(int rows, int cols, int mines, int seeder): constructor for reference

      //randSeed
      Random randooo = new Random();
      int seed = randooo.nextInt(1001); //random number up to 1001

      boolean lost = false;
      int numFlagged = 0;

      Scanner reader = new Scanner(System.in);  // Reading from System.in
      System.out.println("Choose a level (enter the integer):" + '\n' + "   1. Easy" + '\n' + "   2. Medium" + '\n' + "   3. Hard" + '\n' + "   4. Custom");
      int a = reader.nextInt(); // Scans the next token of the input as an int.


      if(a == 1){
        System.out.println("Easy Mode (10x10 - 10 Mines)");
        Board easyBoard = new Board(10, 10, 10, seed);
        while(!lost){
          System.out.println(easyBoard.toStringBoard());
      //    System.out.println(easyBoard.toStringDebug());
          System.out.println("Uncover(1) or flag(2)? ");
          int covering = reader.nextInt();
          System.out.println("Enter row (number): ");
          int xCor = reader.nextInt();
          System.out.println("Enter column (letter): ");
          int yCor = reader.nextInt();
          if(covering == 1){
            easyBoard.uncoverZeros(xCor, yCor);
          }
          if(covering == 2){
            covering = -1;
          }
          easyBoard.getCell(xCor - 1, yCor - 1).setCovered(covering);
          if(easyBoard.getCell(xCor - 1, yCor - 1).isMine()){
            lost = true;
            System.out.println(easyBoard);
          }
        }
      }

      else if(a == 2){
        System.out.println("Medium Mode (16x16 - 40 Mines)");
        Board mediumBoard = new Board(16, 16, 40, seed);
        while(!lost){
          System.out.println(mediumBoard.toStringBoard());
      //    System.out.println(easyBoard.toStringDebug());
          System.out.println("Uncover(1) or flag(2)? ");
          int covering = reader.nextInt();
          System.out.println("Enter row (number): ");
          int xCor = reader.nextInt();
          System.out.println("Enter column (letter): ");
          int yCor = reader.nextInt();
          if(covering == 1){
            mediumBoard.uncoverZeros(xCor, yCor);
          }
          if(covering == 2){
            covering = -1;
          }
          mediumBoard.getCell(xCor - 1, yCor - 1).setCovered(covering);
          if(mediumBoard.getCell(xCor - 1, yCor - 1).isMine()){
            lost = true;
            System.out.println(mediumBoard);
          }
        }

      }
      else if(a == 3){
        System.out.println("Hard Mode (16x30 - 99 Mines)");
        Board hardBoard = new Board(16, 30, 99, seed);
        while(!lost){
          System.out.println(hardBoard.toStringBoard());
      //    System.out.println(easyBoard.toStringDebug());
          System.out.println("Uncover(1) or flag(2)? ");
          int covering = reader.nextInt();
          System.out.println("Enter row (number): ");
          int xCor = reader.nextInt();
          System.out.println("Enter column (letter): ");
          int yCor = reader.nextInt();
          if(covering == 1){
            hardBoard.uncoverZeros(xCor, yCor);
          }
          if(covering == 2){
            covering = -1;
          }
          hardBoard.getCell(xCor - 1, yCor - 1).setCovered(covering);
          if(hardBoard.getCell(xCor - 1, yCor - 1).isMine()){
            lost = true;
            System.out.println(hardBoard);
          }
        }
      }


      else if(a == 4){

        System.out.println("Custom Mode (max: 30x24 - 200 Mines)");
        System.out.println("Number of rows? (up to 30)");
        int row = reader.nextInt();
        System.out.println("Number of columns? (up to 24)");
        int col = reader.nextInt();
        if((row < 0) || (col < 0)){
          System.out.println("The row and column must be positive");
          System.exit(1);
        }
        System.out.println("Number of mines?");
        int bomb = reader.nextInt();
        if (row * col < bomb){
          System.out.println("The number of mines exceeds the number of cells");
          System.exit(1);
        }
        System.out.println("Optional Seed: Type a number 1-10000 or type 0 for a randomly generated seed");
        int seeddd = reader.nextInt();
        if(seed == 0){
          seeddd = seed;
        }

        Board customBoard = new Board(row, bomb, 10, seeddd);
        while(!lost){
          System.out.println(customBoard.toStringBoard());
      //    System.out.println(easyBoard.toStringDebug());
          System.out.println("Uncover(1) or flag(2)? ");
          int covering = reader.nextInt();
          System.out.println("Enter row (number): ");
          int xCor = reader.nextInt();
          System.out.println("Enter column (letter): ");
          int yCor = reader.nextInt();
          if(covering == 1){
            customBoard.uncoverZeros(xCor, yCor);
          }
          if(covering == 2){
            covering = -1;
          }
          customBoard.getCell(xCor - 1, yCor - 1).setCovered(covering);
          if(customBoard.getCell(xCor - 1, yCor - 1).isMine()){
            lost = true;
            System.out.println(customBoard);
          }
        }
      }


      else{
        System.out.println("Invalid entry. Re-run the program and make sure you enter in an valid integer level: 1, 2, 3, or 4");
      }
  }
}
