package com.in20minutes.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.in20minutes.todo.Todo;

public class MySqlConnection {
	
	public Connection MySqlRealizeConnection(String ip,String db) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexao = DriverManager.getConnection("jdbc:mysql://"+"/"+db+"?useTimezone=true&serverTimezone=UTC","root","root");
		System.out.println("Conectado");
		return conexao;
		
	}
	public ArrayList<Todo> select(String fields,String where,String table) throws SQLException, ClassNotFoundException {
		Connection conexao = MySqlRealizeConnection("localhost","todos");
		String sqlUrl = "SELECT "+fields +" FROM "+ table+";";
		ArrayList<Todo> result = new ArrayList<Todo>();
		System.out.println(sqlUrl);
		Statement stmt = conexao.createStatement();
		ResultSet rs = stmt.executeQuery(sqlUrl);
		while(rs.next()) {
			Todo newTodo = new Todo(rs.getString("name"),rs.getString("category"));			
			result.add(newTodo);
		}
		conexao.close();
		
		return result;
	}
	public String insert(String todo,String category,String table) throws SQLException, ClassNotFoundException {
		Connection conexao = MySqlRealizeConnection("localhost","todos");
		String sqlUrl = "INSERT INTO "+table +" VALUES "+ "("+"'"+todo+"'"+","+"'"+category+"'"+")";
		System.out.println(sqlUrl);
		Statement stmt = conexao.createStatement();
		int rs = stmt.executeUpdate(sqlUrl);
		conexao.close();
		return "0";
	}
	
	public String update(String field,String value,String table,String where) throws SQLException, ClassNotFoundException {
		Connection conexao = MySqlRealizeConnection("localhost","todos");
		String sqlUrl = "UPDATE "+table +" SET " +field+"="+value+" WHERE "+where+";";
		System.out.println(sqlUrl);
		Statement stmt = conexao.createStatement();
		int rs = stmt.executeUpdate(sqlUrl);
		System.out.println(rs);
		conexao.close();
		return "0";
	}
	public String delete(String table,String where) throws SQLException, ClassNotFoundException {
		Connection conexao = MySqlRealizeConnection("localhost","todos");
		MySqlRealizeConnection("localhost","todos");
		String sqlUrl = "DELETE FROM "+table +" WHERE "+where+";";
		System.out.println(sqlUrl);
		Statement stmt = conexao.createStatement();
		int rs = stmt.executeUpdate(sqlUrl);
		System.out.println(rs);
		conexao.close();
		return "0";
	}
}

