package Model;

/**
 *
 * @author EL MOTTAKI
 */
import java.util.Random;

enum yearType{
   patrol,leap,normal,patrolandleap;
}

public class Model {
    private int[] cmois = {7,4,3,7,5,2,7,4,1,6,3,1};
    static int startyear = 1900;static int yearend = 2100;
    /**
    * calculer le nombre C
    * @params int year
    */
    private int CNumber(int year)
    {
        int i,lastpatrolyear = startyear;
        do{
            lastpatrolyear = lastpatrolyear + 28; 
        }while(year > lastpatrolyear);
        lastpatrolyear = lastpatrolyear - 28;
        int counter = 0;
        for(i=lastpatrolyear+1;i==year;i++){
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
    private int BNumber(int year)
    {
        int counter=0;
        int y = year;
        while(!this.isLeapYear(y)){
            counter++;
        }
        
        return counter;
    }  
    
    /**
    * verifie si une année est bissextile
    * @params int year
    */
    private boolean isLeapYear(int year)
    {
        boolean isleap= false;
        int rest;
        rest = year % 4;
        if (rest == 0) {
            isleap = true;
        }
        return isleap;
    }
    
    private boolean isPatrolYear(int year)
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
    private int getDayNombre(int day,int month,int year)
    {
        int j = day - cmois[month-1] - 2 * this.BNumber(year) + this.CNumber(year);
        return j;
    }
    
    /**
    * générer un date aléatoire 
    * @params int minYear,int maxYear
    */
    static int[] generateDate(int minyear,int maxyear)
    {
        yearType ytype;
        Random rnd = new Random();
        //generer une année aléatoire
        int year = minyear + rnd.nextInt(maxyear-minyear);
        //generer un mois aléatoire
        int month = rnd.nextInt(11) + 1;
        //generer un jour aléatoire
        int day = rnd.nextInt(30) + 1;
        int[] date = {day,month,year};
        return date;
    }
    
    /**
    * sauvgarder les resultat d'une session
    * @params String date
    */
    static void archive(String date){
        
    }
    
    
}
