package HMS;
import java.sql.Connection;//Interface
import java.sql.PreparedStatement;//Interface
import java.sql.ResultSet;//Interface
import java.sql.SQLException;
import java.util.Scanner;
public class Doctor {
	private Connection conn;
	Scanner sc = new Scanner(System.in);

	public Doctor(Connection conn) {
		this.conn = conn;
	}

	public void addDoctor() throws SQLException {
		System.out.print("Enter Doctor Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Specialization: ");
		String specialization = sc.nextLine();

		String query = "insert into doctors(name, specialization) values (?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, name);
			ps.setString(2, specialization);

			if (ps.executeUpdate() > 0) {
				System.out.println("\n\nDoctor details added successfully.");
			} else {
				System.out.println("\n\nFailed to add Doctor details.");
			}
		}
	}

	public void viewDoctors() throws SQLException {
		String query = "select * from doctors";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			try (ResultSet rs = ps.executeQuery()) {
				 System.out.println("Doctors: ");
		            System.out.println("+------------+--------------------------+------------------+");
		            System.out.println("| Doctor Id  | Name                     | Specialization   |");
		            System.out.println("+------------+--------------------------+------------------+");
		            while(rs.next())
		            {
		                int id = rs.getInt("id");
		                String name = rs.getString("name");
		                String specialization = rs.getString("specialization");
		                System.out.printf("| %-10s | %-24s | %-16s |\n", id, name, specialization);
		                System.out.println("+------------+--------------------------+------------------+");
		            }
		            }
			}
		}
	
	public boolean getDoctorById(int id) throws SQLException {
		String query = "select count(1) from doctors where id = ?";
		
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, id);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1) > 0;
				}
			}
		}
		return false;
	}
}
