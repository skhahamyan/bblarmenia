package com.bbl.armenia.queries;

import com.google.inject.Inject;

public class QueryService<T> implements ReadOperation, WriteOperation<T>, PurgeOperation {
    private final ReadOperation readOperation;
    private final WriteOperation writeOperation;
    private final PurgeOperation purgeOperation;

    @Inject
    public QueryService(ReadOperation readOperation, WriteOperation writeOperation, PurgeOperation purgeOperation) {
        this.readOperation = readOperation;
        this.writeOperation = writeOperation;
        this.purgeOperation = purgeOperation;
    }

    @Override
    public void getAll() {
        readOperation.getAll();
    }

    @Override
    public void getById() {
        readOperation.getById();
    }

    @Override
    public void create(T model) {
        writeOperation.create(model);
    }

    @Override
    public void update(Long id, T model) {
        writeOperation.update(id, model);
    }

    @Override
    public void delete(Long id) {
        purgeOperation.delete(id);
    }
}
