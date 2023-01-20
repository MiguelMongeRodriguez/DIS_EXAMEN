package es.ufv.dis.api.final2022.MMR.PDF;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import es.ufv.dis.api.final2022.MMR.Producto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PDFManager {
    public void crearPDF (ArrayList<Producto> list){
        try {
            // Define the directory where the PDF should be saved
            String directory = "./src/productos/";
            // Define the file name for the PDF
            String fileName = "ProductosBackup.pdf";

            // Create a new document
            Document document = new Document();

            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(directory + fileName));

            doc.open();
            String text = list.toString();
            Paragraph p = new Paragraph(text);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(p);
            doc.close();
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
