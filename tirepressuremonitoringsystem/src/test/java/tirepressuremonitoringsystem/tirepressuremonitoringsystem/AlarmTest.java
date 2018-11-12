package tirepressuremonitoringsystem.tirepressuremonitoringsystem;

import org.junit.Test;
import static org.mockito.Mockito.when;
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
	


}
