package project.controller; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

import java.time.LocalDateTime;

import project.KKO.VO.*;
import project.service.*;
import project.dto.*;
import project.repository.*;
import java.util.*;

@RestController 
public class NoticeController { 
	
	@Autowired
	KkoRepository repository;
	
    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String test(){ 
        System.out.println("Hello");
        return "Hello"; 
    }
	
	@GetMapping(value = "/view") 
    public String test2(){ 
        return "view"; 
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
    
    @RequestMapping(value = "/v1/email", method = RequestMethod.POST) 
    @ResponseBody
    public SmtpDTO smtp_sendmsg(@RequestBody SmtpDTO smtpdto){ 
        /*NoticeServiceInterface noticeservice = new SmtpService(smtpdto);
        System.out.println("결과값 : " + noticeservice.sendmsg());*/
        return smtpdto; 
    }
	
	
	
	
	/* ========================== KKO 챗봇 ======================== */
    //카카오톡 오픈빌더로 리턴할 스킬 API
    @RequestMapping(value = "/kkoChat/v1" , method= {RequestMethod.POST , RequestMethod.GET },headers = {"Accept=application/json"})
    public String callAPI(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		String sendmsg = "", msg = "";
		System.out.println("callAPI Start");
		
        try{
			
			msg = RecvMsg(params);
			sendmsg = SendMsg(msg);
			System.out.println(sendmsg);
			
        }catch (Exception e){
			System.out.println("Error");
        }
		System.out.println("callAPI End");
        return sendmsg;
    }
	
	public String SimpleText(String msg)
	{
		System.out.println("SimpleText Make Start");
		
		String jsonInString = "";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Root 		root			= 	new Root();
			Template 	template 		= 	new Template();
			OutputS		output		 	= 	new OutputS();
			ArrayList<Object> outputs   =	new ArrayList<Object>();
			SimpleText simpletext 		=	new SimpleText();
			
			simpletext.setText("미등록 단어 또는 오답입니다.\n" 
							   + "다시 한번 생각해보세요.\n\n"
							   + "ex) 정답 예시)\n"
							   + "역맞추기 : 서울역 [서울]만 입력\n"
							   + "색맞추기 : 파랑색 [파랑]만 입력");
				
			output.setSimpleText((SimpleText)simpletext);
			outputs.add((OutputS)output);
			template.setOutputs(outputs);
			
			root.setTemplate(template);
			root.setVersion("2.0");
			         
			//Json으로 구조 변경
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
			
        } catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("SimpleText Make End");
		return jsonInString; 
	}
	
	public String BasicCard(String msg)
	{
		System.out.println("BasicCard Make Start");
		
		String jsonInString = "";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Root 		root			= 	new Root();
			Template 	template 		= 	new Template();
			OutputB		output		 	= 	new OutputB();
			ArrayList<Object> outputs   =	new ArrayList<Object>();
			/*
			Quickreply quickreply       =	new Quickreply();
			ArrayList<Object> quickReplies   =	new ArrayList<Object>();
			*/
			
			BasicCard basiccard = repository.selectMsg(msg);
			
			/* 미등록 단어 조회시검색 후 없는 값을 조회하는 경우*/
			if(basiccard == null) return SimpleText(msg);
			
			/*
			quickreply.setType("text");
			quickreply.setLabel("text");
			quickreply.setMessage("text");
			quickReplies.add((Quickreply)quickreply);
			template.setQuickReplies(quickReplies);
			*/
			
			output.setBasicCard((BasicCard)basiccard);
			outputs.add((OutputB)output);
			template.setOutputs(outputs);
			
			root.setTemplate(template);
			root.setVersion("2.0");
			         
			//Json으로 구조 변경
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
			
        } catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("BasicCard Make End");
		return jsonInString; 
	}
	
	public String Carousel(String msg)
	{
		System.out.println("BasicCard Make Start");
		
		String jsonInString = "";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Root 		root			= 	new Root();
			Template 	template 		= 	new Template();
			OutputC		output		 	= 	new OutputC();
			ArrayList<Object> outputs   =	new ArrayList<Object>();
			ArrayList<Object> items		=	new ArrayList<Object>();
			Header		header			=	new Header();
			Thumbnail	thumbnail 		= 	new Thumbnail();

			thumbnail.setImageUrl("https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg");
			//header.setTitle("베이직카드");
			//header.setThumbnail(thumbnail);
			
			Carousel carousel = repository.CarouselMsg(msg);
			
			/* 미등록 단어 조회시검색 후 없는 값을 조회하는 경우*/
			if(carousel == null) return SimpleText(msg);
			
			output.setCarousel((Carousel)carousel);
			outputs.add((OutputC)output);
			template.setOutputs(outputs);
			
			root.setTemplate(template);
			root.setVersion("2.0");
			         
			//Json으로 구조 변경
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
			
        } catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("BasicCard Make End");
		return jsonInString; 
	}
	
	public String UpdateMsg(String msg)
	{
		System.out.println("UpdateMsg Make Start");
		
		String jsonInString = "";
		ObjectMapper mapper = new ObjectMapper();
		
		
		String question = msg.split("/")[0];
		String number = msg.split("/")[1];
		String password = msg.split("/")[2];
		String answer = "하얀";
		
		
		String modify_msg = "퀴즈를 무사히 해결하셨군요!\n\n"
			+ "퀴즈에 대한 보상입니다.\n"
			+ "물품보관함의 번호는 " + number + "번\n"
			+ "패스워드는 " + password + "번입니다.\n\n"
			+ "물품보관함에 있는 초대장을\n"
			+ "보고 최종목적지로 이동해주세요.\n\n"	
			+ "최종목적지 앞에서 \"도착\"\n"
			+ "버튼을 눌러주세요.";
		try {
			
			repository.Main_Update(answer, modify_msg);
			
			Root 		root			= 	new Root();
			Template 	template 		= 	new Template();
			OutputS		output		 	= 	new OutputS();
			ArrayList<Object> outputs   =	new ArrayList<Object>();
			SimpleText simpletext 		=	new SimpleText();
			
			simpletext.setText("등록이 완료되었습니다.");
				
			output.setSimpleText((SimpleText)simpletext);
			outputs.add((OutputS)output);
			template.setOutputs(outputs);
			
			root.setTemplate(template);
			root.setVersion("2.0");
			         
			//Json으로 구조 변경
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
			
        } catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("SimpleText Make End");
		return jsonInString; 
	}
	
	public String MakeMsg(String msg)
	{
		  // 현재 날짜/시간
        LocalDateTime now = LocalDateTime.now();

        // 현재 날짜/시간 출력
        System.out.println(now); // 2021-06-17T06:40:35.477667600
		 int year = now.getYear();  // 연도
        String month = now.getMonth().toString();  // 월(문자열)
        int monthValue = now.getMonthValue();  // 월(숫자)
        int dayOfMonth = now.getDayOfMonth();  // 일(월 기준)
        int dayOfYear = now.getDayOfYear();  // 일(년 기준)
        String dayOfWeek = now.getDayOfWeek().toString();  // 요일(문자열)
        int dayOfWeekValue = now.getDayOfWeek().getValue();  // 요일(숫자)
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
		
		
		if (msg.contains("패스워드"))
		{
			return UpdateMsg(msg);
		}
		else
		{	
			String type = repository.selectType(msg);
			if(type == null) // 미등록 값인 경우
				return SimpleText(msg);
			else
			{
				switch(type)
				{
					case "1" :
						return SimpleText(msg);
					case "3" :
						return BasicCard(msg);
					case "4" : 
						return Carousel(msg);
					default :
						return SimpleText(msg);
				}
			}
		}
		
		
		/*
 		
		if(monthValue == 11 
		  && dayOfMonth == 12
		  && hour >= 12
		  && minute >= 00)
		{
			
			if (msg.contains("패스워드"))
			{
				return UpdateMsg(msg);
			}
			else
			{	
				String type = repository.selectType(msg);
				if(type == null) // 미등록 값인 경우
					return SimpleText(msg);
				else
				{
					switch(type)
					{
						case "1" :
							return SimpleText(msg);
						case "3" :
							return BasicCard(msg);
						case "4" : 
							return Carousel(msg);
						default :
							return SimpleText(msg);
					}
				}
			}
		}
		else
		{
			return BasicCard("시작시간안됨");
		}
		*/
		
	}
	
	public String SendMsg(String msg)
	{
		System.out.println("SendMsg Start");
		String sendmsg = MakeMsg(msg);
		
		TelegramDTO telegram = new TelegramDTO("알림봇", 100001, "", "현재 진행 상태 : " + msg, 1, 0, "", "");
		NoticeServiceInterface noticeservice = new TelegramService(telegram);
		noticeservice.sendmsg();

		System.out.println("SendMsg End");
		return sendmsg;
	}
	
	public String RecvMsg(Map<String, Object> msg)
	{
		System.out.println("RecvMsg Start");
		HashMap<String, Object> resultJson = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		try
		{		
			/* 전체 수신 메시지 확인*/
			String requestMsg = mapper.writeValueAsString(msg);
           	System.out.println(requestMsg);
				
			/* 특정 데이터 쪼개기 */
           	HashMap<String,Object> userRequest =  (HashMap<String,Object>)msg.get("userRequest");
            	
			/* 수신 메시지 별 응답메시지 처리*/
			return userRequest.get("utterance").toString().replace("\n","");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("RecvMsg End");
		return "";
	}
}



