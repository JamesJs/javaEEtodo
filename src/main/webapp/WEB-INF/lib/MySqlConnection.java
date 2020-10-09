import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.in20minutes.todo.Todo;

public class MySqlConnection {
	Connection conexao;
	MySqlConnection(String ip,String db) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexao = DriverManager.getConnection("jdbc:mysql://"+"/"+db+"?useTimezone=true&serverTimezone=UTC","root","root");
		System.out.println("Conectado");
		
	}
	public ArrayList<Todo> select(String fields,String where,String table) throws SQLException {
		String sqlUrl = "SELECT "+fields +" FROM "+ table+";";
		ArrayList<Todo> result = new ArrayList<Todo>();
		System.out.println(sqlUrl);
		Statement stmt = conexao.createStatement();
		ResultSet rs = stmt.executeQuery(sqlUrl);
		while(rs.next()) {
			Todo newTodo = new Todo(rs.getString("name"),rs.getString("category"));			
			result.add(newTodo);
		}
		return result;
	}
	public String insert(String todo,String category,String where,String table) throws SQLException {
		String sqlUrl = "INSERT INTO "+table +" VALUES "+ "("+todo+","+category+")"+";";
		System.out.println(sqlUrl);
		Statement stmt = conexao.createStatement();
		ResultSet rs = stmt.executeQuery(sqlUrl);
		while(rs.next()) {
			System.out.println(rs.getString("nome"));
		}
		return "0";
	}
	
	public String update(String field,String value,String table,String where) throws SQLException {
		String sqlUrl = "UPDATE "+table +" SET " +field+"="+value+" WHERE "+where+";";
		System.out.println(sqlUrl);
		Statement stmt = conexao.createStatement();
		int rs = stmt.executeUpdate(sqlUrl);
		System.out.println(rs);
		return "0";
	}
	public String delete(String table,String where) throws SQLException {
		String sqlUrl = "DELETE FROM "+table +" WHERE "+where+";";
		System.out.println(sqlUrl);
		Statement stmt = conexao.createStatement();
		int rs = stmt.executeUpdate(sqlUrl);
		System.out.println(rs);
		return "0";
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MySqlConnection teste = new MySqlConnection("localhost", "todos");
		teste.select("*", "sla", "todo");
		teste.delete("todo", "name='teste'");
	}
}

