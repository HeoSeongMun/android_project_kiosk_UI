package com.example.kiosk;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable ;
    private String menuStr;
    private String numbertr ;
    private String payStr ;

    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public void setMenu(String menu) {
        menuStr = menu ;
    }
    public void setNum(String num) {
        numbertr = num ;
    }
    public void setPay(String pay) {
        payStr = pay ;
    }

    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public String getMenu() {
        return this.menuStr ;
    }
    public String getNum() {
        return this.numbertr ;
    }
    public String getPay() {
        return this.payStr ;
    }


}
