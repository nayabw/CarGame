import greenfoot.*; import java.util.*;
public class Medic extends Actor
{
    private boolean drivingToCrash = false;

    public void act() 
    {
        Car c = (Car)getWorld().getObjects(Car.class).get(0);
        if(!isTouching(Car.class) && drivingToCrash){
            move(5);
        }else if (!drivingToCrash){
            //Do nothing
        }else{
            ((CarWorld)getWorld()).endScreen();
        }
    }

    public void goToCrash(){
        Car c = (Car)getWorld().getObjects(Car.class).get(0);
        setLocation(0, c.getY());
        getImage().setTransparency(255);
        Greenfoot.playSound("weewoo.wav");
        drivingToCrash = true;
    }
}
