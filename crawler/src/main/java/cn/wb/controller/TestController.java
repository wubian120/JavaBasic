package cn.wb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(){

        return "Hi this is a crawler application..";

    }

}
