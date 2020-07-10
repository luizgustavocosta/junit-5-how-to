package com.luiz.infrastructure.query;

import com.luiz.actions.products.ClientQuery;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Query handler.
 */
@Component
public class QueryHandler {

    @Autowired
    private final ApplicationContext context;

    private Set<Class<Query>> queries = new HashSet<>();

    /**
     * Instantiates a new Query handler.
     *
     * @param context the context
     */
    public QueryHandler(ApplicationContext context) {
        Reflections reflections = new Reflections("com.luiz");
        for (Class clazz : reflections.getTypesAnnotatedWith(Query.class)) {
            queries.add(clazz);
        }
        this.context = context;
    }

    /**
     * Execute object.
     *
     * @param query the query
     * @return the object
     */
    public Object execute(ClientQuery query) {
        for (Class<Query> commandHandlerClass : queries) {
            for (AnnotatedType annotatedInterface : commandHandlerClass.getAnnotatedInterfaces()) {
                if (annotatedInterface.getType().getTypeName().split("<*, ")[1].replace(">","")
                        .equals(query.getClass().getName())) {
                    try {
                        final Method execute = commandHandlerClass.getDeclaredMethod("execute", query.getClass());
                        return execute.invoke(context.getBean(commandHandlerClass), query);
                    } catch (Exception exception) {
                        throw new IllegalStateException(exception);
                    }
                }
            }
        }
        return null;
    }
}
