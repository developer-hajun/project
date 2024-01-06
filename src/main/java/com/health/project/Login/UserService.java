package com.health.project.Login;

import com.health.project.Configuration.EncoderConfig;
import com.health.project.Exception.AppException;
import com.health.project.Exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    public String join(String username,String passWord){
        userRepository.findByUsername(username).ifPresent(user -> {
            throw new AppException(ErrorCode.USERNAME_DUPLICATED,username +"는 이미 있습니다.");
        });
        String EncodePw = encoder.encode(passWord);
        userRepository.save(new Users(username,EncodePw));
        return "SUCCESS";
    }
}
