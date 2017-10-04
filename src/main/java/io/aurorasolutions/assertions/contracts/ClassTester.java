package io.aurorasolutions.assertions.contracts;

public interface ClassTester<Self> {
    Self forConstructor(Object... arguments);
}