package jp.cafebabe.extide.source;

import java.io.IOException;
import java.io.InputStream;

import jp.cafebabe.extide.Name;

public interface Entry {
    InputStream openStream() throws IOException;

    Name name();
}
