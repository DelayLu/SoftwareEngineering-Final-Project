import java.sql.*;

public class AdminLoginDataManager {
	private Connection con;

	public AdminLoginDataManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		String url = "jdbc:mysql://isel.cs.unb.ca:3306/cs2043team17aDB";
		try {
			con = DriverManager.getConnection(url, "cs2043team17a",
					"cs2043team17a");
		} catch (SQLException e) {
			System.err.println("Database connection error.");
		}
	}

	public AdminObj getAdminRecord() {
		AdminObj admin = new AdminObj();

		try {
			Statement st = con.createStatement();

			String sqlQuery = "select * from AdminLoginTable;";
			ResultSet rs = st.executeQuery(sqlQuery);
			while (rs.next()) {
				admin.putData(rs.getString(1), rs.getString(2));
			}

		} catch (SQLException e) {
			System.err.println("SQL error: getAdminRecord");
		}

		return admin;
	}

}
