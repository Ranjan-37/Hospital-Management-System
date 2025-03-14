package HMS;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
public class Hospital1
{
		public static void main(String[] args) throws SQLException 
		{
			Scanner sc = new Scanner(System.in);
			try (Connection conn = DatabaseService.getConnection()) 
			{
				Patient patient = new Patient(conn);
				Doctor doctor = new Doctor(conn);
				BookAppointment appointment = new BookAppointment(conn, patient, doctor);
				while (true) 
				{
					System.out.println("=== Hospital Management System ===");
					System.out.println("1. Add Patient");
					System.out.println("2. Add Doctor");
					System.out.println("3. View Patients");
					System.out.println("4. View Doctors");
					System.out.println("5. Book Appointment");
					System.out.println("6. Exit");
					System.out.print("Enter your choice: ");

					int ch = sc.nextInt();

					switch (ch) {
					case 1:
						patient.addPatient();
						System.out.println();
						break;
					case 2:
						doctor.addDoctor();
						System.out.println();
						break;
					case 3:
						patient.viewPatients();
						System.out.println();
						break;
					case 4:
						doctor.viewDoctors();
						System.out.println();
						break;
					case 5:
						appointment.bookAppointment();
						System.out.println();
						break;
					case 6:
						System.out.println("Thank you for using Hospital Management System...");
						sc.close();
						return;
					default:
						System.out.println("Please enter valid choice.");
						break;
					}
				}
			} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
			
	}
}

	

