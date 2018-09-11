import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Connect {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver"); //sets up connection with specific database
		
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClassPractice?trueSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		Statement statement = connect.createStatement();
		
		String sql = "DELETE FROM CustomersTemp " +
                "WHERE OID = 911";
		statement.executeUpdate(sql);
		
		/*
		String sql = "INSERT INTO CustomerTemp " + "(CID, Name, Phone, Email, Password )" + " values (011, 'Jay', 3533, 'jaygallo', 'football')";
		statement.executeUpdate(sql);
		
		*/
		
		/*
		String newtable = "CREATE TABLE employee " +
      
 				" (phone INTEGER not NULL, " + 
                "  name VARCHAR(255), " + 
                " city VARCHAR(255), " + 
                " PRIMARY KEY ( phone ))";
		
		statement.executeUpdate(newtable);
		*/
		
		
		
		
		/*
		String sql = "INSERT INTO CustomerTemp " + "(CID, Name, Phone, Email, Password )" + " values (?, ?, ?, ?, ?)";
		final int batchSize = 10;
		int count = 0;
		PreparedStatement ps = connect.prepareStatement(sql);
		
		for (CustomerTemp employee: CustomerTemp) {
		
			ps.setString(1, employee.getCID());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getPhone());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPassword());
			ps.addBatch();
			
			if(++count % batchSize == 0) {
				ps.executeBatch();
			}
			}
			
		String sql = "INSERT INTO CustomerTemp " + "(CID, Name, Phone, Email, Password )" + " values (?, ?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, "4352");
		ps.setString(2, "Gracie");
		ps.setString(3, "045833");
		ps.setString(4, "gracie@uconn");
		ps.setString(5, "passwords");
		ps.addBatch();
		
		int[] updateCounts = ps.executeBatch();
		checkUpdateCounts(updateCounts);
		
		*/
	}
	  public static void checkUpdateCounts(int[] updateCounts) {
		    for (int i=0; i<updateCounts.length; i++) {
		        if (updateCounts[i] >= 0) {
		            System.out.println("OK; updateCount="+updateCounts[i]);
		        }
		        else if (updateCounts[i] == Statement.SUCCESS_NO_INFO) {
		            System.out.println("OK; updateCount=Statement.SUCCESS_NO_INFO");
		        }
		        else if (updateCounts[i] == Statement.EXECUTE_FAILED) {
		            System.out.println("Failure; updateCount=Statement.EXECUTE_FAILED");
		        }
		    }
	}
}
