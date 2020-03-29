package com.allst.jcore.jv8.optional;


/**
 * @author YiYa
 * @since 2020-03-29 下午 11:51
 */
public class NullPointerExecption {

    public static void main(String[] args) {
        String insuranceName = getInsuranceName(new Person());

        String result = getInsuranceNameByDeepdoubts(new Person());
        System.out.println(result);
    }

    private static String getInsuranceNameByDeepdoubts(Person person) {
        if (null != person) {
            Car car = person.getCar();
            if (null != car) {
                Insurance insurance = car.getInsurance();
                if (null != insurance) {
                    return insurance.getName();
                }
            }
        }
        return "UNKNOWN~~~";
    }


    private static String getInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }
}
