package main;

import game.*;

public class Main {
	public static void main (String[] args) {
		Player p1 = new Player("Jake", "12a190#");
		Player p2 = new Player("Lake", "12a180#");
		Player p3 = new Player("Jade", "13b289#");
		
		ShootingGame game = new ShootingGame(p1, p2, p3, GameLevel.HARD);
		ShootingGame game1 = new ShootingGame(p1, p2, p3, GameLevel.EASY);
		game.getPositionOfCharacter();
		game.shooting(p3, 11, 48);
		game.shooting(p3, 10, 66);
		System.out.println(p3.getBlood());
		
		game.shooting(p2, 43, 89);
		game.shooting(p2, 43, 89);
		game.shooting(p2, 43, 89);
		game.shooting(p2, 43, 89);
		game.shooting(p2, 43, 89);

		game.shooting(p2, 20, 15);
		game.shooting(p2, 20, 15);
		game.shooting(p2, 20, 15);
		game.shooting(p2, 20, 15);
		System.out.println(p2.getBlood());

		game.shooting(p1, 11, 48);
		game.shooting(p1, 11, 48);
		game.shooting(p1, 22, 13);
		game.shooting(p1, 22, 13);
		
		game.bloodTransfuser(p2, p1, 10);
		System.out.println(p2.getBlood());
		System.out.println(p1.getBlood());
		
		System.out.println(game.getKDA(p2));
		System.out.println(game.getA(p3));
		System.out.println(game.getD(p2));
		System.out.println(game.getK(p2));
		
		game1.bloodTransfuser(p2, p3, 10);
		System.out.println(game1.getA(p2));
		
		
	}
	
}
