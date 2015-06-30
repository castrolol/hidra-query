package com.castrolol.hidra.datatest.helper.queryNodes;

import com.castrolol.hidra.datatest.helper.core.QueryField;
import com.castrolol.hidra.datatest.helper.core.QueryNode;

/**
 * Created by 'Luan on 29/06/2015.
 */
public class QueryFieldNode extends QueryNode {
    private String QUOTES = "\"";
    private String name;
    private String alias;

    public  QueryFieldNode(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String getQueryFragment() {
        String queryFrag = name + " ";
        if(alias != null) queryFrag += " as "+ QUOTES + alias + QUOTES;
        return name;
    }
    
    public QueryFieldExpressionNode eq(String valor){
        return new QueryFieldExpressionNode(this, "=", valor);
    }

    public QueryFieldExpressionNode eq(QueryFieldNode valor){
        return new QueryFieldExpressionNode(this, "=", valor);
    }
    
    public QueryFieldExpressionNode like(String valor){
        return new QueryFieldExpressionNode(this, "LIKE", valor);
    }

    public QueryFieldExpressionNode like(QueryFieldNode valor){
        return new QueryFieldExpressionNode(this, "LIKE", valor);
    }
    
    public QueryFieldExpressionNode lt(String valor){
        return new QueryFieldExpressionNode(this, "<", valor);
    }

    public QueryFieldExpressionNode lt(QueryFieldNode valor){
        return new QueryFieldExpressionNode(this, "<", valor);
    }
    
    public QueryFieldExpressionNode gt(String valor){
        return new QueryFieldExpressionNode(this, "<", valor);
    }

    public QueryFieldExpressionNode gt(QueryFieldNode valor){
        return new QueryFieldExpressionNode(this, "<", valor);
    }
    
    public QueryFieldExpressionNode lOrEq(String valor){
        return new QueryFieldExpressionNode(this, "<=", valor);
    }

    public QueryFieldExpressionNode lOrEq(QueryFieldNode valor){
        return new QueryFieldExpressionNode(this, "<=", valor);
    }
    
     public QueryFieldExpressionNode gOrEq(String valor){
        return new QueryFieldExpressionNode(this, ">=", valor);
    }

    public QueryFieldExpressionNode gOrEq(QueryFieldNode valor){
        return new QueryFieldExpressionNode(this, ">=", valor);
    }
    
}
