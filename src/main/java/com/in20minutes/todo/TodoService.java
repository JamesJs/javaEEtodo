package com.in20minutes.todo;
import com.in20minutes.db.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	static MySqlConnection connection;
	static {
		
			connection = new MySqlConnection();
		
	}

	public List<Todo> retrieveTodos() throws ClassNotFoundException, SQLException {
		
		todos = connection.select("*", "", "todo");
		return todos;
	}

	public void addTodo(String todo,String category) throws ClassNotFoundException, SQLException {
		connection.insert(todo, category, "todo");
	}

	public void deleteTodo(String todo,String category) throws SQLException, ClassNotFoundException {
		connection.delete("todo", "name="+"'"+todo+"'");
		
	}
}