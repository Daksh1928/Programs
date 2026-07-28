
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Model {

    private String username;
    private String email;
    private String phone;
    private String password;
    private Connection connect;
    private PreparedStatement pstmnt = null;
	private int row = 0;
    int id=0;
    {
        id++;
    }
    public static void main(String[] args) {

    }

    public Model() {
        this.connect = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int register() {
        try {
            connect = JdbcUtil.getDBConnection();
            String sql = "INSERT into users (id,username,email,phone,password ) values (?,?,?,?,?)";
            pstmnt = connect.prepareStatement(sql);
			pstmnt.setInt(1, id);
            pstmnt.setString(2, username);
            pstmnt.setString(3, email);
            pstmnt.setString(4, phone);
            pstmnt.setString(5, password);
            row = pstmnt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally
		{
			try {
				JdbcUtil.closeResource(connect, pstmnt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return row;
    }
}
