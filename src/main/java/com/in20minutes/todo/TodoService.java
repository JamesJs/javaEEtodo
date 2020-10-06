package com.in20minutes.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();

	static {
		todos.add(new Todo("Learn Web Application","Study"));
		todos.add(new Todo("Learn Spring","Study"));
		todos.add(new Todo("Learn Spring MVC","Study"));
	}

	public List<Todo> retrieveTodos() {
		return todos;
	}

	public void addTodo(String todo,String category) {
		todos.add(new Todo(todo,category));
	}

	public void deleteTodo(String todo,String category) {
		todos.remove(new Todo(todo,category));
	}
}