package monopoly;

import lombok.Data;

@Data
public abstract class Card implements Printable {
    protected String title;
    private String description;
    private String effect;

    public Card() {
    }

    public Card(String t, String d, String e) {
        title = t;
        description = d;
        effect = e;
    }

    public String printInfo() {
        return "Some info about the card";
    }

    public String action() {
        return "Some action the card does";
    }


}
