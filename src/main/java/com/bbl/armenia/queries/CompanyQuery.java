package com.bbl.armenia.queries;

import com.bbl.armenia.user.Speaker;
import com.google.inject.Singleton;

@Singleton
public class CompanyQuery implements ReadOperation, WriteOperation<Speaker>, PurgeOperation {
    @Override
    public void getAll() {

    }

    @Override
    public void getById() {

    }

    @Override
    public void create(Speaker model) {

    }

    @Override
    public void update(Long id, Speaker model) {

    }

    @Override
    public void delete(Long id) {

    }
}
