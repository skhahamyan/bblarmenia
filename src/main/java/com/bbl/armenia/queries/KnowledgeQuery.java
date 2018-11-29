package com.bbl.armenia.queries;

import com.bbl.armenia.server.Database;
import com.bbl.armenia.user.Knowledge;
import com.google.inject.Singleton;
import org.jooq.Result;
import org.jooq.generated.tables.records.KnowledgeRecord;

import java.util.List;
import java.util.stream.Collectors;

import static org.jooq.generated.tables.Knowledge.KNOWLEDGE;

@Singleton
public class KnowledgeQuery implements ReadOperation<Knowledge>, WriteOperation<Knowledge>, PurgeOperation {
    public KnowledgeQuery() {
        // Test needs default constructor
    }

    @Override
    public List<Knowledge> getAll() {
        Result<KnowledgeRecord> knowledgeRecords = Database.getJOOQ().selectFrom(KNOWLEDGE).fetch();
        return knowledgeRecords.stream().map(QueryMappers::map).collect(Collectors.toList());
    }

    @Override
    public Knowledge getById(Long id) {
        KnowledgeRecord knowledgeRecord = Database.getJOOQ().selectFrom(KNOWLEDGE)
                .where(KNOWLEDGE.ID.eq(id)).fetchOne();
        return QueryMappers.map(knowledgeRecord);
    }

    public List<Knowledge> getBySpeakerId(Long speakerId) {
        Result<KnowledgeRecord> knowledgeRecords = Database.getJOOQ().selectFrom(KNOWLEDGE)
                .where(KNOWLEDGE.SPEAKER_ID.eq(speakerId)).fetch();
        return knowledgeRecords.stream().map(QueryMappers::map).collect(Collectors.toList());
    }

    @Override
    public void create(Knowledge model) {

    }

    public void create(Knowledge knowledge, Long speakerId) {
        Database.getJOOQ().insertInto(KNOWLEDGE, KNOWLEDGE.TITLE, KNOWLEDGE.DESCRIPTION, KNOWLEDGE.SPEAKER_ID)
                .values(knowledge.getTitle(), knowledge.getDescription(), speakerId)
                .execute();
    }

    @Override
    public void update(Knowledge knowledge) {
        Database.getJOOQ().update(KNOWLEDGE)
                .set(KNOWLEDGE.TITLE, knowledge.getTitle())
                .set(KNOWLEDGE.DESCRIPTION, knowledge.getDescription())
                .where(KNOWLEDGE.ID.eq(knowledge.getId()))
                .execute();
    }

    @Override
    public void delete(Long id) {
        Database.getJOOQ().delete(KNOWLEDGE)
                .where(KNOWLEDGE.ID.eq(id))
                .execute();
    }

    void deleteBySpeakerId(Long speakerId) {
        Database.getJOOQ().delete(KNOWLEDGE)
                .where(KNOWLEDGE.SPEAKER_ID.eq(speakerId))
                .execute();
    }
}
