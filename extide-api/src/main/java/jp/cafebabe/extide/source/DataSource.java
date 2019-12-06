package jp.cafebabe.extide.source;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface DataSource extends AutoCloseable {
    Stream<Entry> stream() throws IOException;

    default void forEach(Consumer<Entry> consumer) throws IOException {
        stream().forEach(consumer);
    }

    default Stream<Entry> filter(Predicate<Entry> predicate) throws IOException {
        return stream().filter(predicate);
    }

    default <T> Stream<T> map(Function<Entry, ? extends T> mapper) throws IOException {
        return stream().map(mapper);
    }

    @Override
    void close() throws IOException;
}
