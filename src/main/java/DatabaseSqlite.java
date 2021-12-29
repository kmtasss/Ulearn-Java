import java.awt.*;
import java.sql.*;

public class DatabaseSqlite {
    private Connection connection;
    public Statement request;

    public DatabaseSqlite(String path) throws SQLException {
        connectDb(path);
    }

    private void connectDb(String path) throws SQLException {
        connection = DriverManager.getConnection(path);
        request = connection.createStatement();
    }

    public void disconnectDB() throws SQLException {
        request.close();
        connection.close();
    }

    public void addTableTournament() throws SQLException {
        request.execute(
                "CREATE TABLE IF NOT EXISTS Tournament (" +
                        "participants INTEGER," +
                        "section TEXT," +
                        "year INTEGER," +
                        "country TEXT," +
                        "title TEXT," +
                        "subsection TEXT);"
        );
    }

    public void addDataToTournamentTable(Tournament tournament) {
        String sql = String.format(
                "INSERT INTO Tournament (participants, section, year, country, title, subsection)" +
                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');",
                tournament.getParticipants(),
                tournament.getSection(),
                tournament.getYear(),
                tournament.getCountry(),
                tournament.getTitle(),
                tournament.getSubsection()
        );
        try {
            request.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
