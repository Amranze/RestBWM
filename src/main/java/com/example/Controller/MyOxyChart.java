package com.example.Controller;

import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.example.Entity.OximeterModel;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class MyOxyChart {

	public byte[] generateChart(List<OximeterModel> oximeterData){
    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
		final XYSeries dataset = new XYSeries("Pulse");
		int i=5;
		for(OximeterModel oxi : oximeterData){
			//dataset.add(new Date(oxi.getTimestamp()).getMinutes(), oxi.getPulse());
			dataset.add(i++, oxi.getPulse());
		}
	    final XYSeriesCollection data = new XYSeriesCollection(dataset);
	    final JFreeChart chart = ChartFactory.createXYLineChart(
	    		"Pulse Amrane",
	    		"Minutes",
	    		"Pulse",
	    		data,
	    		PlotOrientation.VERTICAL,
	            true,
	            true,
	            false
	        );
	    try{
	    	ChartUtilities.saveChartAsJPEG(new File("C:\\Temp\\chart.jpg"), chart, 500, 300);
        } catch (Exception e) {
            System.out.println("Problem occurred creating chart.");
        }
	    float f = 0.8f;
	    try {
			ChartUtilities.writeChartAsJPEG(bos, f, chart, 500, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return bos.toByteArray();
	}
	
	/*public static void writeChartToPDF(JFreeChart chart, int width, int height, String fileName) {
		
	}*/
    public void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        // Note that it is not necessary to create new PageSize object,
        // but for testing reasons (connected to parallelization) we call constructor here
        Document doc = new Document(pdfDoc, new PageSize(PageSize.A4).rotate());
 
        
 
        doc.close();
    }

	
}
