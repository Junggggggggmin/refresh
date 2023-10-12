package com.green.refresh.user;

import com.green.refresh.user.model.*;
import com.green.refresh.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class UserService {
    private final UserMapper mapper;

    @Value("/home/download")
    private String fileDir;

    @Autowired
    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public int insUser(UserInsDto dto) {
        UserEntity entity = new UserEntity();
        entity.setNm(dto.getNm());
        entity.setBirth(dto.getBirth());
        mapper.insUser(entity);
        entity.setIgroup(1);
        return mapper.insUserGroup(entity);

    }



    public List<UserProfileSelVo> selUserProfile(int iuser) {
        UserProfileSelDto dto = new UserProfileSelDto();
        dto.setIuser(iuser);
        return mapper.selUserProfile(dto);
    }

    public List<UserListSelVo> selAllUser() {
        return mapper.selAllUser();
    }

    public List<UserProfileEGSelVo> selAllUserEG() {
        return mapper.selAllUserEG();
    }

    public List<UserSelVo> selUser(int iuser) {
        UserSelDto dto = new UserSelDto();
        dto.setIuser(iuser);
        return mapper.selUser(dto);
    }

    public List<UserSelGroupVo> selUserGroup(int iuser) {
        UserSelDto dto = new UserSelDto();
        dto.setIuser(iuser);
        return mapper.selUserGroup(dto);
    }


    public int updUser(UserUpdDto dto) {
        return mapper.updUser(dto);
    }


    public String updUserPic(MultipartFile pic, UserPicDto dto) {

        String temp = "0";
        String centerPath = String.format("user/%d", dto.getIuser());
        String dicPath = String.format("%s/%s", FileUtils.getAbsolutePath(fileDir), centerPath);

        File dic = new File(dicPath);
        if (!dic.exists()) {
            dic.mkdirs();
        }

        String originFileName = pic.getOriginalFilename();
        String savedFileName = FileUtils.makeRandomFileNm(originFileName);
        String savedFilePath = String.format("%s/%s", centerPath, savedFileName);
        String targetPath = String.format("%s/%s", FileUtils.getAbsolutePath(fileDir), savedFilePath);
        File target = new File(targetPath);
        try {
            pic.transferTo(target);
        }catch (Exception e) {
            return temp;
        }
        dto.setPic(savedFilePath);
        try {
            int result = mapper.updUserPic(dto);
            if(result == Integer.parseInt(temp)) {
                throw new Exception("프로필 사진을 등록할 수 없습니다.");
            }
        } catch (Exception e) {
            target.delete();
            return temp;
        }
        return savedFilePath;
    }

    public int delUser(int iuser) {
        UserDelDto dto = new UserDelDto();
        dto.setIuser(iuser);

        return mapper.delUser(dto);
    }
}
