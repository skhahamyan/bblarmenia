package com.bbl.armenia.queries;

import com.bbl.armenia.company.Company;
import com.bbl.armenia.event.Event;
import com.bbl.armenia.event.Meeting;
import com.bbl.armenia.tools.TextTool;
import com.bbl.armenia.user.*;
import org.jooq.Record;
import org.jooq.generated.tables.records.KnowledgeRecord;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

import static org.jooq.generated.tables.Company.COMPANY;
import static org.jooq.generated.tables.Credential.CREDENTIAL;
import static org.jooq.generated.tables.Event.EVENT;
import static org.jooq.generated.tables.Knowledge.KNOWLEDGE;
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
        speaker.setId(record.get(SPEAKER.ID));

        if (Objects.nonNull(record.get(SPEAKER.COMPANY_ID))) {
            Company company = new Company(record.get(COMPANY.ID), record.get(COMPANY.NAME));
            speaker.setCompany(company);
        }

        return speaker;
    }

    static Event mapEvent(Record record) {
        Instant instant = Instant.ofEpochMilli(record.get(EVENT.MEETING_DATE).getTime());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Yerevan"));

        Company company = new Company(record.get(COMPANY.ID), record.get(COMPANY.NAME));
        Meeting meeting = new Meeting(company, TextTool.fromDateToString(localDateTime));
        meeting.setAccepted(record.get(EVENT.EVENT_ACCEPTED, Boolean.class));
        meeting.setCanceled(record.get(EVENT.EVENT_CANCELED, Boolean.class));
        Knowledge knowledge = new Knowledge(record.get(KNOWLEDGE.TITLE), record.get(KNOWLEDGE.DESCRIPTION));
        Event event = new Event(meeting, knowledge);
        return event;
    }
}
