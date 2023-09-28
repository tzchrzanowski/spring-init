package config;

import comicBooks.ComicBook;
import comicBooks.ComicBookStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComicBooksConfigWIredParent {
    @Bean
    public ComicBook comicBookBean() {
        ComicBook comic = new ComicBook();
        comic.setName("Adventures vol.2");
        return comic;
    }

    @Bean
    public ComicBookStore comicBookStoreWithInitialBookBean(ComicBook book) {
        ComicBookStore store = new ComicBookStore();
        store.setName("Comic Book Store with inventory");
        store.setComicBook(book);
        return store;
    }
}
