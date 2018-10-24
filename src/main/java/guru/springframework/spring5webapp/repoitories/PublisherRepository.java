package guru.springframework.spring5webapp.repoitories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
