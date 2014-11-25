package com.tesla.dota.Model;


public class VodObject {
    /* Fields */

    private String team1;
    private String team2;
    private String results1;
    private String results2;

    /* Constructors */

    public VodObject(String team1, String team2, String results1, String results2){

        this.team1 = team1;
        this.team2 = team2;
        this.results1 = results1;
        this.results2 = results2;

    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getResults1() {
        return results1;
    }

    public void setResults1(String results1) {
        this.results1 = results1;
    }

    public String getResults2() {
        return results2;
    }

    public void setResults2(String results2) {
        this.results2 = results2;
    }
}
