package com.green.refresh.unit;

import com.green.refresh.unit.model.UnitVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitService {
    private final UnitMapper mapper;

    public List<UnitVo> selUnit() {
        return mapper.selUnit();
    }
}
