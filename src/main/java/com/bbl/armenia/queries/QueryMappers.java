package com.bbl.armenia.queries;

import com.bbl.armenia.user.Knowledge;
import org.jooq.generated.tables.records.KnowledgeRecord;

class QueryMappers {
    static Knowledge map(KnowledgeRecord knowledgeRecord) {
        Knowledge knowledge = new Knowledge(knowledgeRecord.getTitle(), knowledgeRecord.getDescription());
        knowledge.setId(knowledgeRecord.getId());
        return knowledge;
    }
}
