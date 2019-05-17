package com.zenuml.sequence.dsl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DslGeneratorTest {

    @Test
    public void test_generator() {
        DslNode root=new FunctionNode("RootClass","function(a1,a2)");
        StringBuffer dsl=new StringBuffer();
        root.toDsl(dsl);
        assertEquals("RootClass.function(a1,a2){\n}",dsl.toString());
    }
    @Test
    public void test_has_child() {
        DslNode root=new FunctionNode("RootClass","function(a1,a2)");
        root.addChild(new FunctionNode("RootClass","function2(a1,a2)"));
        StringBuffer dsl=new StringBuffer();
        root.toDsl(dsl);
        assertEquals("RootClass.function(a1,a2){\n" +
                "}",dsl.toString());
    }
}
