package com.company;

import java.sql.*;

public class HighScoreHandler {

    DBHelper dbHelper = new DBHelper();

    /**
     * gets all high scores from database ordered by highest score
     * @throws SQLException
     */
    public void getAllHighScoresByScore() throws SQLException {
        Connection conn = dbHelper.getConnection();
        String query = "SELECT * FROM HighScores ORDER BY Score DESC";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            String name = resultSet.getString("Name");
            int score = resultSet.getInt("Score");
            int kills = resultSet.getInt("Kills");

            String output = "Score: %s Name: %s Kills: %s";
            System.out.println(String.format(output, score, name, kills));
        }
    }

    /**
     * gets all high scores from database ordered by most kills
     * @throws SQLException
     */
    public void getAllHighScoresByKills() throws SQLException {
        Connection conn = dbHelper.getConnection();
        String query = "SELECT * FROM HighScores ORDER BY Kills DESC";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            String name = resultSet.getString("Name");
            int score = resultSet.getInt("Score");
            int kills = resultSet.getInt("Kills");

            String output = "Kills: %s Name: %s Score: %s";
            //not working
            System.out.println(String.format(output, kills, name, score));
        }
    }

    /**
     * Save players high score to database
     * @param name players name
     * @param score players score (level * xp)
     * @param kills players kills
     * @throws SQLException
     */
    public void saveHighScore(String name, Integer score, Integer kills) throws SQLException {
        Connection conn = dbHelper.getConnection();
        String query = "INSERT INTO HighScores (Name, Score, Kills) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, name);
        statement.setInt(2, score);
        statement.setInt(3, kills);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("High score saved successfully!");
        }
    }

}
