package com.jrp.demo.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class HelloController {

    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public String sayHello() {
        return "<h1>Hello World<h1>";
    }

    @RequestMapping(value = "/proper", method = RequestMethod.GET)
    public String sayProperHello() {
        return "<h1>Hello There, how are you?<h1>";
    }

    @RequestMapping("/user_entry")
    public String userForm() {
        return "<form action=\"/greeting/user_greeting\" method=\"POST\">\n" +
                "  First name:<br>\n" +
                "  <input type=\"text\" name=\"firstname\">\n" +
                "  <br>\n" +
                "  Last name:<br>\n" +
                "  <input type=\"text\" name=\"lastname\">\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> ";
    }

    @RequestMapping(value = "/user_greeting", method = RequestMethod.POST)
    public String printUserGreeting(@RequestParam String firstname, @RequestParam  String lastname) {
        return "Hello there, " + firstname + " " + lastname;
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String getOrder(@PathVariable String id) {
        return "Order ID: " + id;
    }
}
