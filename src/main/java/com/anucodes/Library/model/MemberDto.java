package com.anucodes.Library.model;

import java.util.Date;

public record MemberDto(
        String name,
        String email,
        String phone,
        Date membershipDate
) {
}
