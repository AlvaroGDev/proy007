package es.cic.curso25;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic.curso25.service.TareaService;

@SpringBootTest
public class TareaServiceIntegrationTests {

    @Autowired
    private TareaService tareaService;

    @Test
    void testCreate(){
        String nombreTarea ="TestTarea";
        
    }

    
}
