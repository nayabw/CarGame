import greenfoot.*;
public class Car extends Actor
{
    private boolean hasCrashed = false;

    public void act()
    {
        if(!hasCrashed){
            if (getX() == 197 || Greenfoot.isKeyDown("right")) setLocation(getX() + 2, getY());
            if (getX() == 415 || Greenfoot.isKeyDown("left"))setLocation(getX() - 2, getY());
            if (Greenfoot.isKeyDown("up")) setLocation(getX(), getY()-2);
            if (Greenfoot.isKeyDown("down")) setLocation(getX(), getY()+2);
            checkCollision();  
        }
    }

    public void checkCollision()
    {
        Actor collided = getOneIntersectingObject(Traffic.class);
        if (collided != null)
        {
            Medic m = (Medic)getWorld().getObjects(Medic.class).get(0);
            Greenfoot.playSound("crash.wav"); //play a crash sound
            getWorld().setBackground("black.png");
            hasCrashed = true;
            getWorld().removeObjects(getWorld().getObjects(Traffic.class));
            getWorld().removeObjects(getWorld().getObjects(Line.class));
            getWorld().removeObjects(getWorld().getObjects(Tree.class));
            m.goToCrash();
        }
    }

    public boolean hasCrashed(){
        return hasCrashed;
    }
}
