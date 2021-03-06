package Windows;
import org.gicentre.utils.stat.XYChart;

import Serial.SerialManager;
import processing.core.PApplet;

public class ZonkrachtPaneel extends PApplet {

	XYChart lineChart;

	public void settings() {
		size(1200, 680);								// De grootte van de window

	}

	public void setup() {
		surface.setResizable(true);				 		// Venster grootte kan worden aangepast
		frameRate(5);									// Framerate(1) zorgt ervoor dat er een waarde per seconde wordt doorgegeven. 
		textFont(createFont("Arial", 10), 10);			// Geeft de lettertype weer
		
		// Both x and y data set here.
		lineChart = new XYChart(this);	

		// Assen en tekst bij assen.
		lineChart.setAxisColour(255);					// Kleur van de X en Y as
		lineChart.setAxisLabelColour(255);				// Kleur van de labels bij de assen
		lineChart.setAxisValuesColour(255);				// Kleur van de waardes bij de assen
		lineChart.showXAxis(true); 						// Laten zien(true) of verbergen(false) van de X-as
		lineChart.showYAxis(true); 						// Laten zien of verbergen van de Y-as
		lineChart.setMinY(0); 							// Een minimale waarde instellen voor de Y-as
		lineChart.setMinX(0);							// Een minimale waarde instellen voor de X-as
		lineChart.setXAxisLabel("Tijd [min]"); 			// Tekst voor op de X-as
		lineChart.setYAxisLabel("Zonkracht [W/m²]\n"); 	// Tekst voor op de Y-as

		lineChart.setLineWidth(1); 						// Dikte van de lijn
		lineChart.setPointSize(0); 						// Dikte van de punten op de lijn
		lineChart.setLineColour(255);					// Kleur van de lijn (wit)

	}

	public void draw() {
		background(55); 								// Kleur voor de achtergrond (donkergrijs)
		textSize(14);									// Grootte van de tekst van de label
		lineChart.draw(30, 30, width - 30, height - 30);// Tekent de grafiek tussen het gebied die is aangegeven

		fill(200, 200, 0); 								// Kleur tekst titel
		textSize(20); 									// Grootte tekst titel
		text("Zonkracht", 70, 30); 					// De tekst en de positie
		textSize(11);									// Grootte tekst onder titel
		text("Real-Time data van de Zonkracht in Watt per meter².", 70, 45);		//De tekst en positie onder titel

		int j = SerialManager.tijd.size(); // Omzetter van lijst naar array
		float xValueArray[] = new float[j]; // Array aanmaken
		for (int i = 0; i < j; i++) { // Iterate over de lijst
			xValueArray[i] = SerialManager.tijd.get(i); // Vul de array in
		}
		float yValueArray[] = new float[j]; // Array aanmaken
		for (int i = 0; i < j; i++) { // Iterate over de lijst
			yValueArray[i] = SerialManager.zonkracht.get(i); // Vul de array met data in
		}

		lineChart.setData(xValueArray, yValueArray);	// Zend data naar de grafiek
	}
}
