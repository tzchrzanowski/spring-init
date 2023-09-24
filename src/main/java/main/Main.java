package main;

import config.ProjectConfig;
import config.ProjectConfigEmpty;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        /*
        * Initialize spring context:
        * */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        /*
        * Initializing new parrot object using bean:
        * */
        Parrot rioBean = context.getBean("parrotOne", Parrot.class);
        System.out.println(rioBean.getName());

        Parrot parroterinioBean = context.getBean("parotte", Parrot.class);
        System.out.println(parroterinioBean.getName());

        /*
        * Getting basic data types from context:
        * */
        String caption = context.getBean("itsOverCaption", String.class);
        System.out.println(caption);

        Integer number = context.getBean("nineK", Integer.class);
        System.out.println(number);

        /*
        * Adding prgramatically instance of Cat to Empty Project Config context:
        * */

        var contextEmpty = new AnnotationConfigApplicationContext(ProjectConfigEmpty.class);
        Cat cat1 = new Cat();
        cat1.setName("Mimi");
        Supplier<Cat> catSupplier = () -> cat1;

        context.registerBean("mimiCat", Cat.class, catSupplier);

        Cat mimi = context.getBean(Cat.class);
        System.out.println(mimi.getName());
    }
}
