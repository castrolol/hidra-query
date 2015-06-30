package com.castrolol.hidra.datatest.helper.queryNodes;

import com.castrolol.hidra.datatest.helper.core.QueryNode;

/**
 * Created by 'Luan on 29/06/2015.
 */
public class QueryWhereNode extends QueryNodeContainer {

    QueryFieldExpressionNode expression;

    protected String getKeyword(){
        return "WHERE";
    }

    public QueryWhereNode(QueryFieldExpressionNode expression){
        this.expression = expression;
    }

    public QueryWhereNode and(QueryFieldExpressionNode expression){
        getChildren().add(new QueryWhereAndNode(expression));
        return this;
    }

     public QueryWhereNode or(QueryFieldExpressionNode expression){
        getChildren().add(new QueryWhereOrNode(expression));
        return this;
    }

    @Override
    public String getQueryFragment() {
        String queryFrag = " " + getKeyword() + " " + expression.getQueryFragment() ;
        for(QueryNode node : getChildren()){
            queryFrag += node.getQueryFragment();
        }
        return queryFrag;
    }
}
