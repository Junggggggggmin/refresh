package com.green.refresh.group;

import com.green.refresh.group.model.GroupPicDto;
import com.green.refresh.group.model.GroupSelDto;
import com.green.refresh.group.model.GroupSelVo;
import com.green.refresh.user.model.UserPicDto;
import com.green.refresh.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupMapper mapper;

    @Value("${file.dir}")
    private String fileDir;

    public List<GroupSelVo> selGroup(int igroup) {
        GroupSelDto dto = new GroupSelDto();
        dto.setIgroup(igroup);
        return mapper.selGroup(dto);
    }

    public List<GroupSelVo> selAllGroup() {
        return mapper.selAllGroup();
    }


    public String updGroupPic(MultipartFile pic, GroupPicDto dto) {

        String temp = "0";
        String centerPath = String.format("group/%d", dto.getIgroup());
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
            int result = mapper.updGroupPic(dto);
            if(result == Integer.parseInt(temp)) {
                throw new Exception("그룹 프로필 사진을 등록할 수 없습니다.");
            }
        } catch (Exception e) {
            target.delete();
            return temp;
        }
        return savedFilePath;
    }
}
