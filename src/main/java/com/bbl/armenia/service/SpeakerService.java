package com.bbl.armenia.service;

import com.bbl.armenia.queries.PurgeOperation;
import com.bbl.armenia.queries.WriteOperation;
import com.bbl.armenia.tools.User;
import com.bbl.armenia.user.Speaker;
import com.bbl.armenia.ws.SpeakerServiceDefinition;
import com.google.inject.Inject;

import javax.ws.rs.Path;

import static javax.ws.rs.core.Response.Status.*;

@Path("speaker")
public class SpeakerService implements SpeakerServiceDefinition {
    private WriteOperation<Speaker> writeOperation;
    private PurgeOperation purgeOperation;

    @Inject
    public SpeakerService(@User WriteOperation writeOperation, @User PurgeOperation purgeOperation) {
        this.writeOperation = writeOperation;
        this.purgeOperation = purgeOperation;
    }

    @Override
    public String getAllSpeakers() {
        return "Got it !";
    }

    @Override
    public int createSpeaker(Speaker speaker) {
        writeOperation.create(speaker);
        return CREATED.getStatusCode();
    }

    @Override
    public int updateSpeaker(Long id, Speaker speaker) {
        if (speaker.validationFails()) {
            return BAD_REQUEST.getStatusCode();
        }

        writeOperation.update(id, speaker);
        return OK.getStatusCode();
    }

    @Override
    public int deleteSpeaker(Long id) {
        purgeOperation.delete(id);
        return OK.getStatusCode();
    }
}
