package com.green.refresh.product;

import com.green.refresh.product.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PdtService {
    private final PdtMapper mapper;

    public int insPdt(PdtInsDto dto) {
        return mapper.insPdt(dto);
    }

    public List<PdtSelVo> selPdt(int igroup, int iplan) {
        PdtSelDto dto = new PdtSelDto();
        dto.setIgroup(igroup);
        dto.setIplan(iplan);
        return mapper.selPdt(dto);
    }

    public int updPdt(PdtUpdDto dto) {
        PdtEntity entity = new PdtEntity();
        entity.setIproduct(dto.getIproduct());
        entity.setIcate(dto.getIcate());
        entity.setNm(dto.getNm());
        entity.setCnt(dto.getCnt());
        entity.setIunit(dto.getIunit());
        return mapper.updPdt(entity);
    }

    public int finishPdt(int iproduct) {
        PdtEntity entity = new PdtEntity();
        entity.setIproduct(iproduct);
        return mapper.finishPdt(entity);
    }

    public int delPdt(int iproduct) {
        PdtEntity entity = new PdtEntity();
        entity.setIproduct(iproduct);
        return mapper.delPdt(entity);
    }

}