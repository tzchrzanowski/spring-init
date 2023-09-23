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
        Parrot rioBean = context.getBean(Parrot.class);
        System.out.println(rioBean.getName());
    }
}
