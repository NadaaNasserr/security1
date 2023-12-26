package com.example.security.Controller;


import com.example.security.Modle.Todo;
import com.example.security.Modle.User;
import com.example.security.Service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {


    private final TodoService todoService;



    @GetMapping("/get")
    public ResponseEntity getAllToto(){

        return ResponseEntity.status(200).body(todoService.getAllTodo());
    }



    @GetMapping("/get-todos")
    public ResponseEntity getMyTodos(@AuthenticationPrincipal User user){

   return ResponseEntity.status(200).body(todoService.getMyTodos(user.getId()));

    }








    @PostMapping("/add")
    public ResponseEntity addTodo(@RequestBody @Valid Todo todo, @AuthenticationPrincipal User user){

        todoService.addToMyTodos(todo, user.getId());
        return ResponseEntity.status(200).body("todo added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTodo(@PathVariable Integer id, @RequestBody @Valid Todo todo){

        todoService.updateTodo(id,todo);
        return ResponseEntity.status(200).body("todo updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTodo(@PathVariable Integer id){
        todoService.deleteTodo(id);
        return ResponseEntity.status(200).body("todo deleted");


    }
}
