package com.luiz.infrastructure.command;

import com.luiz.actions.products.ClientCommand;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Command handler.
 */
@Component
public class CommandHandler {

    @Autowired
    private final ApplicationContext context;

    private Set<Class<CommandAdapter>> commands = new HashSet<>();

    /**
     * Instantiates a new Command handler.
     *
     * @param context the context
     */
    public CommandHandler(ApplicationContext context) {
        Reflections reflections = new Reflections("com.luiz");
        for (Class clazz : reflections.getTypesAnnotatedWith(Command.class)) {
            commands.add(clazz);
        }
        this.context = context;
    }

    /**
     * Execute object.
     *
     * @param command the command
     * @return the object
     */
    public Object execute(ClientCommand command) {
        // FIXME - Extract to a common class
        for (Class<CommandAdapter> commandHandlerClass : commands) {
            for (AnnotatedType annotatedInterface : commandHandlerClass.getAnnotatedInterfaces()) {
                if (annotatedInterface.getType().getTypeName().split("<*, ")[1].replace(">", "")
                        .equals(command.getClass().getName())) {
                    try {
                        final Method execute = commandHandlerClass.getDeclaredMethod("execute", command.getClass());
                        return execute.invoke(context.getBean(commandHandlerClass), command);
                    } catch (Exception exception) {
                        throw new IllegalStateException(exception);
                    }
                }
            }
        }
        return null;
    }
}
