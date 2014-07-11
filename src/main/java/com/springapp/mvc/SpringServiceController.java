package com.springapp.mvc;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service/greeting")
public class SpringServiceController {
    @RequestMapping(value = "/rest/{name}", method = RequestMethod.GET)
    public String getGreeting(@PathVariable String name) {
        String result = "REST!!! -> Hello " + name;
        return result;
    }

    @RequestMapping(value = "/mvc/{name}", method = RequestMethod.GET)
    public @ResponseBody  String getGreetingMVC(@PathVariable String name) {
        String result="MVC!!! -> Hello "+name;
        return result;
    }

}