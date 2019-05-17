package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public class FunctionNode extends BaseNode implements DslNode {
    private final String className;
    private final String functionName;
    private List<DslNode> children;

    public FunctionNode(String className, String functionName) {
        this.className = className;
        this.functionName = functionName;
        this.children = new ArrayList<>();
    }

    @Override
    public void toDsl(StringBuffer output) {
        printIndent(output);
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
    public void addChild(DslNode node) {
        node.setLevel(getNextLevel());
        children.add(node);
    }

}
