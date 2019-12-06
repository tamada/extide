package jp.cafebabe.extide.source;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class RegularFileDataSource implements DataSource {
    private Path target;

    public RegularFileDataSource(Path target) {
        this.target = target;
    }

    @Override
    public Stream<Entry> stream() throws IOException {
        return Stream.of(new RegularFileEntry(target));
    }

    @Override
    public void close() throws IOException {
        // do nothing.
    }
}
