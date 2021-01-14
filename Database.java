
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
	private Connection connection;
	Statement stmt = null;

	public void connect() throws Exception {

		if (connection != null)
			return;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found");
		}

		String connectionUrl = "jdbc:mysql://localhost:3306/crime";
		connection = DriverManager.getConnection(connectionUrl, "root", "");

		System.out.println("Connected: " + connection);

	}

	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Can't close the connection");
			}
		}
	}

	public String login(String str1, String str2) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("select * from test where name=? and password=?");
		ps.setString(1, str1);
		ps.setString(2, str2);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return "Connected";
		} else {
			return "Wrong password Or User Name";
		}
	}
	public String loginUser(String str1, String str2) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("select * from user where name=? and password=?");
		ps.setString(1, str1);
		ps.setString(2, str2);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return "Connected";
		} else {
			return "Wrong password Or User Name";
		}
	}
}
