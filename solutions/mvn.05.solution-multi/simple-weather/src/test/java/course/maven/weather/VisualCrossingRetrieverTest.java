package course.maven.weather;

import static org.junit.Assert.assertThat;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import course.maven.weather.VisualCrossingRetriever;

public class VisualCrossingRetrieverTest {

	@Test
	public void simpleTest() throws Exception {
		VisualCrossingRetriever retriever = new VisualCrossingRetriever();
		final String content;
		try (InputStream is = retriever.retrieve("köln")) {
			content = IOUtils.toString(is, "UTF-8");	
		}

		assertThat(content, CoreMatchers.containsString("Köln, Nordrhein-Westfalen, Deutschland"));
	}

}
