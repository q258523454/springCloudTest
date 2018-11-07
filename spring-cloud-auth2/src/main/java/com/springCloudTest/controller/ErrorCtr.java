package com.springCloudTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

@Controller
@SessionAttributes("authorizationRequest")
public class ErrorCtr {
    private static final Logger log = LoggerFactory.getLogger(ErrorCtr.class);

    @RequestMapping("/oauth/error")
    public String error(@RequestParam Map<String, String> parameters) {
        String uri = parameters.get("redirect_uri");
        log.info("重定向: {}", uri);

        return "redirect:" + uri + "?error=1";
    }

}
