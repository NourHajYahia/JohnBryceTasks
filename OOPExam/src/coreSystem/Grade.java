package coreSystem;

public class Grade {
	
	private String profession;
	private int score;

	public Grade(String profession) {
		super();
		this.profession = profession;
		this.score = (int)(Math.random()*61) + 40;
	}

	public String getProfession() {
		return profession;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Grade [profession=" + profession + ", score=" + score + "]";
	}
	
	

}
