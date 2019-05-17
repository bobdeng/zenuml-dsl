package com.zenuml.sequence.dsl;

import org.junit.Test;

public class DslGeneratorTest {

    @Test
    public void test_generator() {
        DslNode root=new FunctionNode("RootClass","function(a1,a2)");
        StringBuffer dsl=new StringBuffer();
        root.toDsl(dsl);
    }
}
