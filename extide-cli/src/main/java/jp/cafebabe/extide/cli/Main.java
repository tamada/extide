package jp.cafebabe.extide.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jp.cafebabe.extide.NameContainer;

public class Main{
    public Main(String[] argArray) {
        final Arguments args = new Arguments(argArray);
        int statusCode = args.perform(arguments -> perform(arguments), () -> printHelp());
        System.exit(statusCode);
    }

    private List<NameContainer> performEach(Extide extide, String fileName) {
        return new ArrayList<>();
    }

    private int printResult(List<NameContainer> containers) {
        System.out.println(containers.stream()
                .map(container -> container.toString())
                .collect(Collectors.joining(",")));
        return 0;
    }

    private int perform(Arguments args) {
        Extide app = new Extide();
        return printResult(args.stream()
            .flatMap(fileName -> performEach(app, fileName).stream())
            .collect(Collectors.toList()));
    }

    private int printHelp() {
        System.out.println("extide [OPTIONS] <ARGUMENTS>");
        System.out.println("OPTIONS");
        System.out.println("    -h, --help      print this message.");
        System.out.println("ARGUMENTS");
        System.out.println("    java source files, class files, jar files, and/or directories.");
        return 0;
    }

    public static void main(String[] args) {
        new Main(args);
    }
}
