package com.green.refresh.user;

import com.green.refresh.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@Tag(name ="유저")
@RequestMapping("/api/refresh/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;



    @PostMapping("/user")
    @Operation(summary = "유저 추가", description = "" +
            "\"nm\": [10] 유저 닉네임,<br>" +
            "\"birth\": [10] 생년월일<br>")
    public int postUserGroup(@RequestBody UserInsDto dto) {
        return service.insUser(dto);
    }

    @GetMapping
    @Operation(summary = "유저 프로필 선택"
            , description = "" +
            "\"iuser\": 유저 PK값 <br>")
    public List<UserProfileSelVo> selectUserProfile(@RequestParam int iuser) {
        return service.selUserProfile(iuser);
    }


    @GetMapping("/all/igroup")
    @Operation(summary = "전체 유저 프로필")
    public List<UserListSelVo> selectAllUser() {
        return service.selAllUser();
    }

    @GetMapping("/all")
    @Operation(summary = "전체 유저 프로필 (igroup값 없음)")
    public List<UserProfileEGSelVo> selectAllUserEG() {
        return service.selAllUserEG();
    }

    @GetMapping("/login")
    @Operation(summary = "유저 선택"
            , description = "" +
            "\"iuser\": 유저 PK값 <br>")
    public List<UserSelVo> selectUser(@RequestParam int iuser) {
        return service.selUser(iuser);
    }

    @GetMapping("/mygroup")
    @Operation(summary = "그룹 선택"
            , description = "" +
            "\"iuser\": 유저 PK값 <br>")
    public List<UserSelGroupVo> selectUserGroup(@RequestParam int iuser) {
        return service.selUserGroup(iuser);
    }


    @PatchMapping("/userupdate")
    @Operation(summary = "유저 정보 수정", description = "" +
            "\"nm\": [10] 유저 닉네임,<br>" +
            "\"birth\": [10] 생년월일<br>")
    public int UpdInfoUser(@RequestBody UserUpdDto dto) {
        return service.updUser(dto);
    }


    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "유저 프로필 사진 추가", description = "" +
            "\"iuser\": [-] 유저 PK값 <br>" +
            "\"pic\": [-] 사진파일<br>")
    public String patchPicUser(@RequestPart MultipartFile pic, @RequestParam int iuser) {
        UserPicDto dto = new UserPicDto();
        dto.setIuser(iuser);
        return service.updUserPic(pic,dto);
    }


    @DeleteMapping
    @Operation(summary = "유저 삭제", description = "" +
            "\"iuser\": [-] 유저 PK값<br>" )
    public int deleteUser(@RequestParam int iuser) {
        return service.delUser(iuser);
    }
}
