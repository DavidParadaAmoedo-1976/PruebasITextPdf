package org.DavidParada;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.HorizontalAlignment;

import java.nio.file.Files;
import java.nio.file.Paths;

public class PruebaITextImagenes {

    public static void main(String[] args) {
        try {

            // CREAR PDF

            PdfWriter writer = new PdfWriter("src/resources/pdf/ejemplo_imagenes.pdf");
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);

            // Ruta de la imagen
            String rutaImagen = "src/resources/imagen/logo.png";

            // CARGAR IMAGEN
            ImageData imageData = ImageDataFactory.create(rutaImagen);

    // 1. IMAGEN NORMAL

            Image img = new Image(imageData);
            img.scaleToFit(200, 200); // evitar warnings

            document.add(new Paragraph("Imagen normal:"));
            document.add(img);
            document.add(new Paragraph(""));


    // 2. ESCALADO ABSOLUTO

            Image imgEscalada = new Image(imageData);
            imgEscalada.scaleAbsolute(100, 100);

            document.add(new Paragraph("Escalada 100x100:"));
            document.add(imgEscalada);
            document.add(new Paragraph(""));


    // 3. ESCALADO PROPORCIONAL

            Image imgFit = new Image(imageData);
            imgFit.scaleToFit(150, 150);

            document.add(new Paragraph("Escalada proporcional:"));
            document.add(imgFit);
            document.add(new Paragraph(""));


    // 4. ESCALADO POR PORCENTAJE


            // pongo la imagen dentro de un bloque indivisible, para que no separe el texto de la imagen
            // y realice el cambio de página de la imagen con el texto.
            Image imgPercent = new Image(imageData);
            imgPercent.scale(0.5f, 0.5f);

            Div bloque = new Div();

            bloque.add(new Paragraph("Escalada por porcentaje -> 50%:"));
            bloque.add(imgPercent);

            bloque.setKeepTogether(true);
            bloque.setMarginBottom(20);

            document.add(bloque);
            document.add(new Paragraph(""));


    // 5. ALINEACIÓN

            Image imgCenter = new Image(imageData);
            imgCenter.scaleToFit(150, 150);
            imgCenter.setHorizontalAlignment(HorizontalAlignment.CENTER);

            document.add(new Paragraph("Imagen centrada:"));
            document.add(imgCenter);
            document.add(new Paragraph(""));


    // 6. ROTACIÓN

            Image imgRotate = new Image(imageData);
            imgRotate.scaleToFit(150, 150);
            imgRotate.setRotationAngle(Math.toRadians(30));

            document.add(new Paragraph("Imagen rotada 30°:"));
            document.add(imgRotate);
            document.add(new Paragraph(""));

    // 7. OPACIDAD

            Image imgOpacity = new Image(imageData);
            imgOpacity.scaleToFit(150, 150);
            imgOpacity.setOpacity(0.5f);

            document.add(new Paragraph("Imagen con opacidad:"));
            document.add(imgOpacity);
            document.add(new Paragraph(""));

    // 8. BORDE

            Image imgBorder = new Image(imageData);
            imgBorder.scaleToFit(150, 150);
            imgBorder.setBorder(new com.itextpdf.layout.borders.SolidBorder(ColorConstants.BLACK, 2));

            document.add(new Paragraph("Imagen con borde:"));
            document.add(imgBorder);
            document.add(new Paragraph(""));


    // 9. IMAGEN EN TABLA

            Table table = new Table(2);

            Image imgTable = new Image(imageData);
            imgTable.scaleToFit(50, 50);

            table.addCell("Texto");
            table.addCell(imgTable);

            document.add(new Paragraph("Imagen en tabla:"));
            document.add(table);
            // Realiza cambio de página.
            document.add(new AreaBreak());


    // 10. IMAGEN DESDE BYTE[]

            byte[] bytes = Files.readAllBytes(Paths.get(rutaImagen));
            ImageData dataBytes = ImageDataFactory.create(bytes);
            Image imgBytes = new Image(dataBytes);

            imgBytes.scaleToFit(150, 150);

            document.add(new Paragraph("Imagen desde byte[]:"));
            document.add(imgBytes);


            // CERRAR

            document.close();

            System.out.println("PDF generado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}