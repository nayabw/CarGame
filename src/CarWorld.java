import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.*;
public class CarWorld extends World
{
    private int counter = 60;
    Car c = new Car();
    private int dodged = 0;
    public CarWorld()  //Constructor
    {    
        super(600, 600, 1);
        setPaintOrder (Car.class, Traffic.class, Line.class);
    }

    public void started(){
        addObject(c,305,550);
        setBackground("roadBack.png");
        Medic m = new Medic();
        addObject(m, 0, 0);
        m.getImage().setTransparency(0);
    }

    public void act() //This method runs on an infinite loop
    {
        if(!c.hasCrashed()){
            if (getObjects(Traffic.class).size() < 4 && Greenfoot.getRandomNumber(100) < 3)
            {
                switch(Greenfoot.getRandomNumber(2)){
                    case 0:
                    addObject(new Traffic(), Greenfoot.getRandomNumber(95) + 200, 0); //200 - 295, 305 - 400
                    break;
                    case 1:
                    addObject(new Traffic(), Greenfoot.getRandomNumber(95) + 305, 0); //200 - 295, 305 - 400
                    break; 
                }
            }
            if (getObjects(Tree.class).size() < 2 && Greenfoot.getRandomNumber(100) < 2)
            {
                switch(Greenfoot.getRandomNumber(2)){
                    case 0:
                    addObject(new Tree(), Greenfoot.getRandomNumber(180), 0);
                    break;
                    case 1:
                    addObject(new Tree(), Greenfoot.getRandomNumber(205)+430, 0);
                    break; 
                }
            }
            counter++;
            if(counter >= 60){
                addObject(new Line(), 300, 0);
                addObject(new Line(), 300, 120);
                counter = 0;
            }
        }
    }

    public void endScreen(){
        removeObjects(getObjects(Medic.class));
        removeObjects(getObjects(Car.class));
        setBackground("endSplash.png");
        Greenfoot.stop();
    }

    public void addScore(){
        dodged++;
        showText("Cars Dodged: " + dodged, 90, 590);
    }
}
