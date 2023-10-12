package com.green.refresh.unit;

import com.green.refresh.unit.model.UnitVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UnitMapper {
    List<UnitVo> selUnit();
}
