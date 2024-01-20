package todoback.todoapi.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoback.todoapi.todo.model.Todo;
import todoback.todoapi.todo.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAll(){
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(new Todo(todo.getTitle(), todo.getDescription(), todo.getPriority()));
    }

    public String handleDeleteTodo(String todoId) throws Exception {
        if(todoId.isEmpty()){
            throw new Exception("Todo id cannot be empty.");
        }

        Todo todoToBeDeleted = getIfTodoExists(todoId);

        return this.deleteTodo(todoToBeDeleted);
    }

    private String deleteTodo(Todo todo){
        todoRepository.deleteById(todo.getId());

        return "Todo deleted successfully: " + todo.getId();
    }

    public Todo handleUpdateTodo(Todo newTodo) throws Exception {
        if(newTodo == null){
            throw new Exception("Provide a todo item to be updated!");
        }

        Todo currentTodo = getIfTodoExists(newTodo.getId());

        return updateTodo(currentTodo, newTodo);
    }

    private Todo updateTodo(Todo currentTodo, Todo newTodo){
        currentTodo.setDescription(newTodo.getDescription());
        currentTodo.setCompleted(newTodo.isCompleted());
        currentTodo.setPriority(newTodo.getPriority());

        return todoRepository.save(newTodo);
    }

    private Todo getIfTodoExists(String todoId) throws Exception {
        try{
            return todoRepository.findById(todoId).get();
        }catch(Exception e) {
            throw new Exception("Todo does not exist in the database.");
        }
    }
}
