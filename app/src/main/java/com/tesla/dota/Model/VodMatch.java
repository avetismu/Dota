package com.tesla.dota.Model;

/**
 * Created by tesla on 07/12/14.
 */
public class VodMatch extends Match{

    /* Fields */
    private String url;

    /* Constructors */

    /**
     *
     * @param url Youtube video ID
     * @param team1 name of Team 1
     * @param team2 name of Team 2
     * @param results1 results of Team 1
     * @param results2 results of Team 2
     */
    public VodMatch(String url, String team1, String team2, String results1, String results2){
        super(team1, team2, results1, results2);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
