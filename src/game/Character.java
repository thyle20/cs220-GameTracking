package game;

import java.util.Random;

public class Character {
	private int blood;
	private CharacterSkill specialSkill;
	private int skillUseTime = 0;
	private int x_coordinate;
	private int y_coordinate;
	public Random rd = new Random();
	
	public Character (CharacterSkill specialSkill, int x_pos, int y_pos) {
		this.specialSkill = specialSkill;
		this.blood = 100;
		this.x_coordinate = x_pos;
		this.y_coordinate = y_pos;
	}
	
	public String coordinateToString() {
		String value = this.x_coordinate+ "\t" + this.y_coordinate;
		return value;
	}
	
	public int getCharacterBloodLevel () {
		return this.blood;
	}
	
	public CharacterSkill getCharacterSkill () {
		return this.specialSkill;
	}

	public void setCharacterBloodLevel(int blood) {
		this.blood = blood;
	}
	
	public int getSkillUseTime() {
		return this.skillUseTime;
	}
	public void setCharacterSkillUse(int time) {
		this.skillUseTime = time;
	}
	
	public int getCharacterX_coor() {
		return this.x_coordinate;
	}
	
	public void setCharacterX_coor() {
		int coor = rd.nextInt(100);
		this.x_coordinate = coor;
	}
	
	public int getCharacterY_coor() {
		return this.y_coordinate;
	}
	
	public void setCharacterY_coor() {
		int coor = rd.nextInt(100);
		this.y_coordinate = coor;
	}
	
	
}
