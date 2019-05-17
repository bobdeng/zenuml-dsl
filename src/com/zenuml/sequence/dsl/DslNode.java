package com.zenuml.sequence.dsl;

public class DslNode {
    private String className;
    private String functionName;

    public DslNode(String className, String functionName) {
        this.className = className;
        this.functionName = functionName;
    }

    public void toDsl(StringBuffer output) {
        output.append("RootClass.function(a1,a2){\n" +
                "}");
    }
}
