/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.awt.Color;

/**
 *
 * @author EL MOTTAKI
 */
public interface Observer {
   public void update(String str);
   public void BOption();
   public void OOption();
   public void BJours();
   public void OJours();
   public void refreche(Color c);
   public void next();
}
