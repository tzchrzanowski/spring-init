package config;

import comicBooks.ComicBook;
import comicBooks.ComicBookStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComicBooksConfig {
    @Bean
    public ComicBook comicBookBean() {
        ComicBook comic = new ComicBook();
        comic.setName("Adventures vol.1");
        return comic;
    }

    @Bean
    public ComicBookStore comicBookStoreBean() {
        ComicBookStore store = new ComicBookStore();
        store.setName("Awesome Comic Books");
        return store;
    }
}
