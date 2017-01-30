package damierCore;

import static org.assertj.core.api.Assertions.assertThat;
//import static java.Couleurs.BLACK;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DamierGameTest {
	
	 private DamierGame game;
	 
	 @Before
	    public void doBefore() throws Exception {
	        game = new DamierGameImpl();
	    }
	 
	 @Test
	   public void itInitializedBoard() throws Exception{
		 //doit afficher le damier initial avec les 40 pions placés
		 //System.out.println("initialized game \n"+game.toString());
		 Couleurs cell = game.getCell(0, 0);
		 assertNull(cell);
		 cell = game.getCell(1, 0);
		 assertEquals(Couleurs.BLACK, cell);
		 cell = game.getCell(2, 0);
		 assertNull(cell);
		 cell = game.getCell(2, 1);
		 assertEquals(Couleurs.BLACK, cell);
		for(int i=0 ; i<10 ; i++){
			assertNull(game.getCell(4, i));
		 }
		for(int i=0 ; i<10 ; i++){
			assertNull(game.getCell(5, i));
		 }
		cell = game.getCell(6, 1);
		 assertEquals(Couleurs.WHITE, cell);
		}
	 
	 @Test
	    public void aPlayerMayPlayAColumn() throws Exception {
		 game.play(3, 2, 4, 1);
	     assertThat(game.getCell(4, 1)).isEqualTo(Couleurs.BLACK);
	      assertNull(game.getCell(2, 3));
	      System.out.println("after 1st move \n"+game.toString());
	 }
	 
}
