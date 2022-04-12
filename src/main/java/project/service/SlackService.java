package project.service;

import org.springframework.stereotype.Service;

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
            System.out.println("Servicenm : " + this.slackdto.getServicenm());
            System.out.println("Groupid : "   + this.slackdto.getGroupid());
            System.out.println("Date : "      + this.slackdto.getDate());
            System.out.println("MSG : "       + this.slackdto.getMsg());
            System.out.println("Type : "      + this.slackdto.getType());
            System.out.println("Respcd : "      + this.slackdto.getRespcd());
            System.out.println("POST SLACK SEND MESSAGE END");
            return true;
        }
}