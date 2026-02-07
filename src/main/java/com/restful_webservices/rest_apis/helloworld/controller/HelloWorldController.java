package com.restful_webservices.rest_apis.helloworld.controller;

import com.restful_webservices.rest_apis.helloworld.entity.HelloWorldBean;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

//    DispatcherServlet is the front controller in Spring MVC that handles all the incoming requests and then dispatches them to the appropriate controller methods based on the URL patterns defined in the controller classes.
//    All the requests that are coming to the application will be handled by the DispatcherServlet and then it will look for the url pattern and then map it to the method that is handling the request
//    Dispatcherservlet will look for the url pattern and then map it to the method that is handling the request


//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world") - old way for mapping a get request
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        String myMessage = "wow I'm able to create a rest apt";
        return "Hello World " + myMessage;
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean getHelloWorldBean(){
        return new HelloWorldBean("I learned how to return a bean as a json response");
    }

    //understanding of pathvariable - we can pass a variable in the url and then we can use that variable in the method to return a response
    //    @GetMapping(path = "/hello-world/path-variable/{name}")
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean HelloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

}
