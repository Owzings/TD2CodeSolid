package tirepressuremonitoringsystem.tirepressuremonitoringsystem;

import org.junit.Test;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;



public class AlarmTest  {
	
	@Test
	public void alarmSeDeclencheEnCasDeValeurDePressionTropBasse() {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(0.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmSeDeclencheEnCasDeValeurDePressionTropHaute() {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(30.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmNeSeDeclenchePasEnCasDePressionDansLeSueilDeSecurite() {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(20.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmResteEnlencheePeuImporteLaValeurSondeeSuivante() {
		Sensor sensor = capteurQuiSonde(30.0,20.0);
		Alarm alarm = new Alarm(sensor);
		
		alarm.check();
		assertTrue(alarm.alarmOn);
		
		alarm.check();
		assertTrue(alarm.alarmOn);
		
	}

	private Sensor capteurQuiSonde(double value) {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(value);
		return sensor;
	}
	private Sensor capteurQuiSonde(double value1, double value2) {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(value1).thenReturn(value2);
		return sensor;
	}
}
