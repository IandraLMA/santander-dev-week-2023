package me.dio.component;

import me.dio.dto.GeralErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FormataErrorComponent {

    public GeralErrorDTO formataErroGeral(Throwable t,HttpStatus status){
        return new GeralErrorDTO(status.value(),t.getMessage(),LocalDateTime.now());
    }
}
