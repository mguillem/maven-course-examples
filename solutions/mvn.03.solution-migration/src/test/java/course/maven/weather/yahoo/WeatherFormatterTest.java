package course.maven.weather.yahoo;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import course.maven.weather.VisualCrossingParser;
import course.maven.weather.Weather;
import course.maven.weather.WeatherFormatter;

public class WeatherFormatterTest {

	@Test
	public void testFormat() throws Exception {
		InputStream nyData = getClass().getClassLoader().getResourceAsStream("weather.json");
		Weather weather = new VisualCrossingParser().parse(nyData);
		String formattedResult = new WeatherFormatter().format(weather);
		InputStream expected = getClass().getClassLoader().getResourceAsStream("format-expected.dat");
		assertEquals(IOUtils.toString(expected, "UTF-8"), formattedResult);
	}
}
