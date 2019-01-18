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
      //rows & cols & mines
      int defaultRow = 10;
      int defaultCol = 10;
      int defaultMines = 10;
      //randSeed
      Random randooo = new Random();
      int seed = randooo.nextInt(1001);

      //CREATE BETTER INSTRUCTIONS L8ER
      String instruction = "Enter number of rows, number of columns and number of mines. optional: enter seed num";

      try{
      //if number of mines > number of cells existing, print error
        if((Integer.parseInt(args[0]) < 0) || (Integer.parseInt(args[1]) < 0)){
          System.out.println("The row and column must be positive" + '\n' + instruction);
          System.exit(1);
        }
        else if (args.length > 2 && Integer.parseInt(args[0]) * Integer.parseInt(args[1]) < Integer.parseInt(args[2])){
          System.out.println("The number of mines exceeds the number of cells" + '\n' + instruction);
          System.exit(1);
        }
        else if (args.length < 3){
          System.out.println(instruction);
        }
        else if (args.length == 3){



          defaultRow = Integer.parseInt(args[0]) + 2;
          defaultCol = Integer.parseInt(args[1]) + 2;
          defaultMines = Integer.parseInt(args[2]);
          Board B = new Board(defaultRow, defaultCol, defaultMines, seed);
          String str = B.toStringBoard();
          System.out.println(str);





          boolean lost = true;
          Scanner reader = new Scanner(System.in);  // Reading from System.in
          while(lost){
            System.out.println("Enter x-coordinate: ");
            int a = reader.nextInt(); // Scans the next token of the input as an int.
            //once finished
            //reader.close();
            System.out.println("Enter y-coordinate: ");
            int b = reader.nextInt(); // Scans the next token of the input as an int.
            System.out.println("Enter flag (-1) or uncover(1)? ");
            int c = reader.nextInt();
            if(c == -1){
              setCovered(-1);
            else if(c == 1){
              System.out.println(str);
            }
            lost = false;

          }
        }
        else if (args.length >= 4 && (Integer.parseInt(args[4]) < 0 || Integer.parseInt(args[4]) > 10000 )){
          System.out.println("The seed (fourth argument) must be between 0 and 10000 inclusive" + '\n' + instruction);
          System.exit(1);
        }
        else if (args.length == 4 || args.length > 4){
          defaultRow = Integer.parseInt(args[0]);
          defaultCol = Integer.parseInt(args[1]);
          defaultMines = Integer.parseInt(args[2]);
          seed = Integer.parseInt(args[3]);
          Board B = new Board(defaultRow, defaultCol, defaultMines, seed);
          System.out.println(B.toStringBoard());
        }
        else if (args.length == 5 || args.length > 5){
          defaultRow = Integer.parseInt(args[0]);
          defaultCol = Integer.parseInt(args[1]);
          defaultMines = Integer.parseInt(args[2]);
          seed = Integer.parseInt(args[3]);
          Board B = new Board(defaultRow, defaultCol, defaultMines, seed);
          if(args[5].equals("key")){
            System.out.println(B.toStringBoard());
          }
          else{
            System.out.println(B);

          }
        }
      }
      catch(Exception e){
        System.out.println(" ");//"You messed up somewhere hun. Check yo self" + '\n' + instruction);
      }




  //    Board tester = new Board();
  //    System.out.println(tester);
//      Board tester1 = new Board(15 + 2, 15 + 2, 15, 37253);
//      System.out.println(tester1.toStringBoard());
//      System.out.println(tester1);
  //    Board tester2 = new Board(15, 15, 10, 67223);
  //    System.out.println(tester2);
  //    Board tester3 = new Board(15, 15, 10, 223);
  //    System.out.println(tester3);
  //    Board tester4 = new Board(15, 15, 10, 3723);
  //    System.out.println(tester4);
  //    Board tester5 = new Board(15, 15, 10, 3723); //CRASHES WHYYY
  //    System.out.println(tester5);
  //    Board tester6 = new Board(6, 6, 10, 2);
  //    System.out.println(tester6);
      //
  }




}

/*  public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}
	}

  public static void getTheString(int r, int c,Terminal t, String s){
    t.moveCursor(r,c);
    for(int i = 0; i < s.length();i++){
      t.putCharacter(s.charAt(i));
    }
  }

  public static void main(String[] args) {
    int x = 0; //coordinates for where cursor starts
    int y = 0;

    Terminal terminal = TerminalFacade.createTextTerminal();
    terminal.enterPrivateMode();

    TerminalSize size = terminal.getTerminalSize();
    terminal.setCursorVisible(false);

    boolean running = true;


    Board tester1 = new Board(15, 15, 15, 37253);
    System.out.println(tester1);


  	long tStart = System.currentTimeMillis();
  	long lastSecond = 0;

  	while(running){

    	terminal.moveCursor(x,y);
    	terminal.applyBackgroundColor(Terminal.Color.WHITE); //cursor color
    	terminal.applyForegroundColor(Terminal.Color.BLACK);
    	terminal.putCharacter(' ');// character that shows up inside cursor
    	//terminal.putCharacter(' ');
    	terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
  		terminal.applyForegroundColor(Terminal.Color.DEFAULT);
  		terminal.applySGR(Terminal.SGR.RESET_ALL);



        terminal.moveCursor(size.getColumns()-100,10);
      	terminal.applyBackgroundColor(Terminal.Color.BLACK);
      //	terminal.applyForegroundColor(Terminal.Color.WHITE);
        terminal.applySGR(Terminal.SGR.ENTER_BOLD);
        for()
        terminal.putCharacter(' ');
        terminal.putCharacter(' ');
        terminal.putCharacter(' ');
        terminal.putCharacter(' ');
        terminal.putCharacter(' ');
      	terminal.applyBackgroundColor(Terminal.Color.DEFAULT);// highlight
  		  terminal.applyForegroundColor(Terminal.Color.DEFAULT);//words

        terminal.moveCursor(size.getColumns()-100,10);
        terminal.applyBackgroundColor(Terminal.Color.BLACK);
        //	terminal.applyForegroundColor(Terminal.Color.WHITE);
        terminal.applySGR(Terminal.SGR.ENTER_BOLD);
        terminal.putCharacter(' ');
        terminal.putCharacter(' ');
        terminal.putCharacter(' ');
        terminal.putCharacter(' ');
        terminal.putCharacter(' ');
        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);// highlight
        terminal.applyForegroundColor(Terminal.Color.DEFAULT);//words


//LANTERNA STUFFS
    	Key key = terminal.readInput();

    	if (key != null)
    	{
        //DEALING WITH COVERED SYMBOLS
        //this one is for flagging a cell (press Tab)
        if (key.getKind() == Key.Kind.Tab) {
          terminal.moveCursor(x,y);
    			terminal.putCharacter('ø');
          x++;
    		}
        //this one is for uncovering a cell (press Enter)
        if (key.getKind() == Key.Kind.Enter) {
          terminal.moveCursor(x,y);
          terminal.putCharacter('8');
    			x++;
    		}

    		if (key.getKind() == Key.Kind.Escape) {
    			terminal.exitPrivateMode();
    			running = false;
    		}

    		if (key.getKind() == Key.Kind.ArrowLeft) {
    			terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
    			x--;
    		}

    		if (key.getKind() == Key.Kind.ArrowRight) {
    			terminal.moveCursor(x,y);
    			terminal.putCharacter(' ');
    			x++;
    		}

    		if (key.getKind() == Key.Kind.ArrowUp) {
    			terminal.moveCursor(x,y);
    			terminal.putCharacter(' ');
    			y--;
  			}

    		if (key.getKind() == Key.Kind.ArrowDown) {
    			terminal.moveCursor(x,y);
    			terminal.putCharacter(' ');
    			y++;
    		}
    		//space moves it diagonally
    		if (key.getCharacter() == ' ') {
  				terminal.moveCursor(x,y);
    			terminal.putCharacter(' ');
    			y++;
    			x++;
    		}
    	//putString(1,4,terminal,"["+key.getCharacter() +"]");
    		putString(1,2,terminal,key+"        ");//to clear leftover letters pad withspaces
    	}

    	//DO EVEN WHEN NO KEY PRESSED:
    	long tEnd = System.currentTimeMillis();
    	long millis = tEnd - tStart;
    	//putString(1,2,terminal,"Milliseconds since start of program: "+millis); //gives time in milliseconds (too fast)
    	if(millis/1000 > lastSecond){
    		lastSecond = millis / 1000;
    		//one second has passed.
    		putString(1,3,terminal,"TIMER: "+lastSecond + " seconds");
        putString(1,4,terminal,"Cursor Coordinates: (" + x + ", " + y + ")");
    	}
  	}
	}
}
*/
