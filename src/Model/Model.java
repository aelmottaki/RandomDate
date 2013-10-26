package Model;

/**
 *
 * @author EL MOTTAKI
 */
public class Model {
    private int[] cmois = {7,4,3,7,5,2,7,4,1,6,3,1};
    static int startyear = 1900;static int yearend = 2100;
    /**
    * calculer le nombre C
    * @params int year
    */
    private int CNumber(int year)
    {
        int i,C,lastpatrolyear = startyear;
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
        int B,counter;
        int y;
        do{
            
        }
        while(this.isLeapYear(y))
        return B;
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
    
    
    /**
    * caluler le jour
    * @params int day,int month,int year
    */
    private int getDayNombre(int day,int month,int year)
    {
     
        return 0;
    }
    
    /**
    * générer un date aléatoire 
    * @params int minYear,int maxYear
    */
    static int[] generateDate(int minYear,int maxYear)
    {
        
        return null;
    }
    
    /**
    * sauvgarder les resultat d'une session
    * @params String date
    */
    static void archive(String date){
        
    }
    
    
}
