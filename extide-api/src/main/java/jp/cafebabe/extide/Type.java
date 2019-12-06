package jp.cafebabe.extide;

public interface Type {
    boolean isContainer();

    String name();

    static interface Component extends Type {
        default boolean isContainer() {
            return false;
        }
    }
    
    static interface Container extends Type {
        default boolean isContainer() {
            return true;
        }
    }
}
