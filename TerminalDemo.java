//******* COMPILE AND RUN VIA LINES BELOW YO
//javac -cp lanterna.jar:. Driver.java
//java -cp lanterna.jar:. Driver
//Mr. K's TerminalDemo edited for lanterna 3 by Ethan. Thanks Ethan!


import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
import java.awt.Color;


public class TerminalDemo {

	public static void putString(int x, int y, Screen screen, String str) {
		for (int i = 0; i < str.length(); i++) {
			screen.setCharacter(x+i, y, new TextCharacter(str.charAt(i)));
		}
	}

	public static void main(String[] args) throws IOException {

		int x = 10;
		int y = 10;

		Screen screen = new DefaultTerminalFactory().createScreen();
		screen.startScreen();

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;

		while (true) {

			TextCharacter chr = new TextCharacter(
				'\u263B',
				new TextColor.RGB((int)(255*Math.random()), (int)(255*Math.random()), (int)(255*Math.random())),
				TextColor.ANSI.DEFAULT
			);
			screen.setCharacter(x, y, chr);

			KeyStroke key = screen.pollInput();

			if (key != null) {
				screen.setCharacter(x, y, new TextCharacter(' '));

				if      (key.getKeyType() == KeyType.Escape)     break;
				else if (key.getKeyType() == KeyType.ArrowLeft)  x--;
				else if (key.getKeyType() == KeyType.ArrowRight) x++;
				else if (key.getKeyType() == KeyType.ArrowUp)    y--;
				else if (key.getKeyType() == KeyType.ArrowDown)  y++;

				putString(1, 1, screen, key+"                 ");
			}
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
			putString(1, 2, screen, "Milliseconds since start of program: "+millis);
			if (millis / 1000 > lastSecond) {
				lastSecond = millis / 1000;
				putString(1, 3, screen, "Seconds since start of program: "+millis/1000);
			}
			screen.doResizeIfNecessary();
			screen.refresh();
		}
		screen.stopScreen();
	}
}
