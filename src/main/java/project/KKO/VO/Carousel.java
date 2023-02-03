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
public class Carousel{
    public String type;
    public Header header;
    public ArrayList<Object> items;
}