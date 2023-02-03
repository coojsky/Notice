package project.KKO.VO;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Quickreply{
    public String type;
    public String label;
    public String message;
}