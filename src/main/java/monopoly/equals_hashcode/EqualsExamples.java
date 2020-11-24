package monopoly.equals_hashcode;

import monopoly.Card;
import monopoly.Nominal;
import monopoly.NotRealBank;

public class EqualsExamples {
    /*Викликаємо перевизначений метод equals() класу
       Tower. В результаті функція повертає true,
   оскільки методи перевизначені і об'єкти і рівними*/
    public boolean overriddenEquals(Card firstCard, Card secondCard) {
        System.out.println("\nFirstCard: " + firstCard);
        System.out.println("SecondCard: " + secondCard);
        System.out.println("Объекты равны? ");
        return firstCard.equals(secondCard);
    }

    /*Викликаємо неперевизначений метод equals() класу
       Person. В результаті функція повертає false,
    оскільки методи неперевизначені. Неперевизначений метод поверне
    true лише в тому випадку, якщо один об'єкт буде мати те ж посилання,
    що й інший(саме так порівнює об'єкти неперевизначений метод equals())*/
    public boolean nonOverriddenEquals(NotRealBank firstBank, NotRealBank secondBank) {
        firstBank.addBanknotes(Nominal.TEN, 2);
        secondBank.addBanknotes(Nominal.TEN, 2);
        System.out.println("\nFirstBank: " + firstBank);
        System.out.println("SecondBank: " + secondBank);
        System.out.println("Объекты равны? ");
        return firstBank.equals(secondBank);
    }
}
