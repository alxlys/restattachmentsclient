package org.cxf.demo.restattachmentsclient;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

import javax.ws.rs.core.MediaType;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author olysenko
 */
public class FileClient {

   public static void main(String[] args) throws FileNotFoundException {

      WebClient client =
            WebClient.create("http://localhost:8080/restattachments/services/fileService/upload");
      client.type(MediaType.MULTIPART_FORM_DATA);
      ContentDisposition cd = new ContentDisposition("attachment;filename=pic.jpg");

      Attachment attachment = new Attachment("root", new FileInputStream(
            System.getProperty("user.dir") + System.getProperty("file.separator") + "filestore" +
                  System.getProperty("file.separator") + "pic.jpg"), cd);

      client.post(attachment);

   }

}
