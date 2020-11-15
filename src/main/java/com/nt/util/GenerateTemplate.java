package com.nt.util;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.nt.dto.PatientDTO;

@Service
public class GenerateTemplate {
	//@Value("${hospitalAddress}")
	//private static String hospitalAddress;
	//@Value("${hospitalContactNo}")
	//private static String hospitalContactNo;
	@Autowired
	private Environment env;
	
	    private static String FILE = "D:/spring_prgms_workspace/FirstPdf.pdf";
	    
	    private static Font headlineFont = new Font(Font.FontFamily.HELVETICA, 30,
	            Font.BOLD,BaseColor.BLUE);
	    private static Font orangeFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.NORMAL, BaseColor.ORANGE);
	    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
	            Font.BOLD);
	    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.BOLD);
	    private static Font greenFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.NORMAL, BaseColor.GREEN);

	    public void generateTemplate(PatientDTO patientDto) {
	        try {
	        	
	        	//---------------------------
	        	String mobileNo =patientDto.getPatientMob();
	    		Date date=patientDto.getConsultaDto().getDate();
	    		Date admnDate=patientDto.getConsultaDto().getAdmnDate();
	    		Date discDate=patientDto.getConsultaDto().getDiscDate();
	    		String disease=patientDto.getConsultaDto().getDisease();
	    		String docName=patientDto.getConsultaDto().getDocName();
	    		String patientType=patientDto.getConsultaDto().getPatientType();
	    		String medications=patientDto.getConsultaDto().getMedications();
	    		//String hospitalAddress=hospitalAddress;
	    		String emailId=patientDto.getEmailId();
	    		//String hospitalContactNo=hospitalContactNo;
	    		String specialization=patientDto.getDoctorsdto().getSpecialistFor();
	    		System.out.println("specialization : "+specialization);
	    		String docContactNo=patientDto.getDoctorsdto().getMobileNo();
	    		System.out.println("docContactNo : "+docContactNo);
	    		//--------
	        	
	            Document document = new Document();
	            PdfWriter.getInstance(document, new FileOutputStream(FILE));
	            document.open();
	            addMetaData(document);
	            addTitlePage(document,env.getProperty("hospitalAddress") ,emailId,env.getProperty("hospitalContactNo"),specialization,docContactNo,docName);
	            addContent(document,mobileNo,docName,date,admnDate,discDate,disease,patientType,medications);
	           
	            document.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // iText allows to add metadata to the PDF which can be viewed in your Adobe
	    // Reader
	    // under File -> Properties
	    private static void addMetaData(Document document) {
	        document.addTitle("Prescription PDF");
	        document.addSubject("Using iText");
	        document.addKeywords("Java, PDF, iText");
	        document.addAuthor("HMS");
	        document.addCreator("Niharika Barik");
	    }

	    /**
	     * @param document
	     * @throws DocumentException
	     * @throws IOException 
	     */
	    private static void addTitlePage(Document document,String hospitalAddress, String emailId,String hospitalContactNo,
	    		String specialization,String docContactNo,String docName)throws DocumentException, IOException {
	            
	        
	        // Lets write a big header
	        Paragraph p2 = new Paragraph("DR HOSPITAL", headlineFont);
	        p2.setAlignment(Element.ALIGN_CENTER);
	        
	        // We add one empty line
	        Paragraph paragraph = new Paragraph();
	       // addEmptyLine(paragraph, 1);
	        paragraph.add(p2);
	        
	        LineSeparator ls = new LineSeparator();
	        paragraph.add(new Chunk(ls));
	        
	        Chunk glue = new Chunk(new VerticalPositionMark()); 
		  	Paragraph paragraph1 = new Paragraph(hospitalAddress,greenFont);
		  	paragraph1.add(new Chunk(glue));
	        paragraph1.add(docName);
	        
	         Paragraph paragraph2 = new Paragraph(emailId,greenFont);
	        paragraph2.add(new Chunk(glue));
	        paragraph2.add(specialization);
	        
	        Paragraph paragraph3 = new Paragraph(hospitalContactNo,greenFont);
	        paragraph3.add(new Chunk(glue));
	        paragraph3.add(docContactNo);
	        
	        Paragraph paragraph4=new Paragraph();
	        paragraph4.add(new Chunk(ls));
	        
	        document.add(paragraph);
	        document.add(paragraph1);
	        document.add(paragraph2);
	        document.add(paragraph3);
	        document.add(paragraph4);
	    }


		private static void addContent(Document document,String mobileNo,String docName,Date date,
	    		Date admnDate,Date discDate,String disease,String patientType,String medications) 
	    				throws DocumentException {
	    	Paragraph paragraph = new Paragraph();
	        // We add one empty line
	       addEmptyLine(paragraph, 1);

	        // Will create: Report generated by: _name, _date
	        paragraph.add(new Paragraph("MobileNo: "+mobileNo, orangeFont));
	        paragraph.add(new Paragraph("DocName: "+docName, orangeFont));
	        paragraph.add(new Paragraph("Date: "+date, orangeFont));
	        paragraph.add(new Paragraph("AdmnDate: "+admnDate, orangeFont));
	        paragraph.add(new Paragraph("DiscDate: "+discDate,  orangeFont));
	        paragraph.add(new Paragraph("Disease: "+disease,  orangeFont));
	        paragraph.add(new Paragraph("PatientType: "+patientType, orangeFont));
	        paragraph.add(new Paragraph("Medications: "+medications,  orangeFont));
	               
	        document.add(paragraph);

	    }

	    
	    
	    private static void addEmptyLine(Paragraph paragraph, int number) {
	        for (int i = 0; i < number; i++) {
	            paragraph.add(new Paragraph(" "));
	        }
	    }
	}


