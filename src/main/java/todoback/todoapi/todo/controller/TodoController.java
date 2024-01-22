package todoback.todoapi.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.MissingRequiredPropertiesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todoback.todoapi.todo.model.Todo;
import todoback.todoapi.todo.service.TodoService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAll(){
        return todoService.getAll();
    }

    @GetMapping("/get/{todoId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getTodo(@PathVariable String todoId){
        try{
            return ResponseEntity.ok(todoService.getTodo(todoId));
        }catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide a todo id to be found!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @DeleteMapping("/delete/{todoId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteTodo(@PathVariable String todoId) {
        try{
            return ResponseEntity.ok(todoService.handleDeleteTodo(todoId));
        }catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide a todo item id to be deleted!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateTodo(@RequestBody Todo todo) {
        try{
            return ResponseEntity.ok(todoService.handleUpdateTodo(todo));
        }catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide a todo item to be updated!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }

    @PutMapping("/complete")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> completeTodo(@RequestBody Todo todo) {
        try{
            return ResponseEntity.ok(todoService.handleUpdateTodo(todo));
        }catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide a todo item to be completed!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }
}
