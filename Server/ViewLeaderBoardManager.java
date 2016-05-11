import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ViewLeaderBoardManager {
	private Connection con;
	
	public ViewLeaderBoardManager() {
	     try {
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	     } catch (Exception e) {
	      System.err.println(e.toString());
	     }
		String url = "jdbc:mysql://isel.cs.unb.ca:3306/cs2043team17aDB";
		try {
		con = DriverManager.getConnection(url, "cs2043team17a", "cs2043team17a");
		} catch (SQLException e) {
		System.err.println("Database connection error.");
		}
	}
	
	public ArrayList<LeaderBoardObj> getLeaderBoard(){
		ArrayList<LeaderBoardObj> leaderboardlist = new ArrayList<LeaderBoardObj>();
		
		try {
			Statement st = con.createStatement();
			String sqlQuery = "select * from LeaderBoardTable order by Rank;";
			ResultSet rs = st.executeQuery(sqlQuery);
			while (rs.next()) {
				LeaderBoardObj leaderboard = new LeaderBoardObj();
				leaderboard.Id = rs.getInt(1);
				leaderboard.Rank = rs.getInt(2);
				leaderboard.Name = rs.getString(3);
				leaderboard.Score = rs.getInt(4);
				leaderboardlist.add(leaderboard);
			}
			
		} catch (SQLException e) {
			System.err.println("SQL error: getAllQuizzes");
		}
		return leaderboardlist;
	}
	
	//not sure
	public void addUserToLeaderBoard(String name, int score){
		ArrayList<LeaderBoardObj> leaderboardlist = this.getLeaderBoard();
		int rank;
		String sqlQuery;
		
		try {
			Statement st = con.createStatement();
			
			for(int i = 0; i < leaderboardlist.size(); i++){
				if(score >= leaderboardlist.get(i).Score){
					rank = leaderboardlist.get(i).Rank;
					sqlQuery = "insert into LeaderBoardTable(Rank, Name, Score) values(" + rank + ", '" + name + ", " + score +");";
					ResultSet rs0 = st.executeQuery(sqlQuery);
					for(int j = i; j < leaderboardlist.size(); j++){
						leaderboardlist.get(j).Rank++;
						sqlQuery = "update LeaderBoardTable set Rank = "+leaderboardlist.get(j)+"where Name = "
						+leaderboardlist.get(j).Name;
						ResultSet rs = st.executeQuery(sqlQuery);
					}
				}
			}	
		} catch (SQLException e) {
			System.err.println("SQL error: addUserToLeaderBoard");
		}
	}
	
	
	
}
