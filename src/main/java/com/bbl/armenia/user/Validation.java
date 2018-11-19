package com.bbl.armenia.user;

import org.jooq.tools.StringUtils;

class Validation {
    static boolean fails(Speaker speaker) {
        return speaker == null || fails(speaker.getUser());
    }

    private static boolean fails(User user) {
        return user == null || fails(user.getIdentity());
    }

    private static boolean fails(Identity identity) {
        return identity == null || isSpeakerNameMissing(identity);
    }

    private static boolean isSpeakerNameMissing(Identity identity) {
        return StringUtils.isBlank(identity.getFirstName()) || StringUtils.isBlank(identity.getLastName());
    }
}
