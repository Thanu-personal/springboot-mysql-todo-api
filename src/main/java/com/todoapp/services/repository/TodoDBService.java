package com.todoapp.services.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.models.Todo;
import com.todoapp.repository.TodoJPARepository;
import com.todoapp.services.ITodoService;
@Service
public class TodoDBService implements ITodoService{
	// h2
	
	@Autowired
	private TodoJPARepository todoDbRepo;
	
	@Override
	public List<Todo> getAllTodos() {
		// TODO Auto-generated method stub
		var todos = todoDbRepo.findAll();
		return todos;
	}

	@Override
	public Todo getById(int id) {
		// TODO Auto-generated method stub
		Optional<Todo> todos = todoDbRepo.findById(id);
		if(todos.isPresent()) {
			return todos.get();
		}else {
			return null;
		}
		
	}

	@Override
	public Todo addTodo(Todo todo) {
		// TODO Auto-generated method stub
		return todoDbRepo.save(todo);
	}

	@Override
	public Todo updateTodo(int id, Todo todo) {
		// TODO Auto-generated method stub
		Optional<Todo> existingTodo = todoDbRepo.findById(id);
		if(existingTodo.isPresent()) {
			Todo updateTodo = existingTodo.get();
			updateTodo.setTitle(todo.getTitle());
			return todoDbRepo.save(todo);
		}
		return null;
		
	}

	@Override
	public Todo deleteTodo(int id) {
		// TODO Auto-generated method stub
		Optional<Todo> existingTodo = todoDbRepo.findById(id);
		if(existingTodo.isPresent()) {
			todoDbRepo.deleteById(id);
			return existingTodo.get();
		}
		return null;
	}

	@Override
	public List<Todo> getByTitle(String title) {
		// TODO Auto-generated method stub
				var todos = todoDbRepo.findByTitle(title);
				return todos;
	}

}
