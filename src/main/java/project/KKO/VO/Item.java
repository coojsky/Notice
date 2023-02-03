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
public class Item{
    public ArrayList<Object> item;
}