package com.rustica.demo.util;

import java.awt.Color;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.rustica.demo.modelo.Comida;

@Component("listadocomida")
public class ListaComidaPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Comida>listadocomidas=(List<Comida>) model.get("comidas");
		//PARA PODER DESARROLLAR EL TAMAÑO DE PAGINA
		document.setPageSize(PageSize.LETTER.rotate());
		//PARA PONER LOS TAMAÑOS DE MARGENES EN EL DOCUMENTO REQUERIDO EN LA TABLA
		document.setMargins(-20, -20,40,20);
		document.open();
		
		
		//SIRVE PARA PONERLE UN TITULO EN EL PDF
		PdfPTable tablaTitulo= new PdfPTable(1);
		PdfPCell celda=null;
		Font fuentetitulo= FontFactory.getFont(FontFactory.HELVETICA,16,Color.BLUE);
		Font fuenteTituloColumnas= FontFactory.getFont(FontFactory.HELVETICA,12,Color.BLUE);
		celda=new PdfPCell(new Phrase("Comidas",fuentetitulo));
		celda.setBorder(0);
		
		//ESTO SIRVE PARA PODER ALINEAR, PONER TAMAÑO Y COLOR A LAS LETRAS O PAGINAS
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(30);
		
		//para el titutlo
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		PdfPTable tablacomidas=new PdfPTable(4);
		tablacomidas.setWidths(new float[] {0.8f,2f,2f,1.5f});
		
		
		celda=new PdfPCell(new Phrase("IDCOM",fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablacomidas.addCell(celda);
		
		celda=new PdfPCell(new Phrase("NOMBRE",fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablacomidas.addCell(celda);
		
		celda=new PdfPCell(new Phrase("PRECIO",fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablacomidas.addCell(celda);
		
		celda=new PdfPCell(new Phrase("FECHA",fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablacomidas.addCell(celda);
		
		
		
		
		listadocomidas.forEach(comida ->{
			tablacomidas.addCell(String.valueOf(comida.getIdcom()));
			tablacomidas.addCell(comida.getNombre());
			tablacomidas.addCell(String.valueOf(comida.getPrecio()));
			tablacomidas.addCell(comida.getFecha());
		});
		document.add(tablaTitulo);
		document.add(tablacomidas);
		
	}
	
}
