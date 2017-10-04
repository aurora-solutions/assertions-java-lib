package io.aurorasolutions.assertions;

import io.aurorasolutions.assertions.implementations.AssertJAssertions;

public class DefaultAssertionsFactory implements AssertionsFactory {
    @Override
    public AssertionsBase getDefaultAssertionsInstance() {
        return new AssertJAssertions();
    }
}