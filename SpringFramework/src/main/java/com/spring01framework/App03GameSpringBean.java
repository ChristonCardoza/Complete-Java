package com.spring01framework;

import com.spring01framework.game.GameRunner;
import com.spring01framework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//public class App03GameSpringBean {
//
//    public static void main(String[] args) {
//
//        try( var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
//
//            context.getBean(GamingConsole.class).up();
//
//            context.getBean((GameRunner.class)).run();
//        }
//    }
//}

/* Making Client class itself as config */
//@Configuration
//public class App03GameSpringBean {
//
//    @Bean
//    public GamingConsole game() {
//        var game = new PacmanGame();
//        return game;
//    }
//
//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }
//    public static void main(String[] args) {
//
//        try( var context = new AnnotationConfigApplicationContext(App03GameSpringBean.class)){
//
//            context.getBean(GamingConsole.class).up();
//
//            context.getBean((GameRunner.class)).run();
//        }
//    }
//}

/* Avoiding @Bean and new keyword in config by add @Component on POJOs and @ComponentScan on config/client */
@Configuration
@ComponentScan("com.spring01framework.game")
public class App03GameSpringBean {

    public static void main(String[] args) {

        try( var context = new AnnotationConfigApplicationContext(App03GameSpringBean.class)){

            context.getBean(GamingConsole.class).up();

            context.getBean((GameRunner.class)).run();
        }
    }
}
