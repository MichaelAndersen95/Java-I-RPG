package com.company;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.*;

class HighScoreHandler {

    private final DBHelper dbHelper = new DBHelper();
    private final UI ui = new UI();
    private final XMLHandler xmlHandler = new XMLHandler();
    private final String sqlError = "\nCan't connect to database\n";

    /**
     * gets all high scores from database ordered by highest score
     */
    public void getAllHighScoresByScore() {
        try {
            Connection conn = dbHelper.getConnection();
            String query = "SELECT * FROM HighScores ORDER BY Score DESC";
            Statement statement;
            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String name = resultSet.getString("Name");
                int score = resultSet.getInt("Score");
                int kills = resultSet.getInt("Kills");

                String output = "Score: %s Name: %s Kills: %s\n";
                ui.print(String.format(output, score, name, kills));
            }
        } catch (SQLException e) {
            ui.print(sqlError);
        }
    }

    /**
     * gets all high scores from database ordered by most kills
     */
    public void getAllHighScoresByKills() {
        try {
            Connection conn = dbHelper.getConnection();
            String query = "SELECT * FROM HighScores ORDER BY Kills DESC";

            Statement statement;
            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String name = resultSet.getString("Name");
                int score = resultSet.getInt("Score");
                int kills = resultSet.getInt("Kills");

                String output = "Kills: %s Name: %s Score: %s\n";
                ui.print(String.format(output, kills, name, score));
            }
        } catch (SQLException e) {
            ui.print(sqlError);
        }
    }

    public void getHighScoresFromXML() {
        try {
            xmlHandler.readXML();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();

        }

    }

    public void saveHighScoreToXML(String player, Integer score, Integer kills) {
        xmlHandler.writeXML(player, score, kills);
    }

    /**
     * Save players high score to database
     * @param name players name
     * @param score players score (level * xp)
     * @param kills players kills
     */
    public void saveHighScore(String name, Integer score, Integer kills) {
        try {
            Connection conn = dbHelper.getConnection();
            String query = "INSERT INTO HighScores (Name, Score, Kills) VALUES (?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, score);
            statement.setInt(3, kills);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ui.print("High score saved successfully!");
            }
        } catch (SQLException e) {
            ui.print(sqlError);
        }
    }

}
