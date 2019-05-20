import greenfoot.*;

public class Tree extends Actor
{
    public void act() 
    {
        setLocation(getX(), getY()+4);
        if (isTouching(Tree.class) || getY() >= getWorld().getHeight()-1) getWorld().removeObject(this);
    }    
}
