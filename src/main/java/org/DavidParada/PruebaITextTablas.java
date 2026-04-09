package org.DavidParada;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.properties.UnitValue;

public class PruebaITextTablas {

    public static void main(String[] args) {
        try {


            // CREAR PDF

            PdfWriter writer = new PdfWriter("src/resources/pdf/ejemplo_tablas.pdf");
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);

    // TABLA BÁSICA

            Table table1 = new Table(3);

            table1.addCell("Col1");
            table1.addCell("Col2");
            table1.addCell("Col3");

            table1.addCell("A");
            table1.addCell("B");
            table1.addCell("C");

            document.add(new Paragraph("Tabla básica"));
            document.add(table1.setMarginBottom(20));

    // TABLA ALINEADA AL CENTRO

            Table tableCentro = new Table(2);
            tableCentro.setWidth(UnitValue.createPercentValue(50)); // importante si no, ocupa todo

            tableCentro.setHorizontalAlignment(HorizontalAlignment.CENTER);

            tableCentro.addCell("A");
            tableCentro.addCell("B");

            document.add(new Paragraph("Tabla centrada"));
            document.add(tableCentro.setMarginBottom(20));

    // TABLA ALINEADA A LA DERECHA

            Table tableDerecha = new Table(2);
            tableDerecha.setWidth(UnitValue.createPercentValue(50));

            tableDerecha.setHorizontalAlignment(HorizontalAlignment.RIGHT);

            tableDerecha.addCell("A");
            tableDerecha.addCell("B");

            document.add(new Paragraph("Tabla a la derecha"));
            document.add(tableDerecha.setMarginBottom(20));


    // TABLA CON ANCHOS

            Table table2 = new Table(new float[]{2, 5, 3});
            table2.setWidth(UnitValue.createPercentValue(100));

            table2.addCell("ID");
            table2.addCell("Nombre");
            table2.addCell("Precio");

            table2.addCell("1");
            table2.addCell("Producto largo");
            table2.addCell("10€");

            document.add(new Paragraph("Tabla con anchos"));
            document.add(table2.setMarginBottom(20));

    // CELDAS CON ESTILO

            Table table3 = new Table(2);

            Cell cell = new Cell()
                    .add(new Paragraph("Celda estilizada"))
                    .setBackgroundColor(ColorConstants.YELLOW)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBorder(new SolidBorder(ColorConstants.BLACK, 2))
                    .setPadding(10);

            table3.addCell(cell);
            table3.addCell("Normal");

            document.add(new Paragraph("Celda con estilo"));
            document.add(table3.setMarginBottom(20));

    // COMBINAR CELDAS

            Table table4 = new Table(3);

            table4.addCell(new Cell(1, 3)
                    .add(new Paragraph("Cabecera combinada"))
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            table4.addCell("A");
            table4.addCell("B");
            table4.addCell("C");

            document.add(new Paragraph("Celdas combinadas"));
            document.add(table4.setMarginBottom(20));


    // ALINEACIÓN

            Table table5 = new Table(2);

            table5.addCell(new Cell().add(new Paragraph("Izquierda")));
            table5.addCell(new Cell()
                    .add(new Paragraph("Derecha"))
                    .setTextAlignment(TextAlignment.RIGHT));

            document.add(new Paragraph("Alineación"));
            document.add(table5.setMarginBottom(20));

    // ALTURA DE CELDA

            Table table6 = new Table(1);

            table6.addCell(new Cell()
                    .add(new Paragraph("Celda alta"))
                    .setHeight(80));

            document.add(new Paragraph("Altura de celda"));
            document.add(table6.setMarginBottom(20));

            document.add(new AreaBreak());

    // CABECERA

            Table table7 = new Table(2);

            table7.addHeaderCell("Nombre");
            table7.addHeaderCell("Edad");

            table7.addCell("David");
            table7.addCell("25");

            document.add(new Paragraph("Cabecera"));
            document.add(table7.setMarginBottom(20));

    // TABLA CON IMAGEN

            Table table8 = new Table(2);

            Image img = new Image(
                    com.itextpdf.io.image.ImageDataFactory.create(
                            "src/resources/imagen/logo.png"
                    )
            ).scaleToFit(50, 50);

            table8.addCell("Logo:");
            table8.addCell(img);

            document.add(new Paragraph("Tabla con imagen"));
            document.add(table8.setMarginBottom(20));

    // COLSPAN (2 columnas)

            Table tableColspan = new Table(3);

            tableColspan.addCell(new Cell(1, 3)
                    .add(new Paragraph("Cabecera ocupa 3 columnas"))
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            tableColspan.addCell("A");
            tableColspan.addCell("B");
            tableColspan.addCell("C");

            document.add(new Paragraph("Colspan (cabecera completa)"));
            document.add(tableColspan.setMarginBottom(20));

    // ROWSPAN (2 filas)

            Table tableRowspan = new Table(3);

            tableRowspan.addCell(new Cell(2, 1)
                    .add(new Paragraph("Ocupa 2 filas"))
                    .setBackgroundColor(ColorConstants.YELLOW));

            tableRowspan.addCell("B1");
            tableRowspan.addCell("C1");

            tableRowspan.addCell("B2");
            tableRowspan.addCell("C2");

            document.add(new Paragraph("Rowspan (2 filas)"));
            document.add(tableRowspan.setMarginBottom(20));

    // COMBINACIÓN COMPLETA

            Table tableCombo = new Table(4);

            // Cabecera
            tableCombo.addCell(new Cell(1, 4)
                    .add(new Paragraph("TABLA COMPLEJA"))
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                    .setTextAlignment(TextAlignment.CENTER));

            // Columna izquierda con rowspan
            tableCombo.addCell(new Cell(3, 1)
                    .add(new Paragraph("Categoría"))
                    .setBackgroundColor(ColorConstants.YELLOW));

            // Filas normales
            tableCombo.addCell("Producto 1");
            tableCombo.addCell("Precio 1");
            tableCombo.addCell("Stock 1");

            tableCombo.addCell("Producto 2");
            tableCombo.addCell("Precio 2");
            tableCombo.addCell("Stock 2");

            tableCombo.addCell("Producto 3");
            tableCombo.addCell("Precio 3");
            tableCombo.addCell("Stock 3");

            document.add(new Paragraph("Colspan + Rowspan combinados"));
            document.add(tableCombo.setMarginBottom(20));

    // MATRIZ VISUAL

            Table tableVisual = new Table(3);

            tableVisual.addCell("1,1");
            tableVisual.addCell(new Cell(1, 2).add(new Paragraph("1,2 y 1,3")));

            tableVisual.addCell(new Cell(2, 1).add(new Paragraph("2,1 y 3,1")));
            tableVisual.addCell("2,2");
            tableVisual.addCell("2,3");

            tableVisual.addCell("3,2");
            tableVisual.addCell("3,3");

            document.add(new Paragraph("Ejemplo visual de combinación"));
            document.add(tableVisual.setMarginBottom(20));

            document.add(new AreaBreak());

    // PADDING

            Table tablePadding = new Table(2);

            Cell cellPadding = new Cell()
                    .add(new Paragraph("Celda con padding"))
                    .setBackgroundColor(ColorConstants.YELLOW)
                    .setPadding(20); // espacio interno

            tablePadding.addCell(cellPadding);
            tablePadding.addCell("Normal");

            document.add(new Paragraph("Padding en celda"));
            document.add(tablePadding.setMarginBottom(20));

            // Padding individual

            Cell cellPaddingCustom = new Cell()
                    .add(new Paragraph("Padding personalizado"))
                    .setPaddingTop(20)
                    .setPaddingBottom(5)
                    .setPaddingLeft(30)
                    .setPaddingRight(10);

    // SIN BORDES

            Table tableNoBorder = new Table(2);

            Cell cell1 = new Cell()
                    .add(new Paragraph("Sin borde"))
                    .setBorder(Border.NO_BORDER);

            Cell cell2 = new Cell()
                    .add(new Paragraph("También sin borde"))
                    .setBorder(Border.NO_BORDER);

            tableNoBorder.addCell(cell1);
            tableNoBorder.addCell(cell2);

            document.add(new Paragraph("Tabla sin bordes"));
            document.add(tableNoBorder.setMarginBottom(20));
            document.add(new Paragraph(""));


    // BORDES INDIVIDUALES


            // TABLA 1 (sin borde superior)

            Table tableBordes1 = new Table(2);

            Cell cell3 = new Cell()
                    .add(new Paragraph("Sin borde superior"))
                    .setBorderTop(Border.NO_BORDER);

            Cell cell4 = new Cell()
                    .add(new Paragraph("Normal"));

            tableBordes1.addCell(cell3);
            tableBordes1.addCell(cell4);

            // margen inferior para separar
            table1.setMarginBottom(20);
            document.add(tableBordes1);
            document.add(new Paragraph(""));



            // TABLA 2 (solo borde inferior)

            Table tableBordes2 = new Table(2);

            Cell cell5 = new Cell()
                    .add(new Paragraph("Solo borde inferior"))
                    .setBorderTop(Border.NO_BORDER)
                    .setBorderLeft(Border.NO_BORDER)
                    .setBorderRight(Border.NO_BORDER);

            Cell cell6 = new Cell()
                    .add(new Paragraph("Normal"));

            tableBordes2.addCell(cell5);
            tableBordes2.addCell(cell6);

            document.add(tableBordes2);

    // PADDING + SIN BORDES

            Table tableClean = new Table(2);

            Cell cellClean1 = new Cell()
                    .add(new Paragraph("Diseño limpio"))
                    .setPadding(15)
                    .setBorder(Border.NO_BORDER);

            Cell cellClean2 = new Cell()
                    .add(new Paragraph("Más contenido"))
                    .setPadding(15)
                    .setBorder(Border.NO_BORDER);

            tableClean.addCell(cellClean1);
            tableClean.addCell(cellClean2);

            document.add(new Paragraph("Tabla estilo limpio (sin bordes + padding)"));
            document.add(tableClean.setMarginBottom(20));


            // CERRAR

            document.close();

            System.out.println("PDF tablas generado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
