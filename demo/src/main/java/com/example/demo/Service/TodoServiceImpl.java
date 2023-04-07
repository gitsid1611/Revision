package com.example.demo.Service;

import com.example.demo.Repo.TodoRepo;
import com.example.demo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepo trp;


    @Override
    public Todo addTodo(Todo todo) {
        return trp.save(todo);
    }

    @Override
    public List<Todo> viewall() {
       return trp.findAll();
    }

    @Override
    public Todo updateTodo(Todo id) {
        Optional<Todo> t = trp.findById(id.getId());

        if(t !=null)
           trp.save(id);


        return trp.save(id);


    }

    @Override
    public Todo deleteTodo(Todo todo) {
        Optional<Todo> t = trp.findById(todo);

        if(t !=null)
            trp.delete(todo);


        return todo;

    }
}
