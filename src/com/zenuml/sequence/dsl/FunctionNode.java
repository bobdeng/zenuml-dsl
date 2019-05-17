package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public class FunctionNode implements DslNode {
    private final String className;
    private final String functionName;
    private List<DslNode> children;
    private int level;

    public FunctionNode(String className, String functionName) {
        this.className = className;
        this.functionName = functionName;
        this.children=new ArrayList<>();
        this.level=0;
    }

    @Override
    public void toDsl(StringBuffer output) {
        printIndent(output);
        output.append(className);
        output.append(".");
        output.append(functionName);
        output.append("{\n");
        output.append("  RootClass.function2(a1,a2);\n");
        printIndent(output);
        output.append("}");
    }
    private void printIndent(StringBuffer output){
        for(int i=0;i<level;i++){
            output.append("  ");
        }
    }
    @Override
    public void addChild(FunctionNode node) {
        node.level=this.level+1;
        children.add(node);
    }
}
