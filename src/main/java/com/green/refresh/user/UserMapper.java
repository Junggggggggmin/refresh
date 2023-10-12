package com.green.refresh.user;

import com.green.refresh.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserEntity entity);
    int insUserGroup(UserEntity entity);
    List<UserProfileSelVo> selUserProfile(UserProfileSelDto dto);   //user 프로필보기
    List<UserListSelVo> selAllUser();      //전체 user 보기
    List<UserProfileEGSelVo> selAllUserEG();
    List<UserSelVo> selUser(UserSelDto dto);    //user 선택
    List<UserSelGroupVo> selUserGroup(UserSelDto dto);   //group 선택
    int updUser(UserUpdDto dto);
    int updUserPic(UserPicDto dto);     //사진 추가
    int delUser(UserDelDto dto);
}
