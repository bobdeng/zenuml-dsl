package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public class FunctionNode implements DslNode {
    private final String className;
    private final String functionName;
    private List<DslNode> children;

    public FunctionNode(String className, String functionName) {
        this.className = className;
        this.functionName = functionName;
        this.children=new ArrayList<>();
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
    public void addChild(FunctionNode node) {
        children.add(node);
    }
}
