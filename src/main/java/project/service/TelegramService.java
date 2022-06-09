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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

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
            System.out.println("Respcd : "      + this.telegramdto.getRespcd());
            */
            
            System.out.println("Bot_cnt : "       + this.telegramdto.getBot_cnt());
            System.out.println("Chat_id : "      + this.telegramdto.getBot_chatid());
            System.out.println("Apikey : "      + this.telegramdto.getBot_apikey());
            
            ResponseEntity<String> response;            
            RestTemplate restTemplate = new RestTemplate();

            Map<String,Object> request = new HashMap<String,Object>();
            request.put("chat_id", "-1001368946161");
            request.put("text", this.telegramdto.getMsg());
    
            HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(request);
        	// Webhook URL
            String url = "https://api.telegram.org/bot5363353725:AAHuWdiZqA-vSBIDKZP-WPEVpddxjJ53QWQ/sendMessage"; 
            /*restTemplate.exchange(url, HttpMethod.POST, entity, String.class);*/
            

            try{
                response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            }
            catch (HttpStatusCodeException exception) {
                int statusCode = exception.getStatusCode().value();
                System.out.println("StatusCode[" + statusCode + "]");
            }
        
            /*System.out.println("response : " + response);*/

            System.out.println("POST TELEGRAM SEND MESSAGE END");
            
            return true;
        }
}