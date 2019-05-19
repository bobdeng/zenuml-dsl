package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public class FunctionNode extends BaseNode implements DslNode {
    private final String className;
    private final String functionName;
    private final String result;

    public FunctionNode(String className, String functionName) {
        super();
        this.className = className;
        this.functionName = functionName;
        this.children = new ArrayList<>();
        this.result=null;
    }

    public FunctionNode(String className, String functionName, String result) {
        this.className=className;
        this.functionName=functionName;
        this.children = new ArrayList<>();
        this.result=result;
    }

    @Override
    public void toDsl(StringBuffer output) {
        printIndent(output);
        if(result!=null){
            output.append(result);
            output.append("=");
        }
        output.append(className);
        output.append(".");
        output.append(functionName);
        if (children.size() == 0 && !isRoot()) {
            output.append(";\n");
        } else {
            output.append("{\n");
            children.forEach(dslNode -> dslNode.toDsl(output));
            printIndent(output);
            output.append("}");
        }
    }

    @Override
    public DslNode addChild(DslNode node) {
        node.setLevel(getNextLevel());
        children.add(node);
        return node;
    }

}
