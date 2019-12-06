package jp.cafebabe.extide;

import java.nio.file.Path;
import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public boolean equals(Object other) {
        return other instanceof Name
                && Objects.equals(name, ((Name) other).name);
    }

    @Override
    public String toString() {
        return name;
    }

    public static final Name of(String name) {
        return new Name(name);
    }

    public static final Name of(Path path) {
        return of(path.getFileName().toString());
    }
}
