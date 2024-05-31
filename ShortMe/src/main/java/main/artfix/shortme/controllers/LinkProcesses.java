package main.artfix.shortme.controllers;

import lombok.RequiredArgsConstructor;
import main.artfix.shortme.services.RedirectLinkService;
import main.artfix.shortme.services.SetLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class LinkProcesses {

    private final SetLinkService setLinkService;
    private final RedirectLinkService redirectLinkService;

    @RequestMapping("/setLink")
    public String setLink(@RequestParam(value = "user-start-link") String userStartLink, Model model) {
        String result = "Your Link is ready: " + setLinkService.setLink(userStartLink);
        model.addAttribute("userReadyLinkToGo", result);
        return "index";
    }

    @RequestMapping("/{data}")
    public String redirectLink(@PathVariable("data") String data) {
        String finalUrl = redirectLinkService.redirectLink(data);
        return "redirect:" + finalUrl;
    }
}
