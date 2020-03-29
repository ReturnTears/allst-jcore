package com.allst.jcore.jv8.stream0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author YiYa
 * @since 2020-03-29 下午 10:40
 */
public class StreamInAction {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> collect = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");

        transactions.stream().map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        transactions.stream().map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        String name = transactions.stream().map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(name);

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        boolean liveMl1 = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        boolean liveMl2 = transactions.stream().map(Transaction::getTrader).anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.printf("%b, %b \n", liveMl1, liveMl2);

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Integer a = transactions.stream().map(Transaction::getValue).reduce(Integer::max).get();
        Integer b = transactions.stream().map(Transaction::getValue).reduce(0, (i, j) -> i > j ? i : j);
        Optional<Integer> c = transactions.stream().map(Transaction::getValue).reduce((i, j) -> i > j ? i : j);
        System.out.printf("%d, %d, %d \n", a, b, c.get());

        System.out.println("🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎");
        Optional<Integer> mina = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
        Integer minb = transactions.stream().map(Transaction::getValue).reduce(0, (i, j) -> i < j ? i : j);
        Optional<Integer> minc = transactions.stream().map(Transaction::getValue).reduce((i, j) -> i < j ? i : j);
        System.out.printf("%d, %d, %d \n", mina.get(), minb, c.get());
    }

}
