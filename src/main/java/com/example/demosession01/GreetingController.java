package com.example.demosession01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("books01")
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println(session);
        System.out.println(request);
        for (Cookie cookie : request.getCookies()) {
            System.out.println(cookie.getName() + " " + cookie.getValue());
        }
        Cookie uiColorCookie = new Cookie("color1", "red1");
        uiColorCookie.setDomain("localhost");
        uiColorCookie.setPath("/");
        response.addCookie(uiColorCookie);
        return "greeting";
    }

}

