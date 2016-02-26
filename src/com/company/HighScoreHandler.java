package com.company;

import java.sql.*;

public class HighScoreHandler {

    DBHelper dbHelper = new DBHelper();

    /**
     * gets all high scores from database ordered by highest score
     * @throws SQLException
     */
    public void getAllHighScores() throws SQLException {
        Connection conn = dbHelper.getConnection();
        String query = "SELECT * FROM Highscores ORDER BY Score DESC";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            String name = resultSet.getString("Name");
            int score = resultSet.getInt("Score");

            String output = "Score: %s Name: %s";
            System.out.println(String.format(output, score, name));
        }
    }

    /**
     * Save players score to database
     * @param name players name
     * @param score players score (level * xp)
     * @throws SQLException
     */
    public void saveHighScore(String name, Integer score) throws SQLException {
        Connection conn = dbHelper.getConnection();

        String query = "INSERT INTO Highscores (Name, Score) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, name);
        statement.setInt(2, score);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("High score saved successfully!");
        }
    }

}
