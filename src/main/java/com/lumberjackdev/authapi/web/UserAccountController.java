package com.lumberjackdev.authapi.web;

import com.lumberjackdev.authapi.domain.UserAccount;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    void create(@RequestBody UserAccount userAccount) {

    }
}
