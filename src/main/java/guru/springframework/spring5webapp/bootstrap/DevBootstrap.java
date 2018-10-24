package guru.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repoitories.AuthorRepository;
import guru.springframework.spring5webapp.repoitories.BookRepository;
import guru.springframework.spring5webapp.repoitories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	@Autowired	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		//Eric
		Author eric = new Author("Eric", "Evans");
		Publisher harper = new Publisher("Harper Collins", "Street 1, LA");
		Book ddd = new Book("Domain Driven Design", "1234", harper);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		publisherRepository.save(harper);
		bookRepository.save(ddd);		
		
		//Rod
		Author rod = new Author("Rod", "Jhonson");
		Publisher worx = new Publisher("Worx", "Street 2, FL");
		Book noEJB = new Book("J2EE Development without EJB", "5678", worx);
		rod.getBooks().add(noEJB);
		authorRepository.save(rod);
		publisherRepository.save(worx);
		bookRepository.save(noEJB);
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();		
	}
}
