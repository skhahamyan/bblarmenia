package com.bbl.armenia.queries;

import com.bbl.armenia.company.Company;
import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class CompanyQuery implements ReadOperation<Company>, WriteOperation<Company>, PurgeOperation {
    @Override
    public List<Company> getAll() {
        return null;
    }

    @Override
    public Company getById(Long id) {
        return null;
    }

    @Override
    public void create(Company model) {

    }

    @Override
    public void update(Company model) {

    }

    @Override
    public void delete(Long id) {

    }
}
