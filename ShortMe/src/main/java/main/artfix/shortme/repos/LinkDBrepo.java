package main.artfix.shortme.repos;

import main.artfix.shortme.models.LinkDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkDBrepo extends CrudRepository<LinkDB, Long> {
    LinkDB findByStartLink(String startLinkToFind);
}
