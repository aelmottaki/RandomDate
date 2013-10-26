
package Model;

/**
 *
 * @author EL MOTTAKI
 */
public class Try {
    String date,day_reponse,day_true;  
    public Try(String date,String day_reponse,String day_true)
    {
        this.date = date;
        this.day_reponse = day_reponse;
        this.day_true = day_reponse;
    }
    public String getDate()
    {
        return this.date;
    }
    public String getRDay()
    {
        return this.day_reponse;
    }
    public String getTDay()
    {
        return this.day_true;
    }
}
