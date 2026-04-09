package org.DavidParada;

import com.itextpdf.layout.element.IElement;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.ListNumberingType;


public class PruebaITextListas {

    public static void main(String[] args) {
        try {


            // CREAR PDF

            PdfWriter writer = new PdfWriter("src/resources/pdf/ejemplo_listas.pdf");
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);

    // Lista simple
            List lista = new List();
            lista.add(new ListItem("Elemento 1"));
            lista.add(new ListItem("Elemento 2"));
            lista.add(new ListItem("Elemento 3"));

            document.add(new Paragraph("Lista simple"));
            document.add(lista.setMarginBottom(20));

    // Lista numerada
            List listaNum = new List(ListNumberingType.DECIMAL);
            listaNum.add(new ListItem("Uno"));
            listaNum.add(new ListItem("Dos"));
            listaNum.add(new ListItem("Tres"));

            document.add(new Paragraph("Lista numerada"));
            document.add(listaNum.setMarginBottom(20));

    // Lista con letras
            List listaLetra = new List(ListNumberingType.ENGLISH_LOWER);
            listaLetra.add(new ListItem("a"));
            listaLetra.add(new ListItem("b"));
            listaLetra.add(new ListItem("c"));

            document.add(new Paragraph("Lista letras"));
            document.add(listaLetra.setMarginBottom(20));

    // Lista personalizada
            List listaCustom = new List();
            listaCustom.setListSymbol("→ ");
            listaCustom.add(new ListItem("Elemento A"));
            listaCustom.add(new ListItem("Elemento B"));

            document.add(new Paragraph("Lista personalizada"));
            document.add(listaCustom.setMarginBottom(20));

    // Lista anidada
            List listaPadre = new List();

            List sub = new List();
            sub.add(new ListItem("Sub 1"));
            sub.add(new ListItem("Sub 2"));

            ListItem item = new ListItem("Principal 2");
            item.add(sub);

            listaPadre.add(new ListItem("Principal 1"));
            listaPadre.add(item);

    // Lista con estilo
            List listaEstilo = new List();

            Text bold = new Text("importante");
            bold.setBold();

            Paragraph p = new Paragraph();
            p.add("Texto ");
            p.add(bold);

            ListItem itemConEstilo = new ListItem();
            itemConEstilo.add(p);

            listaEstilo.add(itemConEstilo);

            document.add(new Paragraph("\nLista con estilo"));
            document.add(listaEstilo);

    // Color + negrita
            Paragraph p1 = new Paragraph();
            p1.add("Texto ");
            p1.add(new Text("rojo").setFontColor(ColorConstants.RED).setBold());

            ListItem lista1 = new ListItem();
            lista1.add(p1);

            document.add(new Paragraph("Lista con color"));
            document.add(lista1.setMarginBottom(20));

    // Subrayado + tamaño
            Paragraph p2 = new Paragraph();
            p2.add("Texto ");
            p2.add(new Text("grande").setFontSize(16).setUnderline());

            ListItem lista2 = new ListItem();
            lista2.add(p2);

            document.add(new Paragraph("Lista con tamaño"));
            document.add(lista2.setMarginBottom(20));

    // Mezcla de estilos
            Paragraph p3 = new Paragraph();
            p3.add("Texto ");
            p3.add(new Text("negrita ").setBold());
            p3.add(new Text("rojo ").setFontColor(ColorConstants.RED));
            p3.add(new Text("subrayado").setUnderline());

            ListItem lista3 = new ListItem();
            lista3.add(p3);

            document.add(new Paragraph("Lista con múltiples estilos"));
            document.add(lista3.setMarginBottom(20));

            // CERRAR

            document.close();

            System.out.println("PDF tablas generado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

