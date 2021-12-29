import java.awt.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static DatabaseSqlite db;

    public static void main(String[] args) throws SQLException, FileNotFoundException, UnsupportedEncodingException {
        db = new DatabaseSqlite("jdbc:sqlite:src/main/resources/sport.db");
        //db.addTableTournament();
        //getData().forEach(db::addDataToTournamentTable);

        firstTask();
        secondTask();
        thirdTask();
        db.disconnectDB();
    }

    private static void firstTask() throws SQLException {
        Map<String, Integer> amounts = new HashMap<>();
        String sql = "" +
                "select distinct section, sum(participants) as amount " +
                "from Tournament " +
                "group by section;";

        ResultSet result = db.request.executeQuery(sql);

        while (result.next()) {
            amounts.put(result.getString("section"), Integer.parseInt(result.getString("amount")));
        }

        EventQueue.invokeLater(() -> {
            var ex = new BarChart(amounts);
            ex.setVisible(true);
        });
    }

    private static void secondTask() throws SQLException {
        String sql = "" +
                "select country, sum(participants) as amount " +
                "from Tournament " +
                "where year = 2008 " +
                "group by country;";

        ResultSet result = db.request.executeQuery(sql);
        while (result.next()) {
            System.out.println(String.format("" +
                    "В регионе %s всего было %s участников",
                    result.getString("country"), result.getString("amount")));
        }
    }

    private static void thirdTask() throws SQLException {
        String sql = "" +
                "select title, max(participants) " +
                "from Tournament " +
                "where subsection == 'Молодежный (резервный) состав' " +
                "    and section == 'Восточное боевое единоборство';";

        System.out.println(String.format("" +
                "\nСамое массовое мероприятие по восточным боевым единоборствам: %s\n",
                db.request.executeQuery(sql).getString("title")));
    }

    private static ArrayList<Tournament> getData() throws UnsupportedEncodingException, FileNotFoundException {
        ArrayList<Tournament> tournaments = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(new FileInputStream("src/main/resources/Sport.csv"), "windows-1251");
        try (BufferedReader reader = new BufferedReader(isr)) {
            reader.readLine();
            while (reader.ready()) {
                String line = reader.readLine();
                int commaCount = 0;
                int from = 0, to = 0;
                boolean flag = true;
                for (int i = 0; i < line.length(); i++) {
                    if (commaCount == 3 && flag) {
                        from = i;
                        flag = false;
                    } if (line.charAt(i) == ',' && flag)
                        commaCount++;
                    StringBuilder caseColumn = new StringBuilder();
                    for (int j = 0; j < 4; j++)
                        caseColumn.append(line.charAt(i + j));
                    if (caseColumn.toString().equals(",\"20") && !flag) {
                        to = i + 1;
                        break;
                    }
                }
                String[] data = String
                        .join("", line.substring(0, from), line.substring(to))
                        .replaceAll("\"", "")
                        .split(",");
                int shift = 0;
                if (data.length == 9)
                    shift = 1;
                if (data.length == 11)
                    shift = 3;
                int participants = data[7 + shift].equals(" -") ? 0 : Integer.parseInt(data[7 + shift]);
                String section = data[0];
                int year = Integer.parseInt(data[4].split("-")[0]);
                String country = data[6].split(",")[0];
                String title = data[2];
                String subsection = data[1];
                tournaments.add(new Tournament(participants, section, year, country, title, subsection));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tournaments;
    }
}
