package project.KKO.VO;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Thumbnail{
    public String imageUrl;
	public String link;
	public boolean fixedRatio;
	public int width;	
	public int height;
}