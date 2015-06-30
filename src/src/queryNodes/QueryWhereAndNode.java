package com.castrolol.hidra.datatest.helper.queryNodes;

import com.castrolol.hidra.datatest.helper.core.QueryNode;

/**
 * Created by 'Luan on 29/06/2015.
 */
public class QueryWhereAndNode extends QueryWhereNode {

    QueryWhereAndNode(QueryFieldExpressionNode expression){
        super(expression);
    }

    @Override
    protected String getKeyword(){
        return "AND";
    }
}
