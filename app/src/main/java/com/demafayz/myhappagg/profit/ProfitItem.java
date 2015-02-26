package com.demafayz.myhappagg.profit;

/**
 * Created by DemaFayz on 06.02.2015.
 */
public class ProfitItem {
    private long id;
    private String title;
    private String subTitle;
    private double sum;
    private String deta;

    public ProfitItem(long id, String title, String subTitle, double sum, String deta) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.sum = sum;
        this.deta = deta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subTitle;
    }

    public void setSubtitle(String subtitle) {
        this.subTitle = subtitle;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public String getDeta() {
        return deta;
    }

    public void setDeta(String deta) {
        this.deta = deta;
    }
}
