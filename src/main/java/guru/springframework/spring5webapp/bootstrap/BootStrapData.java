package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.SchemaOutputResolver;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Paulo" , "Coelho");
        Book elevenMinutes = new Book("Eleven minutes", "123123");

        eric.getBooks().add(elevenMinutes);
        elevenMinutes.getAuthors().add(eric);

//          eric.setBooks(elevenMinutes);

        authorRepository.save(eric);
        bookRepository.save(elevenMinutes);



        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "234454");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher publisher = new Publisher();
        publisher.setName("Bharti publication");
        publisher.setCity("New Delhi");
        publisher.setState("Delhi");
        publisher.setAddressLine1(" Chandni Chauk");
        publisher.setZip("843126");



        elevenMinutes.setPublisher(publisher);
        publisher.getBooks().add(elevenMinutes);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books "+ bookRepository.count());
        System.out.println("Number of publishers "+ publisherRepository.count());
        System.out.println("Number of books publisher has "+ publisher.getBooks().size());
    }
}
