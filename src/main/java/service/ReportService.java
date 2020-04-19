package service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import models.Division;
import service.stats.StatsService;
import service.stats.models.CourseStats;
import service.stats.models.HoleStats;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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

        // normalize filename from title
        PdfWriter.getInstance(document, new FileOutputStream("report1.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 12, BaseColor.BLACK);
        Chunk chunk = new Chunk(title + " - "+ division.getName() + "\n\n", font);

        Paragraph paragraph = new Paragraph(chunk);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(6);

        CourseStats courseStats = StatsService.GetHoleAverage(division);
        addTableHeader(table, Stream.of("Hole #", "Par", "Average", "Pars", "Birdies", "Eagles")); // par
        for (HoleStats entry : courseStats.getHoleStats()) {
            addRows(table, entry);
        }

        // footer sum
        table.addCell("");
        table.addCell(courseStats.getCourse().getTotalPar() + "");
        table.addCell("average tot");
        table.addCell("");
        table.addCell("");
        table.addCell("");

        document.add(table);
        document.newPage();

        //CourseStats courseStats = StatsService.getCountedPlayerScores(division);

        document.close();
    }

    /**
     *
     * @param table
     */
    private static void addRows(PdfPTable table, HoleStats hole) {
        table.addCell(Integer.toString(hole.getHoleNumber()));
        table.addCell(Integer.toString(hole.getPar()));
        table.addCell(formatter.format(hole.getAverage()));
        table.addCell(Long.toString(hole.getPars()));
        table.addCell(Long.toString(hole.getBirdies()));
        table.addCell(Long.toString(hole.getEagles()));

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
                    header.setHorizontalAlignment(1);
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

}
