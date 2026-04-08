package org.DavidParada;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

public class PruebaITextEstilos {

    public static void main(String[] args) {
        try {

            PdfWriter writer = new PdfWriter("ejemplo_estilos.pdf");
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            Paragraph p = new Paragraph();

            // Texto normal
            p.add(new Text("Texto normal | "));

            // Negrita
            p.add(new Text("Negrita | ").setBold());

            // Cursiva
            p.add(new Text("Cursiva | ").setItalic());

            // Subrayado
            p.add(new Text("Subrayado | ").setUnderline());

            // Tachado
            p.add(new Text("Tachado | ").setLineThrough());

            // Color de texto
            p.add(new Text("Rojo | ").setFontColor(ColorConstants.RED));

            // Fondo
            p.add(new Text("Fondo amarillo | ")
                    .setBackgroundColor(ColorConstants.YELLOW));

            // Tamaño de fuente
            p.add(new Text("Grande | ").setFontSize(20));

            // Espaciado entre caracteres
            p.add(new Text("Espaciado | ").setCharacterSpacing(2));

            // Subíndice
            p.add(new Text("Subíndice | ").setTextRise(-5));

            // Superíndice
            p.add(new Text("Superíndice | ").setTextRise(5));

            // Escalado horizontal
            p.add(new Text("Escalado | ").setHorizontalScaling(0.5f));

            // Inclinación (skew)
            p.add(new Text("Inclinado | ").setSkew(10, 20));

            // Enlace
            p.add(new Text("Google | ")
                    .setFontColor(ColorConstants.BLUE)
                    .setUnderline()
                    .setAction(PdfAction.createURI("https://www.google.com")));

            document.add(p);

            document.close();

            System.out.println("PDF con estilos creado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}