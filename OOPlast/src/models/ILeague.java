package models;
import java.io.IOException;

public interface ILeague {

	public FootballTeam matchTeams(FootballTeam team1,FootballTeam team2);
	public void increasePoint(FootballTeam team);
	public void createAllTeams() throws IOException ;
	public void createFixture();
	public boolean isBudgetEnough(FootballTeam team) ;
	public boolean isSizeofTeamConvenient(FootballTeam team) ;
	public boolean makeTransfer(Player playerToTransfer,FootballTeam newTeam);
	
}
