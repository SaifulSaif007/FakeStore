package com.saiful.fakestore.domain.exception

open class DomainException(message: String) : Exception(message)

class NotFoundException : DomainException("resource not found")
class UnauthorizedException : DomainException("unauthorized exception")
class ServerErrorException : DomainException("server error")
class UnknownException : DomainException("unknown error")

