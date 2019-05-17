package com.zenuml.sequence.dsl;

public class FunctionNode implements DslNode {
    private final String className;
    private final String functionName;

    public FunctionNode(String className, String functionName) {
        this.className = className;
        this.functionName = functionName;
    }

    @Override
    public void toDsl(StringBuffer output) {
        output.append(className);
        output.append(".");
        output.append(functionName);
        output.append("{\n");
        output.append("  RootClass.function2(a1,a2);\n");
        output.append("}");
    }

    @Override
    public void addChild(FunctionNode rootClass) {

    }
}
