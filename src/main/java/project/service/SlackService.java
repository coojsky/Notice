package project.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

/* 슬랙 */
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.methods.SlackApiException;
import com.slack.api.Slack;

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
            //System.out.println("Respcd : "      + this.slackdto.getRespcd());
            System.out.println("POST SLACK SEND MESSAGE END");
            
            // Load an env variable
            Slack slack = Slack.getInstance();
            // If the token is a bot token, it starts with `xoxb-` while if it's a user token, it starts with `xoxp-`
            String token = System.getenv("xoxb-3333536582081-3333616965265-AKCVDjjkrIWvHtL8SGeSbQUd");
            // Initialize an API Methods client with the given token
            try{
                MethodsClient methods = slack.methods(token);
                
                // Build a request object
                ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                  .channel("C039TG07MDX") // Use a channel ID `C1234567` is preferrable
                  .text(":wave: Hi from a bot written in Java!")
                  .build();
                
                // Get a response as a Java object
                ChatPostMessageResponse response = methods.chatPostMessage(request);
            }catch(IOException e)
            {
                e.printStackTrace();
            }catch(SlackApiException e)
            {
                e.printStackTrace();
            }
            
            return true;
        }
}