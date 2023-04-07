package com.example.demo.Service;

import com.example.demo.model.Todo;

import java.util.List;

public interface TodoService {

    public Todo addTodo(Todo todo);

    public List<Todo> viewall();

    public Todo updateTodo(Todo id);

    public Todo deleteTodo(Todo todo);



}
