package jp.cafebabe.extide.source;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class DirectoryDataSource implements DataSource {
    private Path basePath;

    public DirectoryDataSource(Path basePath) {
        this.basePath = basePath;
    }

    @Override
    public Stream<Entry> stream() throws IOException {
        return Files.walk(basePath)
                .filter(path -> Files.isRegularFile(path))
                .map(path -> new RegularFileEntry(path));
    }

    @Override
    public void close() throws IOException {
        // do nothing.
    }
}
