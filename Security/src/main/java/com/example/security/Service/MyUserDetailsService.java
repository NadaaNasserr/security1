package com.example.security.Service;


import com.example.security.API.ApiException;
import com.example.security.Modle.User;
import com.example.security.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class MyUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authRepository.findUserByUsername(username);
        if(user==null){
            throw new ApiException("Wrong username or password");
        }
        return user;//هنا لازم اروح لليوزر واسوي امبلمت لليوزر مودل واضيف الميثودات
    }

}
