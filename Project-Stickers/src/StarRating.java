import javax.swing.*;

public class StarRating {

    public String generateStar(Double rating){
        double roundedValue = Math.round(rating);
        String star = "";

        for (int i = 0; i < 10; i++) {            
            if (i < roundedValue) {
                star+= " \u2B50\uFE0F";                
            } else {
                star += "  \u2606  ";
            }
        }
        return star;
    }
}
