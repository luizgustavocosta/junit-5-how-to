package com.luiz.query;

public interface Query<P, R> {

    R execute(P parameters);
}
