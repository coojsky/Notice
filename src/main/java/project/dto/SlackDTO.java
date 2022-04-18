package project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Getter
@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Component
public class SlackDTO{
    private String servicenm; // 서비스명
    private int groupid;      // 그룹번호
    private String date;      // 시간
    private String msg;       // 메시지내용
    private int type;         // 메시지종류 
    //private boolean respcd;   // 응답코드
}