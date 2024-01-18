package todoback.todoapi.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello Spring boot!";
    }
}
