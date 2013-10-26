
package Controle;

import Model.Model;
import observer.Observable;
import observer.Observer;
import java.util.ArrayList;

/**
 *
 * @author EL MOTTAKI
 */
public class Controler implements Observable {
    int ddebut,dfin;
    int day,month,year;
    Model model;
    java.util.ArrayList<Observer> observer = new ArrayList<Observer>();
    public Controler()
    {
        model = new Model();
    }
    public void debut()
    {
        this.OJours();
        this.BOption();
        int date[] = model.generateDate(ddebut, dfin);
        this.update(""+date[0]+"-"+date[1]+"-"+date[1]);
    }
    public void fin()
    {
        this.OOption();
        this.BJours();
        this.update("");
    }
    public void clickDay(int d)
    {
        
    }
    public void setDD(int ddebut)
    {
        this.ddebut=ddebut;
        
        
    }
    public void setDF(int dfin)
    {
        this.dfin=dfin;
    }

    @Override
    public void addObserver(Observer obs) {
       observer.add(obs);
    }

    @Override
    public void removeObserver() {
       observer = new ArrayList<Observer>();
    }

    @Override
    public void update(String str) {
       for(Observer obs:observer)
       {
           obs.update(str);
       }
    }

    @Override
    public void BOption() {
        for(Observer obs:observer)
       {
           obs.BOption();
       }       
    }

    @Override
    public void OOption() {
        for(Observer obs:observer)
       {
           obs.OOption();
       }       
    }

    @Override
    public void BJours() {
        for(Observer obs:observer)
       {
           obs.BJours();
       }       
    }

    @Override
    public void OJours() {
       for(Observer obs:observer)
       {
           obs.OJours();
       } 
    }

}
