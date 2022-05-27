package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShootingGame {
	private Map<String, Character> characters = new HashMap<>();
	private List<Player> players = new ArrayList<>();
	
	public ShootingGame(Player player1, Player player2, Player player3, GameLevel level) {
		this.players.add(player1);
		this.players.add(player2);
		this.players.add(player3);
		this.characters = GameSetup.loadGame(level);
	}
	
	//get the position of all the character
	public void getPositionOfCharacter () {
		for (Map.Entry<String, Character> ch : this.characters.entrySet()) {
			String pos[] = ch.getKey().split("\t");
			System.out.println("x_coor: " + pos[0] + "  y_coor: " + pos[1]);
		}
	}
	
	//the player will not know the character's skill. Have to specify the correct character's position
	public void shooting(Player player, int x_coordinate, int y_coordinate) {
		String position = x_coordinate + "\t" + y_coordinate;
		if (characters.containsKey(position)) {
			Character c = characters.get(position);
			int blood = c.getCharacterBloodLevel() - 20;
			c.setCharacterBloodLevel(blood);
			
			if (c.getCharacterSkill() == CharacterSkill.AfterLife && c.getSkillUseTime() == 0) {
				if (blood == 0) {
					System.out.println("The character has survived");
					c.setCharacterBloodLevel(100);
					c.setCharacterSkillUse(1);
					characters.put(position, c);
				}	
			} else if (c.getCharacterSkill() == CharacterSkill.SuperBody && c.getSkillUseTime() < 3) {
				System.out.println("This character activated SuperBody skill");
				c.setCharacterBloodLevel(blood+20);
				c.setCharacterSkillUse(c.getSkillUseTime()+1);
				characters.put(position, c);
					
			} else if (c.getCharacterSkill() == CharacterSkill.Amaterasu && c.getSkillUseTime() == 0) {
				if (c.getCharacterBloodLevel() == 40) {
					System.out.println("The character activated Amaterasu skill. " + player.getUserName()+" lost 20% blood");
					c.setCharacterSkillUse(c.getSkillUseTime()+1);
					player.setBlood(player.getBlood()-20);
					if (player.getBlood() <= 0) {
						System.out.println(player.getUserName()+" has been killed");
						player.setNumDeath(player.getNumDeath()+1);
						players.remove(player);
						if (players.size() == 0) {
							System.out.println("Game Over");
						}
					}
				}
			} else if (c.getCharacterSkill() == CharacterSkill.Amenotejikara) {
				System.out.println("You killed the character that has Amenotejikara skill");
				characters.remove(c.coordinateToString());
	
			} else if (c.getCharacterSkill() == CharacterSkill.Assimilation && c.getSkillUseTime() < 3) {
				if (blood == 80 || blood == 40) {
					System.out.println("The character activated Assimilation skill. " + player.getUserName()+" lost 30% blood");
					c.setCharacterSkillUse(c.getSkillUseTime()+1);
					player.setBlood(player.getBlood()-30);
					if (player.getBlood() <= 0) {
						player.setNumDeath(player.getNumDeath()+1);
						System.out.println(player.getUserName()+" has been killed");
						players.remove(player);
						if (players.size() == 0) {
							System.out.println("Game Over");
						}
					}
				}
					
			}else{
				if (blood <= 0) {
					characters.remove(c.coordinateToString());
					System.out.println("Character at x: " + c.getCharacterX_coor()+ "  y: "+c.getCharacterY_coor()+ " has been killed");
					if (characters.size() == 0 && players.size() > 0) {
						System.out.println("Your team win the game");
					}
					player.setNumKill(player.getNumKill()+1);
					player.setBlood(player.getBlood()+10); //award when kill 1 character
				}	
			}
		}else {
			System.out.println(player.getUserName()+" missed the character");
		}
				
	}
	
	//Save the teammate from dying
	public void bloodTransfuser (Player donator, Player receiver, int blood) {
		donator.setBlood(donator.getBlood()-blood);
		receiver.setBlood(receiver.getBlood()+blood);
		donator.setNumAssist(donator.getNumAssist()+1);
	}
	
	//Get personal KDA 
	public int getKDA (Player player) {
		if (player.getNumDeath() != 0)
			return (player.getNumKill()+player.getNumAssist())/player.getNumDeath();
		else 
			return 0;
	}
	
	public int getK (Player player) {
		return player.getNumKill();
	}
	public int getD (Player player) {
		return player.getNumDeath();
	}
	
	public int getA (Player player) {
		return player.getNumAssist();
	}
}
