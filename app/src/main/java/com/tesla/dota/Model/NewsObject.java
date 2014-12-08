package com.tesla.dota.Model;

/**

 */
public class NewsObject {

    /* Fields */

    //ID of the News Object
    private int mID;
    //Title, First Headline to be Displayed
    private String mTitle;
    //Summary, to be displayed under/with Title as subtitle
    private String mSummary;
    //category of news, i.e. competitive, tournament, editorial, stats, etc
    private String mCategory;
    //Body of the News object
    private String mContent;


    /* Constructors */

    //non-empty public constructor
    public NewsObject(int ID, String Title, String Summary, String Category, String Content){
        //assigns parameters to fields
        this.mID= ID;
        this.mTitle=Title;
        this.mSummary=Summary;
        this.mCategory = Category;
        this.mContent = Content;


    }

    /* Accessors and Mutators */

    //Getters

    public int getmID() {
        return mID;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmSummary() {
        return mSummary;
    }

    public String getmCategory() {
        return mCategory;
    }

    public String getmContent() {
        return mContent;
    }


    //Setters

    public void setmID(int mID) {
        this.mID = mID;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }
}
