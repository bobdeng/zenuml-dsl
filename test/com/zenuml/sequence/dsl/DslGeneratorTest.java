package com.zenuml.sequence.dsl;

import org.apache.log4j.lf5.util.StreamUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class DslGeneratorTest {

    private String readUmlFile(String file){
        InputStream inputStream = getClass().getResourceAsStream(file + ".zenuml");
        try {
            return new String(StreamUtils.getBytes(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Test
    public void test_generator() {
        System.out.println(readUmlFile("file1"));
        DslNode root=new FunctionNode("RootClass","function(a1,a2)");
        StringBuffer dsl=new StringBuffer();
        root.toDsl(dsl);
        assertEquals("RootClass.function(a1,a2);\n",dsl.toString());
    }
    @Test
    public void test_has_child() {
        DslNode root=new FunctionNode("RootClass","function(a1,a2)");
        root.addChild(new FunctionNode("RootClass","function2(a1,a2)"));
        StringBuffer dsl=new StringBuffer();
        root.toDsl(dsl);
        System.out.println(dsl.toString());
        assertEquals("RootClass.function(a1,a2){\n" +
                "  RootClass.function2(a1,a2);\n" +
                "}",dsl.toString());
    }
}
