package net.vadamdev.nhl4j.internal;

import net.vadamdev.nhl4j.api.NHLRequest;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public class NHLRequestImpl<T> implements NHLRequest<T> {
    private final Supplier<T> request;

    public NHLRequestImpl(Supplier<T> request) {
        this.request = request;
    }

    @Override
    public void queue(Consumer<T> consumer) {
        CompletableFuture.runAsync(() -> consumer.accept(request.get()));
    }

    @Override
    public T complete() {
        return request.get();
    }
}
