package io.aurorasolutions.assertions.contracts;

public interface Assertions extends Assertable
{
    Assertions throwsException(Class exceptionType);
    Assertions isEqualTo(Object... expected);
    Assertions isTrue();
    Assertions isFalse();
    Assertions useObjectMapper();
}
