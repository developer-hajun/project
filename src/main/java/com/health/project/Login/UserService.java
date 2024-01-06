package com.health.project.Login;

import com.health.project.Configuration.EncoderConfig;
import com.health.project.Exception.AppException;
import com.health.project.Exception.ErrorCode;
import com.health.project.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    @Value("${jwt.token.secret}")
    private String key;
    private Long expireTimeMs = 1000*60*60L;
    public String join(String username,String passWord){
        userRepository.findByUsername(username).ifPresent(user -> {
            throw new AppException(ErrorCode.USERNAME_DUPLICATED,username +"는 이미 있습니다.");
        });
        String EncodePw = encoder.encode(passWord);
        userRepository.save(new Users(username,EncodePw));
        return "SUCCESS";
    }
    public String login(String username,String password){
        Users human = userRepository.findByUsername(username).orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_FOUND, "username이 없습니다"));
        if(!encoder.matches(password,human.getPassword())){ //matchs왼쪽이 암호화 안된것 , 오른쪽이 암호화 된것
            throw new AppException(ErrorCode.INVALID_PASSWORD, human.getPassword()+"비밀번호가 틀렷습니다");
        }
        String token = JwtTokenUtil.createToken(human.getUsername(),key,expireTimeMs);
        return token;
    }
}
