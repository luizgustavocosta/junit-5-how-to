package com.luiz;

import com.luiz.actions.client.ProductCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

/**
 * The type App command line.
 */
@Component
public class AppCommandLine implements CommandLineRunner {

    /**
     * The Context.
     */
    @Autowired
    ApplicationContext context;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        buildMenu();
        String command = "";
        final ProductCLI productCLI = context.getBean(ProductCLI.class);
        while (!command.equals("exit")) {
            command = scanner.next();
            switch (command) {
                case "1":
                    productCLI.add(randomName(), randomPrice());
                    buildMenu();
                    break;
                case "2":
                    productCLI.findAll().forEach(System.out::println);
                    buildMenu();
                    break;
                case "exit":
                    System.out.println("Bye bye");
                    break;
            }
        }
    }

    /**
     * Random price string.
     *
     * @return the string
     */
    String randomPrice() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .get(new Random().nextInt(10))
                .toString();
    }

    /**
     * Random name string.
     *
     * @return the string
     */
    private String randomName() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    /**
     * Build menu.
     */
    private void buildMenu() {
        System.out.println("******** CLI MENU **************");
        System.out.println("* 1 - Create a random product  *");
        System.out.println("* 2 - Print all products       *");
        System.out.println("* exit - Turn off CLI MENU     *");
        System.out.println("********************************");
    }
}

