package com.green.refresh.user.model;

import lombok.Data;

@Data
public class UserEntity {
    private int iuser;
    private int igroup;
    private String nm;
    private String birth;
    private String pic;
    private int delYn;
}
