package com.example.demo.Controller;

import com.example.demo.Service.TodoService;
import com.example.demo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService trp;

    @PostMapping("/add")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo td){
        Todo p = trp.addTodo(td);

        return new ResponseEntity<Todo>(p, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Todo td){
        Todo t = trp.updateTodo(td);

        return new ResponseEntity<>(t, HttpStatus.OK);
    }


    @GetMapping("getall")
    public ResponseEntity<List<Todo>> getAll(){
        List<Todo> t = trp.viewall();

        return new ResponseEntity<List<Todo>>(t, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    ResponseEntity<Todo> DeletePlant(@PathVariable("id") Todo p){

        Todo pe = trp.deleteTodo(p);

        return new ResponseEntity<Todo>(pe ,HttpStatus.ACCEPTED);

    }
}
