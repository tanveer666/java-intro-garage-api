package ee.itcollage.garageapi.server;

import ee.itcollage.garageapi.dto.Greeting;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class GreetingService {

    public Greeting buildGreeting(String name) {
        String format = format("greeting %s", name);
        return new Greeting(format);
    }

    public Greeting addPosted(Greeting greeting) {
        return new Greeting(greeting.getName() +  " POSTEEEEED");
    }

    //todo extract your business logic to services
}
