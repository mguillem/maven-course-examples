package course.maven.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.maven.weather.WeatherService;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location = request.getParameter("location");
		
		WeatherService weatherService = new WeatherService();
		try (PrintWriter out = response.getWriter()) {
			try {
				out.println(weatherService.retrieveForecast(location));
			} catch (Exception e) {
				out.println("Error Retrieving Forecast: " + e.getMessage());
			}
		}
	}
}