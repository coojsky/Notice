package project.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

/* 슬랙 */
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import project.dto.*;

@Service
public class TelegramService implements NoticeServiceInterface {
        TelegramDTO telegramdto;
        public TelegramService(TelegramDTO telegramdto)
        {
            this.telegramdto = telegramdto;
        }
    
        @Override
        public boolean sendmsg(){
            System.out.println("POST TELEGRAM SEND MESSAGE START");
            /*System.out.println("Servicenm : " + this.telegramdto.getServicenm());
            System.out.println("Groupid : "   + this.telegramdto.getGroupid());
            System.out.println("Date : "      + this.telegramdto.getDate());
            System.out.println("MSG : "       + this.telegramdto.getMsg());
            System.out.println("Type : "      + this.telegramdto.getType());
            System.out.println("Respcd : "      + this.telegramdto.getRespcd());*/
            
            
            RestTemplate restTemplate = new RestTemplate();

            Map<String,Object> request = new HashMap<String,Object>();
            request.put("chat_id", "5331370642");
            request.put("text", this.telegramdto.getMsg());
    
            HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(request);
        	// Webhook URL
            String url = "https://api.telegram.org/bot5215339582:AAFMEzJZJrAkZ6yeJ-FXP5zI94DT5B5X-fk/sendMessage";; 
    
            restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            
            System.out.println("POST TELEGRAM SEND MESSAGE END");
            
            return true;
        }
}