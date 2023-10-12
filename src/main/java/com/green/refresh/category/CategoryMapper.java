package com.green.refresh.category;

import com.green.refresh.category.model.CategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<CategoryVo> selCate();
}
