package com.green.refresh.category;

import com.green.refresh.category.model.CategoryVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper mapper;

    public List<CategoryVo> selCate() {
        return mapper.selCate();
    }

}
