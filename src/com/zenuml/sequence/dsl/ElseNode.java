package com.zenuml.sequence.dsl;

import java.util.ArrayList;
import java.util.List;

public class ElseNode extends BaseNode {

    public ElseNode(String condition) {
        super();
    }

    @Override
    public void toDsl(StringBuffer output) {
        printIndent(output);
        output.append("else(");
        printChindren(output);
        output.append("){\n");

    }

    @Override
    public BaseNode addChild(BaseNode node) {
        node.setLevel(getNextLevel());
        children.add(node);
        return node;
    }

}
