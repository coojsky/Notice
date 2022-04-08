package project.dto;

import project.dto.NoticeDTO;

public class SlackDTO extends NoticeDTO{
    public SlackDTO(){
    }
    
    public SlackDTO(String servicenm, int groupid, String date, String msg, int type){
        super(servicenm, groupid, date, msg, type);
    }
    
    
}