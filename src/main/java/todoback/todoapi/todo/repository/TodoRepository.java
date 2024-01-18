package todoback.todoapi.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import todoback.todoapi.todo.model.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {
}
