import java.sql.*;
import java.util.ArrayList;

public class ParkingDAO {

    public ArrayList<String> getAvailableSlots() {
        ArrayList<String> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT slot_number FROM parking_slots WHERE is_booked = FALSE");

            while (rs.next()) {
                list.add(rs.getString("slot_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean bookSlot(String slotNumber, String user) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE parking_slots SET is_booked = TRUE, booked_by = ? WHERE slot_number = ? AND is_booked = FALSE"
            );
            ps.setString(1, user);
            ps.setString(2, slotNumber);

            int res = ps.executeUpdate();
            return res > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
