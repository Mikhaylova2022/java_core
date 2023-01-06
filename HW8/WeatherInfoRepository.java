package lesson8.HW8;

import java.sql.*;
import java.util.Date;

public class WeatherInfoRepository {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "11";

    public void updateWeatherInfo(WeatherInfoDTO weatherInfoDTO) {
        WeatherInfoDTO exist = getWeatherInfo(weatherInfoDTO.getKey());
        if (exist == null) {
            saveWeatherInfo(weatherInfoDTO);
        } else {
            try (Connection connect = getConnection();
                 PreparedStatement ps = connect.prepareStatement("UPDATE weather SET city_name = ?, date = ?, text = ?, temperature = ? WHERE key = ?")) {
                fillUpdatePreparedStatement(ps, weatherInfoDTO);
                ps.execute();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private void fillUpdatePreparedStatement(PreparedStatement ps, WeatherInfoDTO weatherInfoDTO) throws SQLException {
        Date date = weatherInfoDTO.getDate();
        ps.setString(1, weatherInfoDTO.getName());
        ps.setTimestamp(2, date == null ? null : new Timestamp(date.getTime()));
        ps.setString(3, weatherInfoDTO.getWeatherText());
        ps.setDouble(4, weatherInfoDTO.getTemperature());
        ps.setInt(5, weatherInfoDTO.getKey());
    }

    public void saveWeatherInfo(WeatherInfoDTO weatherInfoDTO) {
        try (Connection connect = getConnection();
             PreparedStatement ps = connect.prepareStatement("INSERT INTO weather VALUES (?,?,?,?,?)")) {
            fillSavePreparedStatement(ps, weatherInfoDTO);
            ps.execute();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private void fillSavePreparedStatement(PreparedStatement ps, WeatherInfoDTO weatherInfoDTO) throws SQLException {
        Date date = weatherInfoDTO.getDate();
        ps.setInt(1, weatherInfoDTO.getKey());
        ps.setString(2, weatherInfoDTO.getName());
        ps.setTimestamp(3, date == null ? null : new Timestamp(date.getTime()));
        ps.setString(4, weatherInfoDTO.getWeatherText());
        ps.setDouble(5, weatherInfoDTO.getTemperature());
    }

    public WeatherInfoDTO getWeatherInfo(Integer cityKey) {
        try (Connection connect = getConnection();
             PreparedStatement ps = connect.prepareStatement("SELECT * FROM weather")) {
            return getCity(ps.executeQuery());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private WeatherInfoDTO getCity(ResultSet resultSet) throws SQLException {
        resultSet.next();

        Timestamp date = resultSet.getTimestamp("date");

        WeatherInfoDTO weatherInfoDTO = new WeatherInfoDTO();
        weatherInfoDTO.setKey(resultSet.getInt("key"));
        weatherInfoDTO.setName(resultSet.getString("city_name"));
        weatherInfoDTO.setDate(date == null ? null : new Date(date.getTime()));
        weatherInfoDTO.setWeatherText(resultSet.getString("text"));
        weatherInfoDTO.setTemperature(resultSet.getDouble("temperature"));

        return weatherInfoDTO;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}