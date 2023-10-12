package com.green.refresh.group;

import com.green.refresh.group.model.GroupPicDto;
import com.green.refresh.group.model.GroupSelDto;
import com.green.refresh.group.model.GroupSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMapper {
    List<GroupSelVo> selGroup(GroupSelDto dto);
    List<GroupSelVo> selAllGroup();
    int updGroupPic(GroupPicDto dto);
}
