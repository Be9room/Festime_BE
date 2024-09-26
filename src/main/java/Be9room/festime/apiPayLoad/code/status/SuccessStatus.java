package Be9room.festime.apiPayLoad.code.status;

import Be9room.festime.apiPayLoad.code.BaseCode;
import Be9room.festime.apiPayLoad.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    //일반적인 응답
    _OK(HttpStatus.OK, "COMMON200","success"),

    //멤버 관련 응답
    MEMBER_ENTER(HttpStatus.OK, "MEMBER2001", "member entered"),

    //방명록 관련 응답
    MESSAGE_RETURN(HttpStatus.OK,"GUESTBOOK2001", "message list returned")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .isSuccess(true)
                .code(code)
                .message(message)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
