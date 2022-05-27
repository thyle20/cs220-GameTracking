package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class GameSetup {
	public static Map<String, Character> loadGame(GameLevel level){
		Map<String, Character> listCharacter = new HashMap<>();
		Random rd = new Random();
		if (level == GameLevel.EASY) {
			Character c1 = new Character(CharacterSkill.AfterLife, 20, 55);
			Character c2 = new Character(CharacterSkill.Amaterasu, 10, 66);
			Character c3 = new Character (CharacterSkill.SuperBody, 15, 99);
			listCharacter.put(c1.coordinateToString(), c1);
			listCharacter.put(c2.coordinateToString(), c2);
			listCharacter.put(c3.coordinateToString(), c3);
		} else {
			Character c1 = new Character(CharacterSkill.AfterLife, 20, 15);
			Character c2 = new Character(CharacterSkill.Amaterasu, 43, 89);
			Character c3 = new Character (CharacterSkill.Assimilation, 11, 48);
			Character c4 = new Character(CharacterSkill.Amenotejikara, rd.nextInt(10), rd.nextInt(10));
			Character c5 = new Character(CharacterSkill.SuperBody, 22, 13);
			listCharacter.put(c1.coordinateToString(), c1);
			listCharacter.put(c2.coordinateToString(), c2);
			listCharacter.put(c3.coordinateToString(), c3);
			listCharacter.put(c4.coordinateToString(), c4);
			listCharacter.put(c5.coordinateToString(), c5);
		}
		return listCharacter;
	}
}
