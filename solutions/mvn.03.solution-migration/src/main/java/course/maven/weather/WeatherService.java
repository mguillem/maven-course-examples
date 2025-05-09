package course.maven.weather;

import java.io.IOException;
import java.io.InputStream;

public class WeatherService {

    public WeatherService() {}

    public String retrieveForecast( String zip ) throws Exception {
        // Retrieve Data
        try (InputStream dataIn = new VisualCrossingRetriever().retrieve(zip)) {

            // Parse Data
            Weather weather = new VisualCrossingParser().parse(dataIn);

            // Format (Print) Data
            return new WeatherFormatter().format(weather);
        } catch (IOException ex) {
            throw new IOException("Failed to retrieve weather data due to "+ ex.getLocalizedMessage(), ex);
        }
    }
}
