package course.maven.weather;

import java.io.InputStream;
import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

/**
 * 
 */
 public class VisualCrossingRetriever {

	private static Logger log = Logger.getLogger(VisualCrossingRetriever.class);

	final String serviceUrlPattern = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s?key=WB483R33GCBBW4MA5REBW87YH";

	public InputStream retrieve(String location) throws Exception {
		final String encodedLocation = URLEncoder.encode(location, "UTF-8");

		long timestamp = System.currentTimeMillis() / 1000;

		
		URL url = new URL(String.format(serviceUrlPattern, encodedLocation));
		URLConnection conn = url.openConnection();

		configureProxy(conn);
		log.debug("URLConnection established to: " + url);
		return conn.getInputStream();
	}

	private void configureProxy(URLConnection conn) {
		if (useProxy() && useProxyAuthentication()) {
			String httpProxyUser = System.getProperty("http.proxyUsername");
			String httpProxyPassword = System.getProperty("http.proxyPassword");
			log.info("Using Proxy with authentication");
			Authenticator.setDefault(new ProxyAuthenticator(httpProxyUser, httpProxyPassword));
		}
	}



	private boolean useProxyAuthentication() {
		final String proxyUser = System.getProperty("http.proxyUsername");
		final String proxyPassword = System.getProperty("http.proxyPassword");
		if (proxyUser != null && proxyPassword != null) {
			log.debug("Using Proxy user: + " + proxyUser + "with password" + proxyPassword);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * @see <a href=
	 *      "http://download.oracle.com/javase/6/docs/technotes/guides/net/proxies.html">Proxy</a>
	 * @see <a href=
	 *      "http://download.oracle.com/javase/6/docs/technotes/guides/net/properties.html">Networking
	 *      Properties</a>
	 */
	private boolean useProxy() {
		final String proxyHost = System.getProperty("http.proxyHost");
		final String proxyPort = System.getProperty("http.proxyPort");
		if (proxyHost != null && proxyPort != null) {
			log.debug("Using Proxy: + " + proxyHost + ":" + proxyPort);
			return true;
		}
		return false;
	}

}
