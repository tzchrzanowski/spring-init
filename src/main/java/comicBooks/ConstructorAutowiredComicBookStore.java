package comicBooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorAutowiredComicBookStore {
    private String name;
    private final ComicBook comicBook;

    @Autowired
    public ConstructorAutowiredComicBookStore(ComicBook book) {
        this.comicBook = book;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Comic Book Store : " + this.name;
    }

    public ComicBook getComicBook() {
        return this.comicBook;
    }
}
