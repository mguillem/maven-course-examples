package course.maven.weather;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class WeatherFormatter {

	private static Logger log = Logger.getLogger(WeatherFormatter.class);

	public String format( Weather weather ) throws Exception {
		log.trace( "Formatting Weather Data :" + weather);
		Reader reader = new InputStreamReader( getClass().getClassLoader().getResourceAsStream("output.vm"), Charset.forName("UTF-8"));
		VelocityContext context = new VelocityContext();
		context.put("weather", weather );
		StringWriter writer = new StringWriter();
		Velocity.evaluate(context, writer, "", reader);
		return writer.toString();		
	}
}
