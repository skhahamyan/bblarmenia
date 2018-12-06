package com.bbl.armenia.event;

import com.bbl.armenia.company.Company;
import com.bbl.armenia.tools.TextTool;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Meeting implements Serializable {
    private static final long serialVersionUID = 1231554748187356198L;

    @Expose
    private Company company;
    @Expose
    private String date;
    @Expose
    private boolean accepted;
    @Expose
    private boolean canceled;

    public Meeting(Company company, String date) {
        this.company = company;
        this.date = date;
    }

    public Company getCompany() {
        return company;
    }

    public String getDate() {
        return date;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
