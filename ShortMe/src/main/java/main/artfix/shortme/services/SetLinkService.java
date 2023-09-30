package main.artfix.shortme.services;

import lombok.RequiredArgsConstructor;
import main.artfix.shortme.controllers.MainController;
import main.artfix.shortme.models.LinkDB;
import main.artfix.shortme.repos.LinkDBrepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetLinkService {

    private final RandomCodeService randomCodeService;
    private final MainController mainController;
    private final LinkDBrepo linkDBrepo;

    public String setLink(String userStartLink) {
        String userGenLink = randomCodeService.randomCode();

        System.out.println(" ");
        System.out.println("*** NEW LINK GENERATED ***");
        System.out.println("Start user link: " + userStartLink);
        System.out.println("End user code: " + userGenLink);
        System.out.println("Final user link code: " + mainController.appSiteUrl + "/" + userGenLink);
        System.out.println("*** NEW LINK GENERATED END ***");
        System.out.println(" ");

        LinkDB linkDB;
        linkDB = new LinkDB();
        linkDB.setStartLink(mainController.appSiteUrl + "/" + userGenLink);
        linkDB.setEndLink(userStartLink);
        linkDBrepo.save(linkDB);

        return mainController.appSiteUrl + "/" + userGenLink;
    }
}
