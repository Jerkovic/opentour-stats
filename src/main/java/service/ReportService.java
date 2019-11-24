package service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import models.Division;
import service.stats.StatsService;
import service.stats.models.HoleAverage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.stream.Stream;

public class ReportService {

    private static NumberFormat formatter = new DecimalFormat("#0.00");

    /**
     *
     * @param title
     * @param division
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    public static void createPDF(String title, Division division) throws FileNotFoundException, DocumentException {
        Document document = new Document();

        // normalize filename here

        PdfWriter.getInstance(document, new FileOutputStream("report1.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk(title + " - "+ division.getName() + "\n\n", font);

        Paragraph paragraph = new Paragraph(chunk);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(3);


        //addCustomRows(table);
        addTableHeader(table, Stream.of("Hole #", "Par", "Average")); // par
        for (HoleAverage entry : StatsService.GetHoleAverage(division)) {
            addRows(table, entry);
        }

        document.add(table);
        document.close();
    }

    /**
     *
     * @param table
     */
    private static void addRows(PdfPTable table, HoleAverage hole) {
        table.addCell(Integer.toString(hole.getHoleNumber()));
        table.addCell(Integer.toString(hole.getPar()));
        table.addCell(formatter.format(hole.getAverage()));
    }

    /**
     *
     * @param table
     */
    private static void addTableHeader(PdfPTable table, Stream<String> headerStream) {
        headerStream
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

}
