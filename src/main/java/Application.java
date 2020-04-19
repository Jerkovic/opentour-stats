import com.google.gson.Gson;
import com.itextpdf.text.*;
import models.*;
import service.ReportService;
import service.stats.StatsService;

import java.io.FileNotFoundException;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Application {

    public static void main(String[] args) throws DocumentException, FileNotFoundException {

        String sodertalje = "3339739869705530119:6882b51f3d07650c87923dbe7b31a28d";
        String footgolfto = "3360844664688609549:0c07188690537b5f4e3cdcbca39fb9b8";

        OpentourClient otc = new OpentourClient(footgolfto);
        String jsonResult = otc.getTournament("3360844664688609934");

        Gson gson = new Gson();
        Tournament tournament1 = gson.fromJson(jsonResult, Tournament.class);

        System.out.println(tournament1.getName());
        Division herr = tournament1.getDivisions().stream().findFirst().get();

        Arrays.asList(Score.values()).forEach(System.out::println);

        StatsService.getHoleWinners(herr);
        ReportService.createPDF(tournament1.getName(), tournament1.getDivisions().stream().findFirst().get());


    }


}

