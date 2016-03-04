package com.company;

class HighScore {
    private String id;
    private String name;
    private Integer score;
    private Integer kills;



    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HighScore(String id, String name, Integer score, Integer kills) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.kills = kills;
    }
}
