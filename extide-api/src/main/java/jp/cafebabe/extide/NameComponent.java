package jp.cafebabe.extide;

public class NameComponent {
    private Type type;
    private Name name;

    public static NameComponent of(Name name, Type type) {
        return new NameComponent(name, type);
    }

    NameComponent(Name name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Type type() {
        return type;
    }

    public Name name() {
        return name;
    }
}
