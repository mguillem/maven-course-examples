package course.maven.weather.yahoo;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.Test;

import com.sonatype.maven.weather.yahoo.VisualCrossingParser;
import com.sonatype.maven.weather.yahoo.Weather;

public class VisualCrossingParserTest {

	@Test
	public void testParser() throws Exception {
		InputStream nyData = getClass().getResourceAsStream("/weather.json");

		Weather weather = new VisualCrossingParser().parse(nyData);
		assertEquals("Köln", weather.getCity());
		assertEquals("Nordrhein-Westfalen", weather.getRegion());
		assertEquals("Deutschland", weather.getCountry());
		assertEquals("3,6°C", weather.getTemp());
		assertEquals("Rain, Partially cloudy", weather.getCondition());
		assertEquals("16.1", weather.getChill());
		assertEquals("82.5", weather.getHumidity());
	}
}
