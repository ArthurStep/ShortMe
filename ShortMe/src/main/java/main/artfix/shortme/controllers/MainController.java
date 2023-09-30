package main.artfix.shortme.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Value("${app.site.url}")
    public String appSiteUrl;


    @GetMapping("/")
    public String indexPage() {
        return "index";
    }
}
