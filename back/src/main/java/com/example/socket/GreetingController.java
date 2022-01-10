package com.example.socket;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.HashMap;
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class GreetingController {
    Gson g = new Gson();
    HashMap<String,HashMap<String,String[]>>Frontq;
    HashMap<String,HashMap<String,String[]>>Frontm;
    ObjectMapper mapper = new ObjectMapper();
    Board B =new Board();
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(9000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @GetMapping("/input")
     public void getmessag(@RequestParam String frontq,@RequestParam String frontm ,@RequestParam String products) throws InterruptedException, IOException {
        Frontq = mapper.readValue(frontq,HashMap.class);
        Frontm=mapper.readValue(frontm,HashMap.class);
        B.makequeue(Frontq);
        B.makemachine(Frontm);
        B.n=Integer.parseInt(products);
    }
    trying t;
    public GreetingController (SimpMessagingTemplate messagingTemplate)
    {
        this.t= new trying(messagingTemplate);
    }

}
