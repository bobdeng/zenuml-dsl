package com.zenuml.sequence.dsl;

import org.apache.log4j.lf5.util.StreamUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class DslGeneratorTest {

    private String readUmlFile(String file) {
        InputStream inputStream = getClass().getResourceAsStream(file + ".zenuml");
        try {
            return new String(StreamUtils.getBytes(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test_empty() {
        DslNode root = new FunctionNode("RootClass", "function(a1,a2)");
        checkDslResult(root,"file1");
    }

    @Test
    public void test_one_function_child() {
        DslNode root = new FunctionNode("RootClass", "function(a1,a2)");
        root.addChild(new FunctionNode("RootClass", "function2(a1,a2)"));
        checkDslResult(root,"file2");
    }

    private void checkDslResult(DslNode root,String file) {
        StringBuffer dsl = new StringBuffer();
        root.toDsl(dsl);
        assertEquals(readUmlFile(file), dsl.toString());
    }

    @Test
    public void test_has_condition_child() {
        DslNode root = new FunctionNode("RootClass", "function(a1,a2)");
        DslNode function1 = new FunctionNode("Class1","function");
        DslNode function2 = new FunctionNode("Class2","function");
        DslNode function3 = new FunctionNode("Class3","function");
        ConditionNode condition=new ConditionNode("condition");
        condition.addChild(function1);
        condition.addElse(function2);
        root.addChild(condition);
        checkDslResult(root,"file3");
    }
}
