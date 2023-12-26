package com.example.security.Modle;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String title;


    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")   //انشاء الفور كي
    @JsonIgnore
    private User user;


}
