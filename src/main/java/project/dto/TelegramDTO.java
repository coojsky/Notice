package project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Component
public class TelegramDTO{
    private String servicenm; // 서비스명
    private int groupid;      // 그룹번호
    private String date;      // 시간
    private String msg;       // 메시지내용
    private int type;         // 메시지종류 

    @Value("${telegram.bot.cnt}")
    private int bot_cnt;
    @Value("${telegram.bot.chatid001}")
    private String bot_chatid;
    @Value("${telegram.bot.apikey001}")
    private String bot_apikey;
    //private boolean respcd;   // 응답코드
}