package com.green.refresh.category;


import com.green.refresh.category.model.CategoryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name ="카테고리 리스트")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/refresh/category")
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    @Operation(summary = "카테고리 리스트")
    public List<CategoryVo> getCate() {
        return service.selCate();
    }
}
