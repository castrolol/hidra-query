package com.castrolol.hidra.datatest.helper.queryNodes;

/**
 * Created by 'Luan on 29/06/2015.
 */
public class QueryWhereOrNode extends QueryWhereNode {

    QueryWhereOrNode(QueryFieldExpressionNode expression){
        super(expression);
    }

    @Override
    protected String getKeyword(){
        return "OR";
    }
}
