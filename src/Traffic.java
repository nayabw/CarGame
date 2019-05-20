import greenfoot.*;

public class Traffic extends Actor
{
    public void act() 
    {
        setLocation(getX(), getY()+3);
        if (isTouching(Traffic.class) || getY() >= getWorld().getHeight()-1){
            if(getY() >= getWorld().getHeight()-1) ((CarWorld)getWorld()).addScore();
            getWorld().removeObject(this);
        }
    }
}
