package game;

public class Player {
	private String userName;
	private String ID;
	private int blood;
	private int numKill;
	private int numAssist;
	private int numDeath;
	
	public Player (String name, String ID) {
		this.userName = name;
		this.ID = ID;
		this.blood = 100;
		this.numAssist = 0;
		this.numDeath = 0;
		this.numKill = 0;
	}

	public String getUserName() {
		return userName;
	}

	public String getID() {
		return ID;
	}
	
	public int getBlood() {
		return blood;
	}
	
	public void setBlood(int blood) {
		this.blood = blood;
	}

	public int getNumKill() {
		return numKill;
	}
	
	public void setNumKill(int kill) {
		this.numKill = kill;
	}

	public int getNumAssist() {
		return numAssist;
	}
	
	public void setNumAssist(int assist) {
		this.numAssist = assist;
	}

	public int getNumDeath() {
		return numDeath;
	}
	
	public void setNumDeath(int death) {
		this.numDeath = death;
	}
}
