package net.time4j.engine;

/* JADX INFO: loaded from: classes5.dex */
public interface Converter<S, T> {
    S from(T t);

    Class<S> getSourceType();

    T translate(S s);
}
