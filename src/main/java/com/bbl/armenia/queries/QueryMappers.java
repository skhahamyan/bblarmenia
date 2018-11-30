package com.bbl.armenia.queries;

import com.bbl.armenia.company.Company;
import com.bbl.armenia.user.Credential;
import com.bbl.armenia.user.Identity;
import com.bbl.armenia.user.Knowledge;
import com.bbl.armenia.user.Speaker;
import com.bbl.armenia.user.User;
import org.jooq.Record;
import org.jooq.generated.tables.records.KnowledgeRecord;

import java.util.Objects;

import static org.jooq.generated.tables.Company.COMPANY;
import static org.jooq.generated.tables.Credential.CREDENTIAL;
import static org.jooq.generated.tables.Speaker.SPEAKER;

class QueryMappers {
    static Knowledge mapKnowledge(KnowledgeRecord knowledgeRecord) {
        Knowledge knowledge = new Knowledge(knowledgeRecord.getTitle(), knowledgeRecord.getDescription());
        knowledge.setId(knowledgeRecord.getId());
        return knowledge;
    }

    static Speaker mapSpeaker(Record record) {
        Credential credential = new Credential(record.get(CREDENTIAL.USERNAME));
        Identity identity = new Identity(record.get(SPEAKER.FIRST_NAME), record.get(SPEAKER.LAST_NAME));
        User user = new User(credential, identity, record.get(SPEAKER.EMAIL), record.get(SPEAKER.PHONE_NUMBER));
        Speaker speaker = new Speaker(user);

        if (Objects.nonNull(record.get(SPEAKER.COMPANY_ID))) {
            Company company = new Company(record.get(COMPANY.ID), record.get(COMPANY.NAME));
            speaker.setCompany(company);
        }

        return speaker;
    }
}
