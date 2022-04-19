package project.controller; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.ResponseBody;

import project.service.*;
import project.dto.*;

@RestController 
public class NoticeController { 
    
    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String test(){ 
        System.out.println("Hello");
        return "Hello"; 
    }
    
    @RequestMapping(value = "/v1/telegram", method = RequestMethod.GET) 
    public String telegram_status(){ 
        System.out.println("GET TEST");
        return "TELEGRAM GET"; 
    }
    
    @RequestMapping(value = "/v1/telegram", method = RequestMethod.POST) 
    @ResponseBody
    public TelegramDTO telegram_sendmsg(@RequestBody TelegramDTO telegramdto){ 
        NoticeServiceInterface noticeservice = new TelegramService(telegramdto);
        System.out.println("결과값 : " + noticeservice.sendmsg());
        return telegramdto; 
    }
    
    @RequestMapping(value = "/v1/slack", method = RequestMethod.GET) 
    public String slack_status(){ 
        System.out.println("GET SLACK SEND MESSAGE STATUS");
        return "SLACK GET"; 
    }
    
    @RequestMapping(value = "/v1/slack", method = RequestMethod.POST) 
    @ResponseBody
    public SlackDTO slack_sendmsg(@RequestBody SlackDTO slackdto){ 
        NoticeServiceInterface noticeservice = new SlackService(slackdto);
        System.out.println("결과값 : " + noticeservice.sendmsg());
        return slackdto; 
    }
}


