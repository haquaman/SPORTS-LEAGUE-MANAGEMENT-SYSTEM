package models;
import java.util.ArrayList;

public class Match {

	private FootballTeam hostTeam;
	private FootballTeam awayTeam;
	private ArrayList<Goal> goals = new ArrayList<Goal>();
	private boolean result;
	private boolean isPlayed;

	private int hostTeamScore;
	private int awayTeamScore;
	private Date date;

	public Date getDate() {
		return date;
	}

	public boolean isPlayed() {
		return isPlayed;
	}

	public void setPlayed(boolean isPlayed) {
		this.isPlayed = isPlayed;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Match(FootballTeam hostTeam, FootballTeam awayTeam, Date date) {
		super();
		this.isPlayed=false;
		this.hostTeam = hostTeam;
		this.awayTeam = awayTeam;
		this.date = date;
	}

	public ArrayList<Goal> getGoals() {
		return goals;
	}

	public void addGoals(Goal goal) {
		this.goals.add(goal);
	}

	public int getHostTeamScore() {
		return hostTeamScore;
	}

	public void setHostTeamScore(int hostTeamScore) {
		this.hostTeamScore = hostTeamScore;
	}

	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public FootballTeam getHostTeam() {
		return hostTeam;
	}

	public void setHostTeam(FootballTeam hostTeam) {
		this.hostTeam = hostTeam;
	}

	public FootballTeam getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(FootballTeam awayTeam) {
		this.awayTeam = awayTeam;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
