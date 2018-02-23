import java.util.Date;

public class Fever{
    private final float temperature;
    private final Date notedTime;
    private final boolean fever;
    public Fever(float temperature, Date notedTime, boolean fever){
        this.temperature = temperature;
        this.notedTime = notedTime;
        this.fever = fever;
    }
    public float getTemperature(){
        return temperature;
    }
    public Date getNotedTime(){
        return notedTime;
    }
    public boolean isFever(){
        return fever;
    }
}
