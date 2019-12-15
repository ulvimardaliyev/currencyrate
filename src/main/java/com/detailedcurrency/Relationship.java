package com.detailedcurrency;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

public class Relationship {

    private static ParseJsonResult parsing;
    private static String money1;
    private static String money2;
    private static BigDecimal result = new BigDecimal(0);
    private BigDecimal m1;
    private BigDecimal m2;

    public Relationship() {
    }

    public Relationship(ParseJsonResult parseJsonResult, String money1, String money2) {
        Relationship.parsing = parseJsonResult;
        Relationship.money1 = money1;
        Relationship.money2 = money2;
    }


    public Relationship(BigDecimal value1, BigDecimal value2) {
        this.m1 = value1;
        this.m2 = value2;
    }

    public Relationship parsingg() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BigDecimal value1 = new BigDecimal(0);
        BigDecimal value2 = new BigDecimal(0);

        try {
            System.out.println("inside try catch block");
            ParseJsonResult parseJsonResult = objectMapper.readValue(parsing.getJson(), ParseJsonResult.class);

            if (parseJsonResult.getRates().containsKey("USD" + money1)) {
                System.out.println("Inside If");
                BigDecimal valueOne = parseJsonResult.getRates().get("USD" + money1); //5.808204 TRY

                //indi biz 2-ci pulu USD-e cevirib muqayise etmek isteyirik
                //misalcun biz TRY-ni EUR-le muqayise etmek isteyirik
                //TRY-ni EUR-le muqayise etmek ucun 1 TRY-nin nece USD olmasini tapmaliyiq
                value1 = value1.add(new BigDecimal(1).divide(valueOne, 4, BigDecimal.ROUND_HALF_UP));//1 TRY == 0.17217 USD
                //indi tenasub qurmaq lazimdir ki, 1 EUR nece USD-dir
                // 1 USD -- 0.899281 EUR
                // X USD -- 1 EUR
                // X = 1.111999475 USD

                BigDecimal valueTwo = parseJsonResult.getRates().get("USD" + money2);//0.899281 EUR
                value2 = value2.add(new BigDecimal(1).divide(valueTwo, 4, BigDecimal.ROUND_HALF_UP));//1 EUR = 1.111999475 USD

                System.out.println("value1 is " + value1);
                System.out.println("value2 is " + value2);
                System.out.println("Divide is " + value1.divide(value2, 4));
            } else if (parseJsonResult.getRates().containsKey(money1)) {
                BigDecimal valueOne = parseJsonResult.getRates().get(money1); //5.808204 TRY
                value1 = value1.add(new BigDecimal(1).divide(valueOne, 4, BigDecimal.ROUND_HALF_UP));//1 TRY == 0.17217 USD
                BigDecimal valueTwo = parseJsonResult.getRates().get(money2);//0.899281 EUR
                value2 = value2.add(new BigDecimal(1).divide(valueTwo, 4, BigDecimal.ROUND_HALF_UP));//1 EUR = 1.111999475 USD

                System.out.println("value1 is " + value1);
                System.out.println("value2 is " + value2);
                System.out.println("Divide is " + value1.divide(value2, 4));
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new Relationship(value1, value2);
    }
}
/*
 * 1 USD = 0.899281 EUR
 * X = 1 EUR
 *
 * X = 1*1/0.899281 = 1.111999475 USD
 *
 * 1 USD = 1.7025 AZN
 * 1.112 USD (Yəni EURO) = Y
 * Y=1.7025*1.112 = 1.89318
 * */

/*
 * 1 USD  = 5.808204 TRY
 * X USD = 1 TRY
 * X= 1/5.808204=0.172170 USD
 *
 * 1 USD = 1.7025 AZN
 * 0.172170 USD = Y AZN
 * Y = 1.7025*0.172170
 * */