package com.allst.jcore.jv8.stream0;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 自定义Stream
 *
 * @author YiYa
 * @since 2020-03-28 下午 03:44
 */
public class CreateStream {

    public static void main(String[] args) {
        /*createStreamFromCollection().forEach(System.out::println);
        createStreamFromValues().forEach(System.out::println);
        createStreamFromArrays().forEach(System.out::println);*/

        /*Stream<String> stringStream = createStreamFromFile();
        System.out.println(stringStream);*/

        // createStreamFromIterator().forEach(System.out::println);

        // createSrtreamFromGenerate().forEach(System.out::println);

        createObjStreamFromGenerate().forEach(System.out::println);


    }

    /**
     * 自定义从Collection创建Stream
     * Generate the stream object from collection
     */
    private static Stream<String> createStreamFromCollection() {
        List<String> list = Arrays.asList("Hello", "Hi", "Java", "JavaScript");
        return list.stream();
    }

    /**
     * Generate the stream object from values
     */
    private static Stream<String> createStreamFromValues() {
        return Stream.of("Hello", "Hi", "Java", "JavaScript");
    }

    /**
     * Generate the stream object from arrays
     */
    private static Stream<String> createStreamFromArrays() {
        return Arrays.stream(new String[]{"Hello", "Hi", "Java", "JavaScript"});
    }

    /**
     * Generate the stream object from file
     */
    private static Stream<String> createStreamFromFile() {
        Path path = Paths.get("E:\\TestData\\test\\hadoop.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generate the stream object from iterator
     */
    private static Stream<Integer> createStreamFromIterator() {
        Stream<Integer> integerStream = Stream.iterate(1, a -> a * 2);
        return integerStream.limit(7);
    }

    /**
     * Generate the stream object from generate
     */
    private static Stream<Double> createSrtreamFromGenerate() {
        return Stream.generate(Math::random).limit(7);
    }

    private static Stream<Obj> createObjStreamFromGenerate() {
        return Stream.generate(new ObjSupplier()).limit(7);
    }


    static class ObjSupplier implements Supplier<Obj> {

        private int index = 0;

        private final Random random = new Random(System.currentTimeMillis());


        @Override
        public Obj get() {
            index = random.nextInt(100);
            return new Obj(index, "Name -> " + index);
        }
    }


    static class Obj {
        private int id;
        private String name;

        private Obj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
