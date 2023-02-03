package project.repository; 

import project.KKO.VO.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface KkoRepository {
	
	public String selectType(String question);

    @Select("SELECT A.ANSWER_TYPE as type,  "
						+ "	A.ANSWER_TITLE as title, "
						+ "	A.ANSWER_DESCRIPTION as description, "
						+ "	B.BUTTON_ACTION as b_action , "
						+ "	B.BUTTON_LABEL as b_label, "
						+ "	B.BUTTON_OPTION_TYPE as b_webLinkUrl, "
						+ "	B.BUTTON_OPTION_LABEL as b_messageText, "
						+ "	C.THUMBNAIL_IMAGEURL as t_imageUrl, "
						+ "	C.THUMBNAIL_LINK as t_link, "
						+ "	C.THUMBNAIL_FIXEDRATIO as t_fixedRatio, "
						+ "	C.THUMBNAIL_WIDTH as t_width, "
						+ "	C.THUMBNAIL_HEIGHT as t_height, "
						+ "	D.PROFILE_IMAGEURL as p_imageUrl, "
						+ "	D.PROFILE_NICKNAME as p_nickname, "
						+ "	E.SOCIAL_LIKE as s_like, "
						+ "	E.SOCIAL_COMMENT as s_comment, "
						+ "	E.SOCIAL_SHARE as s_share "
						+ "FROM MAIN_TABLE A"
						+ "	LEFT JOIN BUTTON_TABLE B ON A.TRAN_NO = B.FK_TRAN_NO"
						+ "	LEFT JOIN THUMBNAIL_TABLE C ON A.TRAN_NO = C.FK_TRAN_NO  "
						+ "	LEFT JOIN PROFILE_TABLE D ON A.TRAN_NO = D.FK_TRAN_NO "
						+ "	LEFT JOIN SOCIAL_TABLE E ON A.TRAN_NO = E.FK_TRAN_NO "
						+ "WHERE 1=1   "
						+ "AND A.QUESTION = #{question}")
    @ResultMap("BasicCard")
    public BasicCard selectMsg(String question);
	
	@Select("SELECT 'basicCard' as c_type, "
				+ " D.TITLE as ch_title, "
            	+ " D.DESCRIPTION as ch_description, "
            	+ " E.THUMBNAIL_IMAGEURL as ct_imageUrl, "
            	+ " E.THUMBNAIL_LINK as ct_link, "
    			+ " E.THUMBNAIL_FIXEDRATIO as ct_fixedRatio, "
            	+ " E.THUMBNAIL_WIDTH as ct_width, "
				+ " E.THUMBNAIL_HEIGHT as ct_height, "
            	+ " C.ANSWER_TYPE as type, "
            	+ " C.ANSWER_TITLE as title, "
            	+ " C.ANSWER_DESCRIPTION as description, "
            	+ " G.BUTTON_ACTION as b_action, "
            	+ " G.BUTTON_LABEL as b_label, "
            	+ " G.BUTTON_OPTION_TYPE as b_webLinkUrl, "
            	+ " G.BUTTON_OPTION_LABEL as b_messageText, "
            	+ " H.THUMBNAIL_IMAGEURL as t_imageUrl, "
            	+ " H.THUMBNAIL_LINK as t_link, "
            	+ " H.THUMBNAIL_FIXEDRATIO as t_fixedRatio, "
            	+ " H.THUMBNAIL_WIDTH as t_width, "
            	+ " H.THUMBNAIL_HEIGHT as t_height, "
            	+ " I.PROFILE_IMAGEURL as p_imageUrl, "
            	+ " I.PROFILE_NICKNAME as p_nickname, "
            	+ " J.SOCIAL_LIKE as s_like, "
            	+ " J.SOCIAL_COMMENT as s_comment, "
            	+ " J.SOCIAL_SHARE as s_share "
        	+ "FROM MAIN_TABLE A "
          		+ " LEFT JOIN CAROUSEL_TABLE B ON A.TRAN_NO = B.TRAN_NO "
          		+ " LEFT JOIN MAIN_TABLE C ON B.FK_TRAN_NO = C.TRAN_NO "
          		+ " LEFT JOIN CAROUSEL_HEADER_TABLE D ON A.TRAN_NO = D.TRAN_NO "
          		+ " LEFT JOIN THUMBNAIL_TABLE E ON D.FK_TRAN_NO = E.FK_TRAN_NO "
          		+ " LEFT JOIN CAROUSEL_HEADER_TABLE F ON C.TRAN_NO = F.TRAN_NO "
          		+ " LEFT JOIN BUTTON_TABLE G ON C.TRAN_NO = G.FK_TRAN_NO "
          		+ " LEFT JOIN THUMBNAIL_TABLE H ON C.TRAN_NO = H.FK_TRAN_NO "
          		+ " LEFT JOIN PROFILE_TABLE I ON C.TRAN_NO = I.FK_TRAN_NO "
     			+ " LEFT JOIN SOCIAL_TABLE J ON C.TRAN_NO = J.FK_TRAN_NO " 
			+ " WHERE 1=1 "
				+ " AND A.QUESTION = #{question} ")
    @ResultMap("Carousel")
    public Carousel CarouselMsg(String question);
	
	public int Thumbnail_Insert(int fk_tran_no, String url);	
	public int Thumbnail_Update(int fk_tran_no, String url);	
	
	public int Main_Update(String question, String msg);	
}