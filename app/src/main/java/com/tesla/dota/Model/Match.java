package com.tesla.dota.Model;


public class Match {
    /* Fields */

    private String mTeam1;
    private String mTeam2;
    private String mResults1;
    private String mResults2;

    /* Constructors */

    /**
     *
     * @param mTeam1 Name of Team 1
     * @param mTeam2 Name of Team 2
     * @param mResults1 Results of Team 1
     * @param mResults2 Results of Team 2
     */
    public Match(String mTeam1, String mTeam2, String mResults1, String mResults2){

        this.mTeam1 = mTeam1;
        this.mTeam2 = mTeam2;
        this.mResults1 = mResults1;
        this.mResults2 = mResults2;

    }

    /* Getter Setters */

    public String getTeam1() {
        return mTeam1;
    }

    public void setTeam1(String mTeam1) {
        this.mTeam1 = mTeam1;
    }

    public String getTeam2() {
        return mTeam2;
    }

    public void setTeam2(String mTeam2) {
        this.mTeam2 = mTeam2;
    }

    public String getResults1() {
        return mResults1;
    }

    public void setResults1(String mResults1) {
        this.mResults1 = mResults1;
    }

    public String getResults2() {
        return mResults2;
    }

    public void setResults2(String mResults2) {
        this.mResults2 = mResults2;
    }
}
