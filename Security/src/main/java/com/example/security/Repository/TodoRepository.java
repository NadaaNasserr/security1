package com.example.security.Repository;


import com.example.security.Modle.Todo;
import com.example.security.Modle.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {


    Todo findTodoById(Integer id);

    List<Todo> findAllByUser(User user);
}
