package com.springBootDemo.restfulwebservices.HelloWorld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //Get

    //URI /hello-world

    //Hello world

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    //hello-world/path-variable/in28minutes
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    //Internalization of the application
    @GetMapping(path = "/hello-world-internalized")
    public String helloWorldInternalized() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }



}
