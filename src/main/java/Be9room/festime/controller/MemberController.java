package Be9room.festime.controller;

import Be9room.festime.apiPayLoad.ApiResponse;
import Be9room.festime.apiPayLoad.code.status.SuccessStatus;
import Be9room.festime.common.RandomNameGenerator;
import Be9room.festime.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final RandomNameGenerator randomNameGenerator;
    @GetMapping
    public ApiResponse<MemberDto.MemberResponseDto> enter(){

        MemberDto.MemberResponseDto memberDto = MemberDto.MemberResponseDto.builder()
                .memberName(randomNameGenerator.generate())
                .memberId(UUID.randomUUID().toString())
                .build();
        return ApiResponse.of(SuccessStatus.MEMBER_ENTER, memberDto);
    }

}
