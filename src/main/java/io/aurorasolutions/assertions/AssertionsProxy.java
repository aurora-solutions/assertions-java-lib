package io.aurorasolutions.assertions;

import io.aurorasolutions.assertions.contracts.Assertions;

public class AssertionsProxy implements Assertions {
    private AssertionsBase assertions;

    public AssertionsProxy() {
        assertions = new DefaultAssertionsFactory().getDefaultAssertionsInstance();
    }

    public AssertionsProxy(AssertionsFactory factory) {
        assertions = factory.getDefaultAssertionsInstance();
    }

    @Override
    public Assertions throwsException(Class exceptionType) {
        return assertions.throwsException(exceptionType);
    }

    @Override
    public Assertions isEqualTo(Object... expected) {
        return assertions.isEqualTo(expected);
    }

    @Override
    public Assertions isTrue() {
        return assertions.isTrue();
    }

    @Override
    public Assertions isFalse() {
        return assertions.isFalse();
    }

    @Override
    public void doAssert() throws Exception {
        assertions.doAssert();
    }

    @Override
    public Assertions useObjectMapper() {
        return assertions.useObjectMapper();
    }

    protected void setResult(Object[] result) {
        assertions.setResult(result);
    }

}