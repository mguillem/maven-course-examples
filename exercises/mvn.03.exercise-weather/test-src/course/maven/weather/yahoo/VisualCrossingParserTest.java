package course.maven.weather.yahoo;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.Test;

import com.sonatype.maven.weather.yahoo.VisualCrossingParser;
import com.sonatype.maven.weather.yahoo.Weather;

public class VisualCrossingParserTest {

	//@Test
	public void testParser() throws Exception {
		InputStream nyData = getClass().getResourceAsStream("/weather.json");
		System.out.println(nyData);
		Weather weather = new VisualCrossingParser().parse(nyData);
		assertEquals("New York", weather.getCity());
		assertEquals("NY", weather.getRegion());
		assertEquals("US", weather.getCountry());
		assertEquals("39", weather.getTemp());
		assertEquals("Fair", weather.getCondition());
		assertEquals("39", weather.getChill());
		assertEquals("67", weather.getHumidity());
	}
}
