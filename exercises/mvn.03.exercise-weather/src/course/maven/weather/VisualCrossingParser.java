package course.maven.weather;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class VisualCrossingParser {

	private static Logger log = Logger.getLogger(VisualCrossingParser.class);

	public Weather parse(final InputStream inputStream) throws Exception {
		final Weather weather = new Weather();
		
		log.debug( "Creating JSONParser" );
		
		JSONParser jsonParser = new JSONParser();

		JSONObject result = (JSONObject) jsonParser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

		log.trace( "Parsing JSON Response: " + result);

		JSONArray days = (JSONArray) result.get("days");
		JSONObject today = (JSONObject) days.get(0);
		
		String resolvedAddress = result.get("resolvedAddress").toString();
		String[] parts = resolvedAddress.split(", ");
		weather.setCity( parts.length > 0 ? parts[0]: resolvedAddress);
		weather.setRegion( parts.length > 1 ? parts[1]: "");
		weather.setCountry( parts.length > 2 ? parts[2]: "");

		weather.setCondition( today.get("conditions").toString() );
		weather.setTemp( asTemperature(today.get("temp").toString()) );
		weather.setHumidity( today.get("humidity").toString() );
		weather.setChill(today.get("windspeed").toString());

		return weather;
	}

	private String asTemperature(String string) {
		
			double tF = Double.parseDouble(string);
			double tC = (tF - 32) /1.8;
			return String.format("%.1f°C", tC);
	}


}
