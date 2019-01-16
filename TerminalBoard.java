//******* COMPILE AND RUN VIA LINES BELOW YO
//javac -cp lanterna.jar:. TerminalBoard.java
//java -cp lanterna.jar:. TerminalBoard

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


public class TerminalBoard{
  public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}
	}

	public static void main(String[] args){

  	int x = 10;
  	int y = 10;

    Terminal terminal = TerminalFacade.createTextTerminal();
    terminal.enterPrivateMode();

  	TerminalSize size = terminal.getTerminalSize();
  	terminal.setCursorVisible(false);

    boolean running = true;

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;


    Key key = terminal.readInput();

    if (key != null)
    {

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
      putString(1,4,terminal,"["+key.getCharacter() +"]");
      putString(1,1,terminal,key+"        ");//to clear leftover letters pad withspaces
    }


  }

}
