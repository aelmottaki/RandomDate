
package Controle;

import Model.Model;
import Model.Try;
import Vue.Resultat;
import java.awt.Color;
import observer.Observable;
import observer.Observer;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author EL MOTTAKI
 */
public class Controler implements Observable {
    int ddebut,dfin;
    int day,month,year;
    Model model;
    java.util.ArrayList<Observer> observer = new ArrayList<Observer>();
    @SuppressWarnings("empty-statement")
    public Controler()
    {
       
        model = new Model();
       
    }
    public void debut()
    {
        this.OJours();
        this.BOption();
        int date[] = model.generateDate(ddebut, dfin);
        this.update(""+date[0]+"-"+date[1]+"-"+date[2]);
        day=date[0];
        month = date[1];
        year = date[2];
        
    }
    public void fin()
    {
        this.OOption();
        this.BJours();
        this.update("Random Date");
        this.affiche_resultat();
        model.resetSession();
    }
    public void clickDay(int d)
    {
        Thread t;
        boolean resultat = model.archive(day,month,year,d);
        if(resultat)
            t = new Thread(new Play(Color.GREEN));
        else
            t = new Thread(new Play(Color.red));
        t.start();
        int date[] = model.generateDate(ddebut, dfin);
        this.update(""+date[0]+"-"+date[1]+"-"+date[2]);
        day=date[0];
        month = date[1];
        year = date[2];
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

    @Override
    public void refreche(Color c) {
       for(Observer obs:observer)
       {
           obs.refreche(c);
       } 
    }

    @Override
    public void next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    class Play implements Runnable{
        Color c;
        public Play(Color c)
        {
            this.c = c;
        }
        @Override
        public void run() {
            try {
                refreche(c);
            } catch (Exception ex) {
              
            }
      }}
    public void affiche_resultat()
    {
        new Resultat(new JFrame(),true,model.getSession(),model.getNumberAll(),model.getNumberTrue()).setVisible(true);
    }
}
