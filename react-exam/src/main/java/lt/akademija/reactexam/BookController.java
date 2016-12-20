package lt.akademija.reactexam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final List<Book> books = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong idGenerator = new AtomicLong(0);

    {
        Book pragmaticProgrammer = new Book();
        pragmaticProgrammer.setId(idGenerator.incrementAndGet());
        pragmaticProgrammer.setTitle("The Pragmatic Programmer: From Journeyman to Master");
        pragmaticProgrammer.setAuthor("Andrew Hunt, David Thomas");
        pragmaticProgrammer.setIsbn("0-201-61622-X");
        pragmaticProgrammer.setQuantity(10);
        pragmaticProgrammer.setPublishedAt(parseData("1999-10-01"));
        books.add(pragmaticProgrammer);

        Book codeComplete2 = new Book();
        codeComplete2.setId(idGenerator.incrementAndGet());
        codeComplete2.setTitle("Code Complete 2nd Edition");
        codeComplete2.setAuthor("Steve McConnell");
        codeComplete2.setIsbn("978-0-7356-1967-8");
        codeComplete2.setQuantity(5);
        codeComplete2.setPublishedAt(parseData("2004-01-01"));
        books.add(codeComplete2);

        Book algoIntro = new Book();
        algoIntro.setId(idGenerator.incrementAndGet());
        algoIntro.setTitle("Introduction to Algorithms");
        algoIntro.setAuthor("Charles E. Leiserson, Thomas H. Cormen, Clifford Stein, Ronald Rivest");
        algoIntro.setIsbn("978-0262032933");
        algoIntro.setQuantity(58);
        algoIntro.setPublishedAt(parseData("1990-07-14"));
        books.add(algoIntro);
    }

    @GetMapping("/api/books")
    @ApiOperation(value = "Returns all books that are currently present in the library")
    public List<Book> getBooks() {
        return books;
    }

    @GetMapping("/api/books/{id}")
    @ApiOperation(value = "Returns single book by given id")
    public Book getBook(@PathVariable Long id) {
        return books.stream()
                    .filter(b -> b.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException(String.format("Book with id %s was not found", id)));
    }

    @PostMapping("/api/books")
    @ApiOperation(value = "Creates or updates existing book. When ID specified update is done otherwise create.")
    public Book addBook(@RequestBody Book newBook) {
        if (newBook.getId() == null) {
            long id = idGenerator.incrementAndGet();
            newBook.setId(id);
            books.add(newBook);
            return newBook;
        } else {
            updateById(newBook);
            return newBook;
        }
    }

    @PutMapping("/api/books/{id}")
    @ApiOperation(value = "Updates book of given id")
    public Book addBook(@RequestBody Book updatedBook, @PathVariable Long id) {
        updatedBook.setId(id);
        updateById(updatedBook);
        return updatedBook;
    }

    private void updateById(@RequestBody Book newBook) {
        books.replaceAll(book -> {
            if (book.getId().equals(newBook.getId())) {
                return newBook;
            } else {
                return book;
            }
        });
    }

    private Date parseData(String date) {
        SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-dd");
        try {
            return f.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
