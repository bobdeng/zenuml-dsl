package com.zenuml.sequence.dsl;

public class ElseNode extends BaseNode {
    private final String condition;

    public ElseNode() {
        super();
        this.condition=null;
    }

    public ElseNode(String condition) {
        super();
        this.condition =condition;
    }

    @Override
    public void toDsl(StringBuffer output) {
        printIndent(output);
        if(condition ==null) {
            output.append(" else (");
        }
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
