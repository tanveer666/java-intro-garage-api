package ee.itcollage.garageapi.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PathController {

    @RequestMapping("/path/{anyValue}")
    //maps any URL in with PATH in it to this method (path). The variable part of the URL (/path/121213/lol) is 121213
    public String path(@PathVariable(name = "anyValue") String anyValue) {  //name part could be omitted as URL var and Parameter share the same name. So the variable part of the URL (anything after /path/) is put into string anyValue.
        return "The value extracted from the PATH is " + anyValue;
    }
}
