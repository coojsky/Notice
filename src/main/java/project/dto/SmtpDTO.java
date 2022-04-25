package project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Component
public class SmtpDTO{
    private String address;
    private String title;
    private String message;
    private MultipartFile file;
}