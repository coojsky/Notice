package project.controller; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  

@RestController 
public class NoticeController { 
    @RequestMapping(value = "/telegram", method = RequestMethod.GET) 
    public String telegram(){ 
        System.out.println("GET TEST");
        return "TELEGRAM GET"; 
    }
    
    @RequestMapping(value = "/telegram", method = RequestMethod.POST) 
    public String telegram2(){ 
        System.out.println("POST TEST");
        return "TELEGRAM POST"; 
    }
}
