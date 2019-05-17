package com.zenuml.sequence.dsl;

public interface DslNode {

    void toDsl(StringBuffer output);

    void addChild(FunctionNode rootClass);
}
