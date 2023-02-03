package project.KKO.VO;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Button{
    public String action;
    public String label;
    public String messageText;
    public String webLinkUrl;
}