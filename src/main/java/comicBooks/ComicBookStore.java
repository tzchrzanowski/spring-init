package comicBooks;

import org.springframework.stereotype.Component;

@Component
public class ComicBookStore {
    private String name;
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

    public void setComicBook(ComicBook book) {
        this.comicBook = book;
    }

    public ComicBook getComicBook() {
        return this.comicBook;
    }
}
