import java.sql.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import java.sql.Connection;

public class Main {

    private static String url = "jdbc:mysql://localhost:3306/Weather";
    private static String username = "root";
    private static String password = "DeWWsh123";

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            System.out.println("Connection to Weather DB succesfull!");
            LOG.info("Connection to Weather DB succesfull!");
        }

        Statement statement = connection.createStatement();

        LOG.info("Weather information in Rome");
        ResultSet resultSet = statement.executeQuery("select date, temperature, precipitation, name\n" +
                "\t\tfrom weather, region\n" +
                "        where weather.weather_id = region.weather_id and region.name like 'Rome';");
        while(resultSet.next()){

            Date date = resultSet.getDate(1);
            int temperature = resultSet.getInt(2);
            int  precipitation = resultSet.getInt(3);
            String name = resultSet.getString(4);
            LOG.info("\nDate: "+date+" \nTemperature: "+temperature+" degrees\n" +
                    "Precipitation: "+precipitation+" mm\nRegion: "+name);
        }

        LOG.info("\n_____________________________________________\n");

        LOG.info("Weather information in Minsk where temperature <0  and precipitation >10");
        ResultSet resultSet1 = statement.executeQuery("\tselect date, temperature, precipitation, name\n" +
                "\t\tfrom weather, region\n" +
                "        where weather.weather_id = region.weather_id and (temperature <0  and precipitation >10);");
        while(resultSet1.next()) {

            Date date = resultSet1.getDate(1);
            int temperature = resultSet1.getInt(2);
            int precipitation = resultSet1.getInt(3);
            String name = resultSet1.getString(4);
            LOG.info("\nDate: " + date + " \nTemperature: " + temperature + " degrees\n" +
                    "Precipitation: " + precipitation + " mm\nRegion: " + name);
        }

        LOG.info("\n_____________________________________________\n");

        LOG.info("Information about the weather over the past week in the regions\n" +
                "whose inhabitants communicate in French");
        ResultSet resultSet2 = statement.executeQuery("select date, temperature, precipitation, name, language\n" +
                "\t\tfrom weather, region, inhabitant_type\n" +
                "        where weather.weather_id = region.weather_id and region.id_type = inhabitant_type.id_type\n" +
                "\t\t\tand language like 'French' and date >  curdate() - interval 7 day;");
        while(resultSet2.next()) {

            Date date = resultSet2.getDate(1);
            int temperature = resultSet2.getInt(2);
            int precipitation = resultSet2.getInt(3);
            String name = resultSet2.getString(4);
            String language = resultSet2.getString(5);
            LOG.info("\nDate: " + date + " \nTemperature: " + temperature + " degrees\n" +
                    "Precipitation: " + precipitation + " mm\nRegion: " + name + " \nLanguage: " + language);
        }

        LOG.info("\n_____________________________________________\n");

        LOG.info("last week's average temperature in regions with\n" +
                "area of more than 350.");
        ResultSet resultSet3 = statement.executeQuery("select avg(temperature), name, area, date\n" +
                "\t\tfrom weather, region\n" +
                "        where weather.weather_id = region.weather_id and area > '350' and date >  curdate() - interval 7 day\n" +
                "        group by name, area, date;");
        while(resultSet3.next()) {

            int temperature = resultSet3.getInt(1);
            String name = resultSet3.getString(2);
            String area = resultSet3.getString(3);
            Date date = resultSet3.getDate(4);
            LOG.info(" \nTemperature: " + temperature + " degrees\n" + " Region: " + name
                    + " \nArea: " + area + "\nDate: " + date);
        }

        LOG.info("\n_____________________________________________\n");
        LOG.info("))))))");
        ResultSet resultSet4 = statement.executeQuery("select avg(temperature), name, area, date\n" +
                "\t\tfrom weather, region\n" +
                "        where weather.weather_id = region.weather_id and area > '350' and date >  curdate() - interval 7 day\n" +
                "        group by name, area, date;");
        while(resultSet3.next()) {

            int temperature = resultSet4.getInt(1);
            String name = resultSet4.getString(2);
            String area = resultSet4.getString(3);
            Date date = resultSet4.getDate(4);
            LOG.info(" \nTemperature: " + temperature + " degrees\n" + " Region: " + name
                    + " \nArea: " + area + "\nDate: " + date);
        }
    }
}
