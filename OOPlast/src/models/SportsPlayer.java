package models;

public abstract class SportsPlayer {
	
	private int moral;
	private int strength;
	private String name;
	private int age;
	private SportsTeam team;
	
	
	
	public int getMoral() {
		return moral;
	}
	public void setMoral(int moral) {
		this.moral = moral;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public SportsTeam getTeam() {
		return team;
	}
	public void setTeam(SportsTeam team) {
		this.team = team;
	}

}
