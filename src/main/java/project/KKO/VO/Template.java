package project.KKO.VO;

import java.util.ArrayList;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Template{
    public ArrayList<Object> outputs;
	public ArrayList<Object> quickReplies;
	/*
	public Template()
	{
		outputs = new ArrayList<Object>();
		quickReplies = new ArrayList<Object>();
	}
	public void setOutput(Object output)
	{
		outputs.add(output);
	}
	
	public void setQuickReplies(Object quickreply)
	{
		quickReplies.add(quickreply);
	}
	*/
}