package com.luiz;

import com.luiz.actions.client.cli.ProductCLI;
import com.luiz.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

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
        String command = scanner.nextLine();
        final ProductCLI productCLI = context.getBean(ProductCLI.class);
        while(!command.equals("exit")) {
            command = scanner.next();
            switch (command) {
                case "1" :
                    productCLI.add(randomName(), randomPrice());
                    buildMenu();
                    break;
                case "2" :
                    final List<Product> products = productCLI.findAll();
                    System.out.println("products = " + products);
                    buildMenu();
                    break;
                case "exit":
                    System.out.println("Bye bye");
                    break;
            }
            System.out.println(command);
        }
    }

    private String randomPrice() {
        return Arrays.asList(1,2,3,4,5,6,7,8,9,10)
                .get(new Random().nextInt(10))
                .toString();
    }

    private String randomName() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    private void buildMenu() {
        System.out.println("******** CLI MENU ********");
        System.out.println("1 - Create a random product");
        System.out.println("2 - Print all products");
        System.out.println("exit - stop CLI");
        System.out.println("*************************");
    }
}

