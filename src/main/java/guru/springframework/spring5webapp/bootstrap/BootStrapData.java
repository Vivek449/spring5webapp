package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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



        System.out.println("Started in Bootstrap");
        System.out.println("Number of books "+ bookRepository.count());
    }
}
