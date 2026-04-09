package org.DavidParada;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

public class PruebaITextEstilos2 {

    public static void main(String[] args) {
        try {

            PdfWriter writer = new PdfWriter("src/resources/pdf/ejemplo_estilos_2.pdf");
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

// Texto normal
            document.add(new Paragraph().add(new Text("Texto normal")));

// Línea en blanco
            document.add(new Paragraph(""));

// Negrita
            document.add(new Paragraph().add(new Text("Negrita").setBold()));
            document.add(new Paragraph(""));

// Cursiva
            document.add(new Paragraph().add(new Text("Cursiva").setItalic()));
            document.add(new Paragraph(""));

// Subrayado
            document.add(new Paragraph().add(new Text("Subrayado").setUnderline()));
            document.add(new Paragraph(""));

// Tachado
            document.add(new Paragraph().add(new Text("Tachado").setLineThrough()));
            document.add(new Paragraph(""));

// Color
            document.add(new Paragraph().add(
                    new Text("Texto rojo").setFontColor(com.itextpdf.kernel.colors.ColorConstants.RED)
            ));
            document.add(new Paragraph(""));

// Fondo
            document.add(new Paragraph().add(
                    new Text("Fondo amarillo")
                            .setBackgroundColor(com.itextpdf.kernel.colors.ColorConstants.YELLOW)
            ));
            document.add(new Paragraph(""));

// Tamaño
            document.add(new Paragraph().add(new Text("Texto grande").setFontSize(20)));
            document.add(new Paragraph(""));

// Espaciado entre caracteres
            document.add(new Paragraph().add(new Text("Espaciado | ").setCharacterSpacing(4)));
            document.add(new Paragraph(""));

// Inclinación (skew)
            document.add(new Paragraph().add(new Text("Inclinado | ").setSkew(20, 0)));
            document.add(new Paragraph(""));

// Inclinación (skew)
            document.add(new Paragraph().add(new Text("Inclinado | ").setSkew(25, 25)));
            document.add(new Paragraph(""));

// Subíndice
            Paragraph pSub = new Paragraph();
            pSub.add(new Text("Texto normal"));
            pSub.add(new Text("Subíndice").setTextRise(-5));

            document.add(pSub);
            document.add(new Paragraph(""));

// Superíndice
            Paragraph pSup = new Paragraph();
            pSup.add(new Text("Texto normal"));
            pSup.add(new Text("Superíndice").setTextRise(5));

            document.add(pSup);
            document.add(new Paragraph(""));

// Subíndice reduciendo fuente
            Paragraph pSub2 = new Paragraph();
            pSub2.add(new Text("Texto normal"));
            pSub2.add(new Text("Subíndice").setTextRise(-5).setFontSize(8));

            document.add(pSub2);
            document.add(new Paragraph(""));

// Superíndice reduciendo fuente
            Paragraph pSup2 = new Paragraph();
            pSup2.add(new Text("Texto normal"));
            pSup2.add(new Text("Superíndice").setTextRise(5).setFontSize(8));

            document.add(pSup2);
            document.add(new Paragraph(""));

// Enlace
            document.add(new Paragraph().add(
                    new Text("HiperEnlace")
                            .setFontColor(com.itextpdf.kernel.colors.ColorConstants.BLUE)
                            .setUnderline()
                            .setAction(com.itextpdf.kernel.pdf.action.PdfAction
                                    .createURI("https://www.google.com"))
            ));

            document.close();
            System.out.println("PDF con estilos creado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
