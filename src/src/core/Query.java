package com.castrolol.hidra.datatest.helper.core;

import com.castrolol.hidra.datatest.helper.queryNodes.QueryFieldExpressionNode;
import com.castrolol.hidra.datatest.helper.queryNodes.QueryFieldNode;
import com.castrolol.hidra.datatest.helper.queryNodes.QueryFromNode;
import com.castrolol.hidra.datatest.helper.queryNodes.QueryOrderByNode;
import com.castrolol.hidra.datatest.helper.queryNodes.QuerySelectNode;
import com.castrolol.hidra.datatest.helper.queryNodes.QuerySourceNode;
import com.castrolol.hidra.datatest.helper.queryNodes.QueryWhereNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by 'Luan on 30/06/2015.
 */
public class Query {

    QuerySelectNode _select;
    QueryFromNode _from;
    QueryWhereNode _where;
    QueryOrderByNode _order;

    public Query(String source){
        _select = new QuerySelectNode("*");
        _from = new QueryFromNode(new QuerySourceNode(source));
    }
    
    public Query select(QueryFieldNode... params){

        _select = new QuerySelectNode(Arrays.asList(params));
        return this;
    }

    public Query where(QueryFieldExpressionNode expression){
        _where = new QueryWhereNode(expression);
        return this;
    }

    public Query and(QueryFieldExpressionNode expressionNode){
        _where.and(expressionNode);
        return this;
    }

    public Query or(QueryFieldExpressionNode expressionNode){
        _where.or(expressionNode);
        return this;
    }

    public Query orderBy(QueryFieldNode ...params){
        _order = new QueryOrderByNode(Arrays.asList(params), true);
        return this;
    }

    public Query orderByDesc(QueryFieldNode ...params){
        _order = new QueryOrderByNode(Arrays.asList(params), false);
        return this;
    }
 
    public String resolve(){
        
        String query = "";
        query += _select.getQueryFragment();
        query += _from.getQueryFragment();
        if(_where != null){
            query += _where.getQueryFragment();
        }
        if(_order != null){
            query += _order.getQueryFragment();
        }
        
        return query;
    }
    
    @Override
    public String toString(){
        
        return resolve();
    }
    
}
