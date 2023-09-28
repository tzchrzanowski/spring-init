package main;

import animals.Cat;
import animals.Parrot;
import comicBooks.AutowiredComicBookStore;
import comicBooks.ComicBookStore;
import config.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        /*
         * Initialize spring contexts:
         * */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var contextEmpty = new AnnotationConfigApplicationContext(ProjectConfigEmpty.class);
        var contextComicBooks = new AnnotationConfigApplicationContext(ComicBooksConfig.class);
        var contextComicBooksWithInventory = new AnnotationConfigApplicationContext(ComicBooksConfigWIredParent.class);
        var contextWithAutowiredBooks = new  AnnotationConfigApplicationContext(ConfigStoreWithAutowiredBooks.class);

        /*
         * Context opetarions:
         * */
        // parrotBeansAddedManually(context);
        // basicDataTypesBeansAddedManually(context);
        // catBeansAddedProgrammatically(contextEmpty);
        // comicBookBeansOperations(contextComicBooks);
        // comicBookBeansOperations(contextComicBooksWithInventory);
        autowiredComicBookBeansOperations(contextWithAutowiredBooks);

    }

    /*
     * Initializing new parrot object using bean manually:
     * */
    static private void parrotBeansAddedManually(AnnotationConfigApplicationContext context) {
        Parrot rioBean = context.getBean("parrotOne", Parrot.class);
        System.out.println(rioBean.getName());

        Parrot parroterinioBean = context.getBean("parotte", Parrot.class);
        System.out.println(parroterinioBean.getName());
    }

    /*
     * Getting basic data types from context manually:
     * */
    static private void basicDataTypesBeansAddedManually(AnnotationConfigApplicationContext context){
        String caption = context.getBean("itsOverCaption", String.class);
        System.out.println(caption);

        Integer number = context.getBean("nineK", Integer.class);
        System.out.println(number);
    }

    /*
     * Adding programmatically instance of Cat to Empty Project Config context:
     * */
    static private void catBeansAddedProgrammatically(AnnotationConfigApplicationContext context) {
        var contextEmpty = new AnnotationConfigApplicationContext(ProjectConfigEmpty.class);
        Cat cat1 = new Cat();
        cat1.setName("Mimi");
        Supplier<Cat> catSupplier = () -> cat1;

        contextEmpty.registerBean("mimiCat", Cat.class, catSupplier);

        Cat mimi = contextEmpty.getBean(Cat.class);
        System.out.println(mimi.getName());
    }

    /*
    * Comic book store context, - Direct-wiring approach.
    * Creating parent->child beans:
    * Method can be used for contextComicBooksWithInventory and contextComicBooks.
    * */
    static private void comicBookBeansOperations(AnnotationConfigApplicationContext context) {
        ComicBookStore storeBean = context.getBean(ComicBookStore.class);
        System.out.println(storeBean);
        System.out.println(storeBean.getComicBook());
    }

    /*
    * Get autowired comic book class:
    * */
    static private void autowiredComicBookBeansOperations(AnnotationConfigApplicationContext context) {
        AutowiredComicBookStore storeBean = context.getBean(AutowiredComicBookStore.class);
        storeBean.setName("Autowired store");
        storeBean.getComicBook().setName("Autowired comic book vol.3");
        System.out.println(storeBean);
        System.out.println(storeBean.getComicBook());
    }
}
