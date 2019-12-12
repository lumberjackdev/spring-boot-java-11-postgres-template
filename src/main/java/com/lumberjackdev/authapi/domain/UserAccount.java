package com.lumberjackdev.authapi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserAccount {

    @NonNull
    private String email;

    @NonNull
    private String password;
}
