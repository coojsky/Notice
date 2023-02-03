package project.KKO.VO;

import java.util.ArrayList;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BasicCard{
    public String title;
    public String description;
    public Thumbnail thumbnail;
    public Profile profile;
    public Social social;
    public ArrayList<Button> buttons;
	
	public void setButton(Button button)
	{
		buttons.add(button);
	}
}