package com.learning.endpoint.mapper

import com.learning.domain.exception.GameAlreadyOnBacklogException
import io.grpc.Status
import io.grpc.StatusException

fun Exception.asGrpcStatusError(): StatusException = when (this) {
    is GameAlreadyOnBacklogException -> StatusException(Status.UNKNOWN.withDescription(message))
    else -> Status.UNKNOWN.asException()
}
