package com.green.refresh.product;

import com.green.refresh.product.model.PdtInsDto;
import com.green.refresh.product.model.PdtSelVo;
import com.green.refresh.product.model.PdtUpdDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Tag(name="아이템")
@RequestMapping("/api/refresh")
@RequiredArgsConstructor
public class PdtController {
    private final PdtService service;

    @PostMapping("/pdt")
    @Operation(summary = "아이템 추가"
            , description = "" +
            "\"iplan\": [-] 일정 PK,<br>" +
            "\"icate\": [-] 카테고리 PK,<br>" +
            "\"nm\": [20] 제품명,<br>" +
            "\"cnt\": [-] 수량,<br>" +
            "\"iunit\": [1] 단위 PK,<br>" +
            "\"w_iuser\": [1] 작성자 - 유저 PK<br>")
    public int insPdt(@RequestBody PdtInsDto dto) {
        return service.insPdt(dto);
    }

    @GetMapping("/pdt")
    @Operation(summary = "아이템 리스트"
            , description = "" +
            "\"igroup\": [-] 그룹 PK,<br>" +
            "\"iplan\": [10] 일정 PK<br>")
    public List<PdtSelVo> selPdt(@RequestParam int igroup, @RequestParam int iplan) {
        return service.selPdt(igroup, iplan);
    }

    @PatchMapping("/pdt")
    @Operation(summary = "아이템 수정"
            , description = "" +
            "\"iproduct\": [-] 아이템 PK,<br>" +
            "\"icate\": [-] 카테고리 PK,<br>" +
            "\"nm\": [20] 제품명,<br>" +
            "\"cnt\": [-] 수량<br>" +
            "\"iunit\": [1] 단위 PK<br>")
    public int patchPdt(@RequestBody PdtUpdDto dto) {
        return service.updPdt(dto);
    }

    @PatchMapping("/pdt/finish")
    @Operation(summary = "아이템 구매 완료/취소"
            , description = "" +
            "\"iproduct\": [-] 아이템 PK<br>")
    public int finishPdt(@RequestParam int iproduct){
        return service.finishPdt(iproduct);
    }

    @DeleteMapping("/pdt")
    @Operation(summary = "아이템 삭제"
            , description = "" +
            "\"iproduct\": [-] 아이템 PK<br>")
    public int delPdt(@RequestParam int iproduct){
        return service.delPdt(iproduct);
    }
}
