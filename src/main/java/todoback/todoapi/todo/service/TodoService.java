package todoback.todoapi.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.MissingRequiredPropertiesException;
import org.springframework.stereotype.Service;
import todoback.todoapi.todo.model.Todo;
import todoback.todoapi.todo.repository.TodoRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAll(){
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodo(String todoId){
        if(todoId.isEmpty()){
            throw new IllegalArgumentException();
        }

        return todoRepository.findById(todoId);
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(new Todo(todo.getTitle(), todo.getDescription(), todo.getPriority()));
    }

    public String handleDeleteTodo(String todoId) throws IllegalArgumentException {
        Todo todoToBeDeleted = getIfTodoExists(todoId);

        return this.deleteTodo(todoToBeDeleted);
    }

    private String deleteTodo(Todo todo) throws IllegalArgumentException {
        if(todo.getId().isEmpty()){
            throw new IllegalArgumentException();
        }

        todoRepository.deleteById(todo.getId());

        return "Todo deleted successfully: " + todo.getId();
    }

    public Todo handleUpdateTodo(Todo newTodo) throws IllegalArgumentException {
        if(newTodo.getTitle().isEmpty()){
            throw new IllegalArgumentException();
        }

        Todo currentTodo = getIfTodoExists(newTodo.getId());

        return updateTodo(currentTodo, newTodo);
    }

    private Todo updateTodo(Todo currentTodo, Todo newTodo){
        currentTodo.setDescription(newTodo.getDescription());
        currentTodo.setCompleted(newTodo.isCompleted());
        currentTodo.setPriority(newTodo.getPriority());

        return todoRepository.save(currentTodo);
    }

    private Todo getIfTodoExists(String todoId) throws NoSuchElementException {
        try{
            return todoRepository.findById(todoId).get();
        }catch(Exception e) {
            throw new NoSuchElementException("Todo does not exist in the database.");
        }
    }
}
