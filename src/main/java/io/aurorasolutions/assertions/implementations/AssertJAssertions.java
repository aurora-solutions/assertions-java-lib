package io.aurorasolutions.assertions.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.aurorasolutions.assertions.AssertionsBase;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJAssertions extends AssertionsBase {

    @Override
    public void doAssert() throws Exception {
        switch (assertionType) {
            case Equals:
                if(useObjectMapper) {
                    assertThat(new ObjectMapper().writeValueAsString(result)).isEqualTo(new ObjectMapper().writeValueAsString(expected));
                }
                else {
                    assertThat(result).isEqualTo(expected);
                }
                break;
            case Exception:
                if(!isResultValid()) {
                    throw new IllegalArgumentException("result, exceptionType");
                }
                assertThat((Class)result[0]).isEqualTo(this.exceptionType);
                break;
            case True:
                if(isResultValid()) {
                    throw new IllegalArgumentException("result");
                }
                assertThat((boolean) result[0]).isTrue();
                break;
            case False:
                if(isResultValid()) {
                    throw new IllegalArgumentException("result");
                }
                assertThat((boolean) result[0]).isFalse();
                break;
            default:
                throw new UnsupportedOperationException("No Assertion Chosen");
        }
    }

    private boolean isResultValid() {
        switch (assertionType) {
            case Equals:
                return true;
            case Exception:
                if(result != null && result.length == 1 && exceptionType != null) {
                    return true;
                }
            case True:
            case False:
                if(result != null && result.length == 1)
                    return true;
            default:
                return false;
        }
    }
}