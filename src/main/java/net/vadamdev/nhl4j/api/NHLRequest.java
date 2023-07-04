package net.vadamdev.nhl4j.api;

import java.util.function.Consumer;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public interface NHLRequest<T> {
    void queue(Consumer<T> consumer);
    T complete();
}
