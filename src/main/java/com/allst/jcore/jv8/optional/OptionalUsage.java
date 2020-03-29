package com.allst.jcore.jv8.optional;

import java.util.Optional;

/**
 * 创建optional的方式
 *
 * @author YiYa
 * @since 2020-03-30 上午 12:01
 */
public class OptionalUsage {

    public static void main(String[] args) {
        // methods1
        Optional<Insurance> insuranceOptional = Optional.empty();
        Optional<String> nameOptional = insuranceOptional.map(i -> i.getName());
        System.out.println(nameOptional.orElse("Empty Value ~"));

        System.out.println(nameOptional.isPresent());

        // methods2
        Optional<Insurance> insuranceOptional1 = Optional.of(new Insurance());
        insuranceOptional1.get();
        Insurance insurance = insuranceOptional1.filter(i -> i.getName() == null).get();
        System.out.println(insurance);

        // methods3
        /*Optional<Insurance> insuranceOptional2 = Optional.ofNullable(null);
        insuranceOptional2.orElseGet(Insurance::new);

        insuranceOptional2.orElse(new Insurance());

        insuranceOptional2.orElseThrow(RuntimeException::new);

        insuranceOptional2.orElseThrow(() -> new RuntimeException("no have reference~~~"));*/


        //
        System.out.println(getInsuranceName(null));
        System.out.println(getInsuranceByOptional(null));
    }

    private static String getInsuranceName(Insurance insurance) {
        if (null == insurance) {
            return "unknown~~~";
        }
        return insurance.getName();
    }

    private static String getInsuranceByOptional(Insurance insurance) {
        return Optional.ofNullable(insurance).map(Insurance::getName).orElse("UnknownError");
    }

}
