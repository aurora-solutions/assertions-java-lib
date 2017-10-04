package io.aurorasolutions.assertions;

import io.aurorasolutions.assertions.contracts.AssertionResult;
import io.aurorasolutions.assertions.contracts.Assertions;

public abstract class AssertionsBase implements Assertions, AssertionResult {
    protected Object[] result;
    protected Object[] expected;
    protected boolean useObjectMapper = false;
    protected AssertionType assertionType;
    protected Class exceptionType;

    protected AssertionsBase() {
        assertionType = AssertionType.None;
    }

    @Override
    public Assertions throwsException(Class exceptionType) {
        assertionType = AssertionType.Exception;
        this.exceptionType = exceptionType;
        return this;
    }

    @Override
    public Assertions isEqualTo(Object... expected) {
        assertionType = AssertionType.Equals;
        this.expected = expected;
        return this;
    }

    @Override
    public Assertions isTrue() {
        assertionType = AssertionType.True;
        return this;
    }

    @Override
    public Assertions isFalse() {
        assertionType = AssertionType.False;
        return this;
    }

    @Override
    public abstract void doAssert() throws Exception;

    @Override
    public void setResult(Object[] result) {
        this.result = result;
    }

    @Override
    public Assertions useObjectMapper() {
        this.useObjectMapper = true;
        return this;
    }
}