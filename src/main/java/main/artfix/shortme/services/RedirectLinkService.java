package main.artfix.shortme.services;

import lombok.RequiredArgsConstructor;
import main.artfix.shortme.controllers.MainController;
import main.artfix.shortme.models.LinkDB;
import main.artfix.shortme.repos.LinkDBrepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedirectLinkService {

    private final LinkDBrepo linkDBrepo;
    private final MainController mainController;

    public String redirectLink(String data) {
        LinkDB redirectLinkGet = linkDBrepo.findByStartLink(mainController.appSiteUrl + "/" + data);
        return redirectLinkGet.getEndLink();
    }
}
