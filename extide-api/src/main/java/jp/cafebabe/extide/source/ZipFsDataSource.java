package jp.cafebabe.extide.source;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jp.cafebabe.extide.Name;
import jp.cafebabe.traverser.TraverserBuilder;

public class ZipFsDataSource implements DataSource {
    private Path path;
    private FileSystem fileSystem;

    public ZipFsDataSource(Path path) {
        this.path = path;
        if(!Files.isRegularFile(path)) {
            throw new IllegalArgumentException("given path is not regular file");
        }
    }

    public Stream<Entry> stream() throws IOException {
        fileSystem = loadFileSystem(path);
        return loadFiles(fileSystem);
    }

    private Stream<Entry> loadFiles(FileSystem fileSystem){
        TraverserBuilder builder = new TraverserBuilder();
        Stream<Path> stream = StreamSupport.stream(fileSystem.getRootDirectories().spliterator(), false)
                .flatMap(path -> toStream(path, builder));
        return stream.map(path -> new ZipFsEntry(fileSystem.provider(), path));
    }

    private Stream<Path> toStream(Path path, TraverserBuilder builder) {
        try {
            return builder.build(path).stream();
        } catch (IOException e) {
            throw new InternalError(e);
        }
    }
    
    private FileSystem loadFileSystem(Path path) throws IOException {
        ClassLoader loader = getClass().getClassLoader();
        return FileSystems.newFileSystem(path, loader);
    }

    private static class ZipFsEntry implements Entry {
        private FileSystemProvider provider;
        private Path path;

        public ZipFsEntry(FileSystemProvider provider, Path path) {
            this.provider = provider;
            this.path = path;
        }

        @Override
        public InputStream openStream() throws IOException {
            return provider.newInputStream(path);
        }

        @Override
        public Name name() {
            return Name.of(path);
        }
    }

    @Override
    public void close() throws IOException {
        if(fileSystem != null)
            fileSystem.close();
    }
}
