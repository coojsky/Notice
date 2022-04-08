package project.service;

import org.springframework.stereotype.Service;

import project.service.*;
import project.dto.*;

@Service
public class SlackService implements NoticeServiceInterface {
    
        NoticeDTO notice;
        public SlackService(SlackDTO notice)
        {
            this.notice = notice;
        }
    
        @Override
        public boolean sendmsg(){
            System.out.println("POST SLACK SEND MESSAGE START");
            System.out.println("Servicenm : " + this.notice.getServicenm());
            System.out.println("Groupid : "   + this.notice.getGroupid());
            System.out.println("Date : "      + this.notice.getDate());
            System.out.println("MSG : "       + this.notice.getMsg());
            System.out.println("Type : "      + this.notice.getType());
            System.out.println("POST SLACK SEND MESSAGE END");
            return true;
        }
}