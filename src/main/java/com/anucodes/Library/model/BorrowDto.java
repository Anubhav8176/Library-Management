package com.anucodes.Library.model;

import java.util.Date;

public record BorrowDto(
        Long bookId,
        Long memberId,
        Date issuedAt,
        Date returnedAt,
        Boolean returned
) {
}
