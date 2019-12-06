package jp.cafebabe.extide.source;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import jp.cafebabe.extide.Name;

class RegularFileEntry implements Entry {
    private Path path;

    public RegularFileEntry(Path path) {
        this.path = path;
    }

    @Override
    public InputStream openStream() throws IOException {
        return Files.newInputStream(path);
    }

    @Override
    public Name name() {
        return Name.of(path.getFileName());
    }
    
}