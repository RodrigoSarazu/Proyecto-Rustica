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
import com.rustica.demo.modelo.Proveedor;

@Component("listadoproveedor")
public class ListProveedorPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Proveedor>listadoproveedores=(List<Proveedor>) model.get("proveedores");
		//PARA PODER DESARROLLAR EL TAMAÑO DE PAGINA	
		document.setPageSize(PageSize.LETTER.rotate());
		//PARA PONER LOS TAMAÑOS DE MARGENES EN EL DOCUMENTO REQUERIDO EN LA TABLA
		document.setMargins(-10, -10,20,10);
		document.open();
		
		//SIRVE PARA PONERLE UN TITULO EN EL PDF
		PdfPTable tablaTitulo= new PdfPTable(1);
		PdfPCell celda=null;
		Font fuentetitulo= FontFactory.getFont(FontFactory.HELVETICA,16,Color.BLUE);
		Font fuenteTituloColumnas= FontFactory.getFont(FontFactory.HELVETICA,12,Color.BLUE);
		celda=new PdfPCell(new Phrase("Proveedores",fuentetitulo));
		celda.setBorder(30);
		
		//ESTO SIRVE PARA PODER ALINEAR, PONER TAMAÑO Y COLOR A LAS LETRAS O PAGINAS
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(30);
		
		//para el titutlo
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		PdfPTable tablaproveedores=new PdfPTable(6);
		tablaproveedores.setWidths(new float[] {1.5f,2.2f,2f,1.5f,2.5f,1.5f});
		
		celda=new PdfPCell(new Phrase("COD. PROVEEDOR",fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaproveedores.addCell(celda);
		
		celda=new PdfPCell(new Phrase("NOMBRE PROVEEDOR",fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaproveedores.addCell(celda);
		
		celda=new PdfPCell(new Phrase("NOMBRE CONTACTO",fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaproveedores.addCell(celda);                
		
		celda=new PdfPCell(new Phrase("TELEFONO",fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaproveedores.addCell(celda);
		
		celda=new PdfPCell(new Phrase("DIRECCION",fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaproveedores.addCell(celda);
		
		celda=new PdfPCell(new Phrase("CODIGO POSTAL",fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaproveedores.addCell(celda);
		
		listadoproveedores.forEach(proveedor ->{
			tablaproveedores.addCell(String.valueOf(proveedor.getIdprov()));
			tablaproveedores.addCell(proveedor.getNomprove());
			tablaproveedores.addCell(proveedor.getNombrecontac());
			tablaproveedores.addCell(proveedor.getTelefono());
			tablaproveedores.addCell(proveedor.getDireccion());
			tablaproveedores.addCell(proveedor.getCodpostal());
		});
		document.add(tablaTitulo);
		document.add(tablaproveedores);
	}

}
