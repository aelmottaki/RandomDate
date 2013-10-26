package Model;

/**
 *
 * @author EL MOTTAKI
 */
import java.util.ArrayList;
import java.util.Random;

enum yearType{
   patrol,leap,normal,patrolandleap;
}

public class Model {
      int nbr_true=0;
      int nbr_all=0;
    public int[] cmois = {7,4,3,7,5,2,7,4,1,6,3,1};
     String tjours[] = {" ","Dimenche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
     int startyear = 1900; int yearend = 2100;
     ArrayList<Try> session = new ArrayList<Try>();
    /**
    * calculer le nombre C
    * @params int year
    */
    public int BNumber(int year)
    {
        int i,lastpatrolyear = startyear;
        do{
            lastpatrolyear = lastpatrolyear + 28; 
        }while(year > lastpatrolyear);
        lastpatrolyear = lastpatrolyear - 28;
        int counter = 0;
        for(i=lastpatrolyear+1;i<=year;i++){
            if(this.isLeapYear(i)){
                counter++;
            }
        }
        return counter;
    }
    
    /**
    * calculer le nombre B
    * @params int year
    */
    public int CNumber(int year,int month)
    {
        int counter=0;
        int y = year;
        while(!this.isLeapYear(y)){
            counter++;
            y--;
        }
        if(month==1 || month==2)
            counter++;
        return counter;
    }  
    
    /**
    * verifie si une année est bissextile
    * @params int year
    */
    public boolean isLeapYear(int year)
    {
        boolean isleap= false;
        int rest;
        rest = year % 4;
        if (rest == 0) {
            isleap = true;
        }
        return isleap;
    }
    
    public boolean isPatrolYear(int year)
    {
        boolean ispatrol = false;
        int diff = year - startyear;
        if(diff % 28 == 0)
        {
            ispatrol = true;
        }
        return ispatrol;
    }
    
    /**
    * caluler le jour
    * @params int day,int month,int year
    */
    public int getDayNombre(int day,int month,int year)
    {
        int j = day - cmois[month-1] - 2 * this.BNumber(year) + this.CNumber(year,month);
        while(j>7 || j<1)
        {
            if(j>7)
                j-=7;
            else
                j+=7;
        }
        return j;
    }
    
    /**
    * générer un date aléatoire 
    * @params int minYear,int maxYear
    */
    public int[] generateDate(int minyear,int maxyear)
    {
        int jyear[]={-1,31,28,31,30,31,30,31,31,30,31,30,31};
        yearType ytype;
        Random rnd = new Random();
        //generer une année aléatoire
        int year = minyear + rnd.nextInt(maxyear-minyear+1);
        
        // si l'année est bissexitte
        if(this.isPatrolYear(year))
                jyear[2]++;
        //generer un mois aléatoire
        int month = rnd.nextInt(12) + 1;
        //generer un jour aléatoire
        int day = rnd.nextInt(jyear[month]) + 1;
        int[] date = {day,month,year};
        return date;
    }
    
    /**
    * sauvgarder les resultat d'une session
    * @params String date
    */
     public boolean archive(int day,int month,int year,int n){
         Try tr = new Try(""+day+"-"+month+"-"+year,tjours[n],tjours[this.getDayNombre(day, month, year)]);
         if((n==this.getDayNombre(day, month, year)))
         {
             nbr_all++;
             nbr_true++;
               session.add(tr);
              return true;
         }
         else
         {
             nbr_all++;
            session.add(tr);
             return false;
         }
        
        
    }
     public void resetSession()
     {
         session = new ArrayList<Try>();
     }
     public ArrayList<Try> getSession()
     {
         return session;
     }
      public int getNumberTrue()
    {
        return nbr_true;
    }
    public int getNumberAll()
    {
        return nbr_all;
    }

    
}