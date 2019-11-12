import com.google.gson.Gson;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import models.*;
import service.ReportService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Application {

    public static void main(String[] args) throws DocumentException, FileNotFoundException {

        OpentourClient otc = new OpentourClient("some");
        String jsonResult = otc.getTournament("3339739869705560164");

        Gson gson = new Gson();
        Tournament tournament1 = gson.fromJson(jsonResult, Tournament.class);

        System.out.println(tournament1.getName());

        ReportService.createPDF(tournament1.getName(), tournament1.getDivisions().stream().findFirst().get());


    }


}

