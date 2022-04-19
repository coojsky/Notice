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
public class SlackService implements NoticeServiceInterface {
        SlackDTO slackdto;
        public SlackService(SlackDTO slackdto)
        {
            this.slackdto = slackdto;
        }
    
        @Override
        public boolean sendmsg(){
            System.out.println("POST SLACK SEND MESSAGE START");
            /*System.out.println("Servicenm : " + this.slackdto.getServicenm());
            System.out.println("Groupid : "   + this.slackdto.getGroupid());
            System.out.println("Date : "      + this.slackdto.getDate());
            System.out.println("MSG : "       + this.slackdto.getMsg());
            System.out.println("Type : "      + this.slackdto.getType());
            System.out.println("Respcd : "      + this.slackdto.getRespcd());*/
            
            
            RestTemplate restTemplate = new RestTemplate();

            Map<String,Object> request = new HashMap<String,Object>();
            request.put("username", this.slackdto.getServicenm());
            request.put("text", this.slackdto.getMsg());
    
            HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(request);
        	// Webhook URL
            String url = "https://hooks.slack.com/services/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";; 
    
            restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            
            System.out.println("POST SLACK SEND MESSAGE END");
            
            return true;
        }
}