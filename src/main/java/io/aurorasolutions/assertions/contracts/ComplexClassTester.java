package io.aurorasolutions.assertions.contracts;

public interface ComplexClassTester<Self, ObjectCreationModelType> extends ClassTester<Self> {
    Self createObjectUsingModel(ObjectCreationModelType model);
}
