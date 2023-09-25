package main;

import animals.Cat;
import animals.Parrot;
import config.ProjectConfig;
import config.ProjectConfigEmpty;
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

//        parrotBeansAddedManually(context);
//        basicDataTypesBeansAddedManually(context);
//        catBeansAddedProgrammatically(contextEmpty);

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

}
