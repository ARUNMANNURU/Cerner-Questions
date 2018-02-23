import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonInfections{
	
    private boolean hasfeverFlag;
    private static final float FEVER_TEMPTURE = 98.6f;
    private Map<Long, List<Temperature>> personToTemperatures = new HashMap<Long, List<Temperature>>();
    private Map<Long, List<Fever>> personToFevers = new HashMap<Long, List<Fever>>();
    
    public Map<Long, List<Temperature>> getPersonToTemperatures(){
        return personToTemperatures;
    }
    public Map<Long, List<Fever>> getPersonToFevers(){
        return personToFevers;
    }
    private void addPersonToTemperatures(){
        List<Temperature> temperatures = new ArrayList<Temperature>();
        Temperature temperature1 = new Temperature(99.8f, new Date(), TemperatureUnit.CELSIUS,
                Location.EAR, Activity.RUNNNING);
        Temperature temperature2 = new Temperature(96.8f, new Date(), TemperatureUnit.KELVIN,
                Location.MOUTH, Activity.SITTING);
        temperatures.add(temperature1);
        temperatures.add(temperature2);

        personToTemperatures.put(123L, temperatures);
    }

    // just look for refrence
    private void addPersonToFevers(){
        Temperature temperature1 = new Temperature(99.8f, new Date(), TemperatureUnit.CELSIUS,
                Location.EAR, Activity.RUNNNING);
        Temperature temperature2 = new Temperature(96.8f, new Date(), TemperatureUnit.KELVIN,
                Location.MOUTH, Activity.SITTING);

        List<Fever> fevers = new ArrayList<Fever>();
        Fever fever1 = new Fever(temperature1.getTempture(), temperature1.getNotedTime(), hasfever(
                temperature1.getLocation(), temperature1.getActivity(), temperature1.getTempture()));
        Fever fever2 = new Fever(temperature2.getTempture(), temperature2.getNotedTime(), hasfever(
                temperature2.getLocation(), temperature2.getActivity(), temperature2.getTempture()));
        fevers.add(fever1);
        fevers.add(fever2);
        personToFevers.put(123L, fevers);
    }

    // uding for llop use this foe interview
    private void addPersonToFevers(Long personId, List<Temperature> temperatures){
        List<Fever> fevers = new ArrayList<Fever>();
        for (Temperature temperature : temperatures){
            Fever fever1 = new Fever(temperature.getTempture(), temperature.getNotedTime(),
                    hasfever(temperature.getLocation(), temperature.getActivity(),
                            temperature.getTempture()));
            fevers.add(fever1);
        }
        personToFevers.put(123L, fevers);
    }

    private boolean hasfever(Location location, Activity activity, float temperature){
        if (hasFeverByActiviy(activity, temperature) && hasfeverByLocation(location, temperature)){
            return true;
        }
        return false;
    }
    private boolean hasfeverByLocation(Location location, float temp){
        switch (location){
        case EAR:
            if (FEVER_TEMPTURE > temp){
                return true;
            }
        case MOUTH:
            if (FEVER_TEMPTURE + 1 > temp){
                return true;
            }
        case ARMPIT:
            if (FEVER_TEMPTURE - 1 > temp){
                return true;
            }
        default:
            break;
        }
        return false;
    }
    private boolean hasFeverByActiviy(Activity activity, float temp){
        switch (activity){
        case SITTING:
            if (FEVER_TEMPTURE > temp){
                return true;
            }
        case RUNNNING:
            if (FEVER_TEMPTURE + 1 > temp){
                return true;
            }
        default:break;
        }
        return hasfeverFlag;
    }
}
