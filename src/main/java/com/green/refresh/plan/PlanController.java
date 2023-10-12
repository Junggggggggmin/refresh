package com.green.refresh.plan;

import com.green.refresh.plan.model.PlanInsDto;
import com.green.refresh.plan.model.PlanSelDto;
import com.green.refresh.plan.model.PlanSelVo;
import com.green.refresh.plan.model.PlanUpdDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Tag(name ="일정")
@RequestMapping("/api/refresh/plan")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService service;

    @Bean
    public OpenAPI OpenAPI() {
        final Info info = new Info()
                .version("v1.0.0")
                .title("re:fresh")
                .description("FRIST PROJECT");
        return new OpenAPI().info(info);
    }

    @PostMapping
    @Operation(summary = "일정등록", description =
            "  \"igroup\": [-] PK값,</br>" +
            "  \"iuser\": [-] PK값,</br>" +
            " \"created_at \" : \" [10] 해당 날짜 입력 ex)2023-07-07</br>"

            )
    public int postPlan(@RequestBody PlanInsDto dto) {
        return service.insPlan(dto);
    }


    @GetMapping
    @Operation(summary = "일정 리스트", description =
            "  \"igroup\": [-] PK값" )
    public List<PlanSelVo> getPlan(@RequestParam int igroup) {
        PlanSelDto dto = new PlanSelDto();
        dto.setIgroup(igroup);
        return service.selPlan(dto);
    }




    @PutMapping("/{iplan}")
    @Operation(summary = "일정수정", description =
            "  \"iplan\": [-] 수정할 PK값, </br>" +
            " \"createdAt\" : [10] 수정할 날짜 입력"
            )
    public int putPlan(@RequestBody PlanUpdDto dto) {
        return service.updPlan(dto);
    }

    @DeleteMapping("/{iplan}")
    @Operation(summary = "일정삭제", description =
            "  \"iplan\": [-] 삭제할 PK값 " )
    public int delPlan(@RequestParam int iplan) {
        return service.delPlan(iplan);
    }
}