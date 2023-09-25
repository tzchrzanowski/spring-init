package comicBooks;

import org.springframework.stereotype.Component;

@Component
public class ComicBook {
    private String name;

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Comic Book : " + this.name;
    }
}
