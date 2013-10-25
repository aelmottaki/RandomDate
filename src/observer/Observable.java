/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author EL MOTTAKI
 */
public interface Observable {
   public void addObserver(Observer obs);
   public void removeObserver();
   public void notifyObserver(String str);
}
