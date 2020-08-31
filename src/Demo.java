import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class Demo {

    public static void main(String args[]) throws IOException {
        System.out.println("Hello world");

        PDDocument document1 = new PDDocument();

        //adding 10 blank pages...
        for(int i=0;i<=9;i++) {
            PDPage my_page = new PDPage();
            document1.addPage(my_page);
        }

        document1.save("test.pdf");
        System.out.println("PDF Created");

        File file = new File("test.pdf");
        PDDocument document = PDDocument.load(file);

        System.out.println("Reading Files...");
        //Retrieving the pages of the document
        PDPage page = document.getPage(1);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        //Begin the Content stream
        contentStream.beginText();

        //Setting the font to the Content stream
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

        //Setting the leading
        contentStream.setLeading(14.5f);

        //Setting the position for the line
        contentStream.newLineAtOffset(25, 725);

        String text = "This is the sample document and we are adding content to it.";
        String text2 = "as we want like this using the ShowText()  method of the ContentStream class";


        //Adding text in the form of string
        contentStream.showText(text);

        contentStream.newLine();
        contentStream.showText(text2);

        //Ending the content stream
        contentStream.endText();

        System.out.println("Content added");

        //Closing the content stream
        contentStream.close();

        //Saving the document
        document.save(new File("new.pdf"));





        document.close();
    }
}

