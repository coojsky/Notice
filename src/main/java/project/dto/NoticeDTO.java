package project.dto;

public abstract class NoticeDTO{
    private String servicenm; // 서비스명
    
    public String getServicenm()
    {
        return servicenm;
    }
    public void setServicenm(String servicenm)
    {
        this.servicenm = servicenm;
    }
    
    private int groupid;      // 그룹번호
    public int getGroupid()
    {
        return groupid;
    }
    public void setGroupid(int groupid)
    {
        this.groupid = groupid;
    }
    
    private String date;      // 시간
    public String getDate()
    {
        return date;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    
    private String msg;       // 메시지내용
    public String getMsg()
    {
        return msg;
    }
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    
    private int type;      // 메시지종류 
    public int getType()
    {
        return type;
    }
    public void setType(int type)
    {
        this.type = type;
    }
    
    public NoticeDTO()
    {
        this.servicenm = "";
        this.groupid = 0;
        this.date = "";
        this.msg = "";
        this.type = 0;
    }
    
    public NoticeDTO(String servicenm, int groupid, String date, String msg, int type){
        this.servicenm = servicenm;
        this.groupid = groupid;
        this.date = date;
        this.msg = msg;
        this.type = type;
    }
}