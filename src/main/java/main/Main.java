package main;

import config.ProjectConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

    }
}
