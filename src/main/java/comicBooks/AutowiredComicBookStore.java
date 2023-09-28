package comicBooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredComicBookStore {
    private String name;

    @Autowired
    private ComicBook comicBook;

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
