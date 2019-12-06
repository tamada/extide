package jp.cafebabe.extide.cli;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Arguments {
    private List<String> arguments;

    public Arguments(String[] args) {
        arguments = Arrays.stream(args)
            .collect(Collectors.toList());
    }

    public int perform(Function<Arguments, Integer> executor, IntSupplier helpPrinter) {
        if(isHelp())
            return helpPrinter.getAsInt();
        return executor.apply(this);
    }

    public boolean isHelp() {
        return arguments.stream()
            .filter(item -> item.equals("-h") || item.equals("--help"))
            .count() > 0;
    }

    public Stream<String> stream() {
        return arguments.stream()
            .filter(item -> !item.startsWith("-"));
    }
}
