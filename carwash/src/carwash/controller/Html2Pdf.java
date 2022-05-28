package carwash.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.FSEntityResolver;
import org.xml.sax.SAXException;
 
import com.lowagie.text.DocumentException;
 
@WebServlet("/Html2Pdf")
public class Html2Pdf extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public Html2Pdf() {
        super();
    }
 
    protected void doGet(HttpServletRequest requestObj, HttpServletResponse responseObj) throws ServletException, IOException {
 
        }
 
    protected void doPost(HttpServletRequest requestObj, HttpServletResponse responseObj) throws ServletException, IOException {
 
                responseObj.setHeader("Cache-Control", "no-cache"); 
 
                String cust_email = (String) requestObj.getParameter("cust_email");
                String cust_name = (String) requestObj.getParameter("cust_name");
                String cust_phone = (String) requestObj.getParameter("cust_phone");
                String book_date = (String) requestObj.getParameter("book_date");
                String book_time = (String) requestObj.getParameter("book_time");
                String car_plateno = (String) requestObj.getParameter("car_plateno");
                String car_name = (String) requestObj.getParameter(" car_name ");
                String cartype = (String) requestObj.getParameter("cartype");
                String car_package = (String) requestObj.getParameter("car_package");
                responseObj.setContentType( "application/pdf" );  //Content type should be application/pdf
 
                responseObj.setHeader("Content-Disposition","attachment; filename=\"" +"MyPdf.pdf\"" );
                responseObj.setHeader("Cache-Control", "no-cache");
                OutputStream os=responseObj.getOutputStream();
                final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                documentBuilderFactory.setValidating(true);
                DocumentBuilder builder;
                try {
                        builder = documentBuilderFactory.newDocumentBuilder();
                        builder.setEntityResolver(FSEntityResolver.instance());
                        org.w3c.dom.Document document;
                        document=builder.parse(new ByteArrayInputStream(cust_email.getBytes())); //Parse the content of the given InputStream as an XML document and return a new DOM Document object. 
                        document=builder.parse(new ByteArrayInputStream(cust_name.getBytes())); //Parse the content of the given InputStream as an XML document and return a new DOM Document object.
                        document=builder.parse(new ByteArrayInputStream(cust_phone.getBytes())); //Parse the content of the given InputStream as an XML document and return a new DOM Document object.
                        document=builder.parse(new ByteArrayInputStream(book_date.getBytes())); //Parse the content of the given InputStream as an XML document and return a new DOM Document object. 
                        document=builder.parse(new ByteArrayInputStream(book_time.getBytes())); //Parse the content of the given InputStream as an XML document and return a new DOM Document object.
                        document=builder.parse(new ByteArrayInputStream(car_plateno.getBytes())); //Parse the content of the given InputStream as an XML document and return a new DOM Document object.
                        document=builder.parse(new ByteArrayInputStream(car_name.getBytes())); //Parse the content of the given InputStream as an XML document and return a new DOM Document object. 
                        document=builder.parse(new ByteArrayInputStream(cartype.getBytes())); //Parse the content of the given InputStream as an XML document and return a new DOM Document object.
                        document=builder.parse(new ByteArrayInputStream(car_package .getBytes())); //Parse the content of the given InputStream as an XML document and return a new DOM Document object.
                        
                        
                        ITextRenderer itxtrenderer = new ITextRenderer();
                        itxtrenderer.setDocument(document,null);
                        itxtrenderer.layout();
                        itxtrenderer.createPDF(os,true);  // creates PDF from the XML document and writes to outputstream.
                  } catch (ParserConfigurationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
 
                  } catch (SAXException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                  }
                    catch (DocumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    }
                 os.flush();
                 os.close();
 
                        }
 
}
 
