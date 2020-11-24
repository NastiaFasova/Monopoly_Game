package monopoly.equals_hashcode;

import lombok.Data;
import monopoly.NotRealBank;
import monopoly.PropertyCard;

@Data
public class ExamplesOfEqualsAndHashcode {

    public static void main(String[] args) {
        EqualsExamples equalsExamples = new EqualsExamples();
        HashcodeExamples hashcodeExamples = new HashcodeExamples();
        System.out.println("Examples with equals(): ");
        System.out.println(equalsExamples.nonOverriddenEquals(new NotRealBank(), new NotRealBank()));

        PropertyCard firstCard
                = new PropertyCard();
        PropertyCard secondCard
                = new PropertyCard();
        System.out.println(equalsExamples.overriddenEquals(firstCard, secondCard));

        System.out.println("Examples with hashcode(): ");
        System.out.println(hashcodeExamples.nonOverriddenHashOfTwoObjects(new NotRealBank(), new NotRealBank()));

        System.out.println(hashcodeExamples.overriddenHashcode(firstCard, secondCard));

    }

}
