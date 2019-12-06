package jp.cafebabe.extide;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameContainer extends NameComponent {
    private List<NameComponent> components;

    public NameContainer(Name name, Type type, Stream<NameComponent> stream) {
        super(name, type);
        components = stream.collect(Collectors.toList());
    }

    public Stream<NameComponent> stream() {
        return components.stream();
    }

    public String toString() {
        return String.format("{\"name\":\"%s\",\"type\":\"%s\",\"children\":[%s]}", 
                name(), type(), stream().map(item -> item.toString())
                .collect(Collectors.joining(",")));
    }
}
