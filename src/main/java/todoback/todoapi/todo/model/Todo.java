package todoback.todoapi.todo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Document(collection = "todos")
public class Todo {
    @Id
    private String id;
    private String description;
    private boolean completed;
    private String createdAt;

    public Todo() {
        this.id = UUID.randomUUID().toString();
        this.description = "";
        this.completed = false;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public Todo(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.completed = false;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public Todo(String id, String description, boolean completed, String createdAt) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
