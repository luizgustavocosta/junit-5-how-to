package com.luiz.infrastructure.command;

/**
 * The interface Command.
 *
 * @param <R> the type parameter
 * @param <T> the type parameter
 */
public interface CommandAdapter<R, T> {

    /**
     * Execute r.
     *
     * @param command the command
     * @return the r
     */
    R execute(T command);

}
