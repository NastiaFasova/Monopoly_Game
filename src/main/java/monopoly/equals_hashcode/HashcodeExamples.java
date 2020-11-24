package monopoly.equals_hashcode;

import monopoly.Card;
import monopoly.Nominal;
import monopoly.NotRealBank;

public class HashcodeExamples {

    public boolean nonOverriddenHashOfTwoObjects(NotRealBank firstBank, NotRealBank secondBank) {
        firstBank.addBanknotes(Nominal.TEN, 2);
        secondBank.addBanknotes(Nominal.TEN, 2);
        int firstCode = firstBank.hashCode();
        int secondCode = secondBank.hashCode();
        System.out.println("\nFirstBank: " + firstBank);
        System.out.println("SecondBank: " + secondBank);
        System.out.println("Непереопределенный метод hashcode() класса NotRealBank: "
                + "\nГенерация хэша для первого объекта "+ firstCode
                + "\nГенерация хэша для второго такого же объекта: " + secondCode);
        System.out.println("Равны хэши? ");
        return firstCode == secondCode;
    }

    public boolean overriddenHashcode(Card firstCard, Card secondCard) {
        System.out.println("\nFirstCard: " + firstCard);
        System.out.println("SecondCard: " + secondCard);
        int num1 = firstCard.hashCode();
        int num2 = secondCard.hashCode();
        return num1 == num2;
    }
}
