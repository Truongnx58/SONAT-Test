package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.User;
public class ConnectDB {
 
Connection connect = null;
 Statement stmt = null;
 ResultSet rs = null;
 
 public static Connection openConnect() throws SQLException,ClassNotFoundException {
	 String hostName="localhost";
	 String dbName="test";
	 String userName="root";
	 String password="";
	 Class.forName("com.mysql.jdbc.Driver");
	 String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName+ "?useUnicode=yes&characterEncoding=UTF-8";
	    Connection conn = DriverManager.getConnection(connectionURL, userName,
	            password);
	    return conn;
	}
 
 protected Statement getStatement() throws SQLException, Exception{
	 if(stmt == null){
		 stmt = openConnect().createStatement();
		 stmt.executeQuery("SET NAMES 'UTF8'");
		 stmt.executeQuery("SET CHARACTER SET 'UTF8'");
	 }
	 return stmt;
 }
 public ArrayList<User> getUser() throws Exception{
	 ArrayList<User> list = new ArrayList<User>();
	 String strSQL = "select * from user order by id ASC";
	 try {
		 rs = getStatement().executeQuery(strSQL);
		 while(rs.next()){
			 String id = rs.getString("id");
			 String name = rs.getString("name");
			 String gender = rs.getString("gender");
			 String age = rs.getString("age");
			 User user = new User(id, name, gender, age);
			 list.add(user);
		 }
	 } catch (Exception e) {
	 throw new Exception(e.getMessage() +" Error at : " + strSQL);
	 }
	 return list;
 }
 public User FindUser(String id) throws Exception{
	 String strSQL = "select * from user";
	 User user=null;
	 try {
		 rs = getStatement().executeQuery(strSQL);
		 while(rs.next()){
			 String Uid = rs.getString("id");
			 String name = rs.getString("name");
			 String gender = rs.getString("gender");
			 String age = rs.getString("age");
			 if(Uid.compareTo(id)==0){
				 user = new User(id, name, gender, age);
				 break;
			 }
		 }
	 } catch (Exception e) {
	 throw new Exception(e.getMessage() +" Error at : " + strSQL);
	 }
	 return user;
 }
 public boolean insert(User user) throws Exception{
	 String sql = "insert into user values(null,?,?,?)";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, user.getName());
	 pst.setString(2, user.getGen());
	 pst.setString(3, user.getAge());
	 return pst.executeUpdate() > 0;
 }
 
 public boolean deleteUser(String id) throws Exception{
	 String sql = "delete from User where id=?";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, id);
	 return pst.executeUpdate() > 0;
 }
 
 public boolean UpdateUser(String id, User user) throws Exception{
	 String sql = "update user set name=?, gender=?, age=? where id="+id;
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, user.getName());
	 pst.setString(2, user.getGen());
	 pst.setString(3, user.getAge());
	 return pst.executeUpdate()>0;
 }
 
 public static void main(String[] args) throws Exception {
 }
 
}