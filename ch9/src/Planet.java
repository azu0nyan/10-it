import ru.tutorial.other.V2;

import java.awt.*;

public class Planet {
    Planet parent = null;
    double radius = 10;
    double speed = 1;

    V2 pos = new V2(0, 0);


    void update(double dt) {
        pos = pos.rotate(dt * speed);
    }

    void drawMe(Graphics2D g){

    }

    V2 myPos(){
        return null;
    }

}
