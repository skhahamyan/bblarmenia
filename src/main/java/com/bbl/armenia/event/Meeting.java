package com.bbl.armenia.event;

import com.bbl.armenia.company.Company;
import com.bbl.armenia.tools.TextTool;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Meeting implements Serializable {
    private static final long serialVersionUID = 1231554748187356198L;

    private Company company;
    private LocalDateTime date;

    public Meeting(Company company, LocalDateTime date) {
        this.company = company;
        this.date = date;
    }

    public Company getCompany() {
        return company;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
