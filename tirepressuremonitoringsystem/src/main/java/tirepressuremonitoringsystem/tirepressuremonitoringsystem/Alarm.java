package tirepressuremonitoringsystem.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    Sensor sensor = new Sensor();

    boolean alarmOn = false;

    public Alarm(Sensor sensor) {
		this.sensor = sensor;
	}

	public void check()
    {
        double psiPressureValue = probePressureValue();

        if (isNotSafe(psiPressureValue))
        {
            alarmOn();
        }
    }

	private void alarmOn() {
		alarmOn = true;
	}

	private boolean isNotSafe(double psiPressureValue) {
		return psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue;
	}

	private double probePressureValue() {
		return sensor.popNextPressurePsiValue();
	}

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}