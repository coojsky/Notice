package project.controller; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestBody;  

import project.service.*;
import project.dto.*;

@RestController 
public class NoticeController { 
    @RequestMapping(value = "/telegram", method = RequestMethod.GET) 
    public String telegram_status(){ 
        System.out.println("GET TEST");
        return "TELEGRAM GET"; 
    }
    
    @RequestMapping(value = "/telegram", method = RequestMethod.POST) 
    public String telegram_sendmsg(){ 
        System.out.println("POST TEST");
        return "TELEGRAM POST"; 
    }
    
    @RequestMapping(value = "/slack", method = RequestMethod.GET) 
    public String slack_status(){ 
        System.out.println("GET SLACK SEND MESSAGE STATUS");
        return "SLACK GET"; 
    }
    
    @RequestMapping(value = "/slack", method = RequestMethod.POST) 
    public String slack_sendmsg(@RequestBody SlackDTO slackdto){ 
        NoticeServiceInterface noticeservice = new SlackService(slackdto);
        System.out.println("결과값 : " + noticeservice.sendmsg());
        return "SLACK POST"; 
    }
}
