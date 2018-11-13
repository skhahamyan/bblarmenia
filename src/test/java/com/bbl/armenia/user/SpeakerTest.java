package com.bbl.armenia.user;

import com.bbl.armenia.tools.TestTools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpeakerTest {
    private Speaker speaker;

    @BeforeEach
    void setUp() {
        this.speaker = createSpeaker();
    }

    @Test
    void new_speaker_should_have_empty_knowledges() {
        assertNotNull(speaker.getKnowledges());
        assertEquals(speaker.getKnowledges().size(), 0);
    }

    @Test
    void speaker_should_be_able_to_add_knowledge() {
        speaker.addKnowledge(createKnowledge());
        assertEquals(speaker.getKnowledges().size(), 1);
        System.out.println(speaker);
    }

    @Test
    void user_is_speaker_if_knowledges_is_not_empty() {
        speaker.addKnowledge(createKnowledge());
        assertTrue(speaker.isSpeaker());
    }

    @Test
    void user_remains_user_if_knowledges_is_empty() {
        assertFalse(speaker.isSpeaker());
    }

    private Speaker createSpeaker() {
        return TestTools.fromJson("speaker.json", Speaker.class);
    }

    private Knowledge createKnowledge() {
        return TestTools.fromJson("knowledge.json", Knowledge.class);
    }
}