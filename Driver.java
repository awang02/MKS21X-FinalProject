//******* COMPILE AND RUN VIA LINES BELOW YO
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

import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Driver{

  public static void putString(int r, int c,Terminal t, String s){
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
