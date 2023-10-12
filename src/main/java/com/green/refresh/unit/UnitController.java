package com.green.refresh.unit;


import com.green.refresh.unit.model.UnitVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name ="단위 리스트")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/refresh/unit")
public class UnitController {

    private final UnitService service;

    @GetMapping
    @Operation(summary = "단위 리스트")
    public List<UnitVo> getUnit() {
        return service.selUnit();
    }
}
