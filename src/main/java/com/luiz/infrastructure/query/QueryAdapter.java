package com.luiz.infrastructure.query;

/**
 * The interface Query adapter.
 *
 * @param <R> the type parameter
 * @param <T> the type parameter
 */
public interface QueryAdapter<R, T> {

    /**
     * Execute r.
     *
     * @param command the command
     * @return the r
     */
    R execute(T command);

}
