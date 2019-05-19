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
        BaseNode root = new FunctionNode("RootClass", "function(a1,a2)");
        checkDslResult(root,"file1");
    }

    @Test
    public void test_one_function_child() {
        BaseNode root = new FunctionNode("RootClass", "function(a1,a2)");
        root.addChild(new FunctionNode("RootClass", "function2(a1,a2)"));
        checkDslResult(root,"file2");
    }

    private void checkDslResult(BaseNode root,String file) {
        StringBuffer dsl = new StringBuffer();
        root.toDsl(dsl);
        assertEquals(readUmlFile(file), dsl.toString());
    }

    @Test
    public void test_has_condition_child() {
        BaseNode root = new FunctionNode("RootClass", "function(a1,a2)");
        BaseNode function1 = new FunctionNode("Class1","function()");
        ConditionNode condition = (ConditionNode)root.addChild(new ConditionNode("condition"));
        ElseNode elseNode = new ElseNode();
        elseNode.addChild(new FunctionNode("Class2","function()"));
        condition.addChild(function1);
        condition.addElse(elseNode);
        checkDslResult(root,"file3");
    }

    @Test
    public void test_function_has_return(){
        BaseNode root = new FunctionNode("RootClass", "function(a1,a2)");
        root.addChild(new FunctionNode("RootClass", "function2(a1,a2)","result"));
        checkDslResult(root,"file4");
    }
    @Test
    public void test_loop(){
        BaseNode root = new FunctionNode("RootClass", "function(a1,a2)");
        root.addChild(new LoopNode("condition"))
                .addChild(new FunctionNode("class2", "function()"));
        checkDslResult(root,"file_loop");
    }

    @Test
    public void test_else_if(){
        BaseNode root = new FunctionNode("RootClass", "function(a1,a2)");
        ConditionNode conditionNode = new ConditionNode("condition");
        conditionNode.addChild(new FunctionNode("Class1","function()"));
        ElseNode elseNode = new ElseNode("condition2");
        elseNode.addChild(new FunctionNode("Class2","function()"));
        ElseNode elseNodeEnd = new ElseNode();
        elseNodeEnd.addChild(new FunctionNode("Class3","function()"));
        conditionNode.addElse(elseNode);
        conditionNode.addElse(elseNodeEnd);
        root.addChild(conditionNode);
        //checkDslResult(root,"file_elseif");

    }
}
