package project.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/* SMTP */
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Component;

import project.dto.*;

@Service
public class SmtpService implements NoticeServiceInterface {
    private JavaMailSender javaMailSender;

    SmtpDTO smtpdto;

    public SmtpService(SmtpDTO smtpdto)
    {    
        this.smtpdto = smtpdto; 
    }
    
        
    @Override
    public boolean sendmsg(){
        System.out.println("POST EMAIL SEND MESSAGE START");
      /*  SimpleMailMessage message = new SimpleMailMessage();
        //message.setFrom(""); from 값을 설정하지 않으면 application.yml의 username값이 설정됩니다.
        message.setTo(smtpdto.getAddress());
        message.setSubject(smtpdto.getTitle());
        message.setText(smtpdto.getMessage());
        javaMailSender.send(message);*/
        System.out.println("POST EMAIL SEND MESSAGE END");
        return true;
    }
}