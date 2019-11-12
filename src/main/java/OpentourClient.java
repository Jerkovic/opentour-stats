import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class OpentourClient {

    private String authToken;

    /**
     *
     * @param String token
     */
    public OpentourClient (String token) {
        this.authToken = "3339739869705530119:6882b51f3d07650c87923dbe7b31a28d";
    }

    /**
     *
     * @param tournamentId
     * @return
     */
    public String getTournament(String tournamentId) {
        String url = "http://www.opentour.se/webapi/tournament/" + tournamentId + "?auth=" + authToken;
        return _doGet(url);
    }

    public String getDivision(String divisionId) {
        String url = "http://www.opentour.se/webapi/division/" + divisionId + "?auth=" + authToken;
        return _doGet(url);
    }

    /**
     *
     * @param endPointUrl
     * @param auth
     * @return
     */
    private static String _doGet(String endPointUrl) {

        StringBuffer response = new StringBuffer();

        try {
            URL obj = new URL(endPointUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Language", "en-US");
            con.setRequestProperty("Accept", "application/json");
            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }


}
