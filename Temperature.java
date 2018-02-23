import java.util.Date;

public class Temperature
{
    private float temperature;
    private final Date notedTime;
    private final TemperatureUnit temperatureUnit;
    private final Location location;
    private final Activity activity;
    
    public float getTempture(){
        return conversertionToFahrenheit();
    }
    public Date getNotedTime(){
        return notedTime;
    }
    public TemperatureUnit getTemperatureUnit(){
        return temperatureUnit;
    }
    public Location getLocation(){
        return location;
    }
    public Activity getActivity(){
        return activity;
    }
    public Temperature(float tempture_Fahrenheit, Date notedTime, TemperatureUnit temperatureUnit,
            Location location, Activity activity){
        temperature = tempture_Fahrenheit;
        this.notedTime = notedTime;
        this.temperatureUnit = temperatureUnit;
        this.location = location;
        this.activity = activity;
    }

    public float conversertionToFahrenheit(){
    	float fahrenheit = temperature;
        if (TemperatureUnit.CELSIUS == temperatureUnit){
            fahrenheit = 32 + (temperature * 9 / 5);
        }
        if (TemperatureUnit.KELVIN == temperatureUnit){
            fahrenheit = (float) (32 + ((temperature - 273.16) * 9 / 5));
        }
        return fahrenheit;
    }
}
