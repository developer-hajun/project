package com.health.project.Service;

import com.health.project.Repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;
    public String join(String userName,String password){

        return "SUCESS";
    }
}
