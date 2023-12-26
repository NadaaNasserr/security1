package com.example.security.Service;


import com.example.security.API.ApiException;
import com.example.security.Modle.Todo;
import com.example.security.Modle.User;
import com.example.security.Repository.AuthRepository;
import com.example.security.Repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final AuthRepository authRepository;



    public List<Todo> getAllTodo(){

        return todoRepository.findAll();
    }





    public List getMyTodos(Integer auth){
        User user = authRepository.findUserById(auth);
        List<Todo> todos = todoRepository.findAllByUser(user);
        return todos;
    }


    public void addToMyTodos(Todo todo, Integer auth){

        User user = authRepository.findUserById(auth);
        todo.setUser(user);
        todoRepository.save(todo);
    }

    public void updateTodo(Integer id , Todo todo){
        Todo todo1=todoRepository.findTodoById(id);
        if(todo1==null){
            throw new ApiException("todo id not found");
        }

        todo1.setTitle(todo.getTitle());
        todoRepository.save(todo1);

    }

    public void deleteTodo(Integer id){
        Todo todo=todoRepository.findTodoById(id);
        if(todo==null){
            throw new ApiException("todo id not found");
        }
        todoRepository.delete(todo);
}

}
