package com.castrolol.hidra.datatest.helper.queryNodes;

import com.castrolol.hidra.datatest.helper.core.QueryField;
import com.castrolol.hidra.datatest.helper.core.QueryNode;

/**
 * Created by 'Luan on 29/06/2015.
 */
public class QueryFieldExpressionNode extends QueryNode {

    boolean isUnary;
    QueryFieldNode leftSide;
    String operator;
    QueryFieldNode rightSide;

    public QueryFieldExpressionNode(String unaryOperator, String rawValue) {
        isUnary = true;
        operator = unaryOperator;
        rightSide = new QueryFieldNode(rawValue);
    }

    public QueryFieldExpressionNode(String leftSide, String binaryOperator, String rightSide) {
        this(new QueryFieldNode(leftSide), binaryOperator, rightSide);
    }
    
    public  QueryFieldExpressionNode(QueryFieldNode leftSide, String binaryOperator, String rightSide) {
        this(leftSide, binaryOperator, new QueryFieldNode(rightSide));
    }

    public QueryFieldExpressionNode(String leftSide, String binaryOperator, QueryFieldNode rightSide) {
        this(new QueryFieldNode(leftSide), binaryOperator, rightSide);
    } 
     
    public QueryFieldExpressionNode(QueryFieldNode leftSide, String binaryOperator, QueryFieldNode rightSide) {
      isUnary = false;
      operator = binaryOperator;
      this.rightSide = rightSide;
      this.leftSide = leftSide;
    }

    public QueryWhereAndNode and(QueryFieldExpressionNode expression){
        return new QueryWhereAndNode(expression);
    }

    public QueryWhereOrNode or(QueryFieldExpressionNode expression){
        return new QueryWhereOrNode(expression);
    }

    @Override
    public String getQueryFragment() {
        return (" " + leftSide.getQueryFragment() + " " + operator + " " + rightSide.getQueryFragment() + " ").trim();
    }
}
