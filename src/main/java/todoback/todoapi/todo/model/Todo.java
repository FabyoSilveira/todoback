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
    private String title;
    private String description;
    private boolean completed;
    private int priority;
    private String createdAt;

    public Todo() {
        this.id = UUID.randomUUID().toString();
        this.title = "";
        this.description = "";
        this.completed = false;
        this.priority = 1;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public Todo(String title, String description) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.completed = false;
        this.priority = 1;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public Todo(String id, String title, String description, boolean completed, int priority, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
        this.createdAt = createdAt;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getPriority() {
        return priority;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
