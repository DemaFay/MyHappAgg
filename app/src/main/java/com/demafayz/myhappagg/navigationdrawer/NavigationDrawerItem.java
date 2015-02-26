package com.demafayz.myhappagg.navigationdrawer;

/**
 * Created by DemaFayz on 03.02.2015.
 */
public class NavigationDrawerItem {
    private String title;
    private int icon;
    public NavigationDrawerItem (String title, int icon) {
        super();
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
