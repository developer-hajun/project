package com.health.project.Login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.health.project.Exception.AppException;
import com.health.project.Exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@WithMockUser
class UsersServiceTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("성공")
    @WithMockUser
    void join() throws Exception {
        String username = "한국";
        String password = "1234";
        mockMvc.perform(post("/join")
                .contentType(MediaType.APPLICATION_JSON).with(csrf())
                .content(objectMapper.writeValueAsBytes(new UserJoinRequest(username,password))))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("실패")
    @WithMockUser
    void join_fail() throws Exception {
        String username = "한국";
        String password = "1234";
        when(userService.join(any(),any())).thenThrow(new RuntimeException("해당 userId가 중복입니다"));
        mockMvc.perform(post("/join")
                        .contentType(MediaType.APPLICATION_JSON).with(csrf())
                        .content(objectMapper.writeValueAsBytes(new UserJoinRequest(username,password))))
                .andDo(print())
                .andExpect(status().isConflict());
    }
}