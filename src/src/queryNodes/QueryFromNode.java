package com.castrolol.hidra.datatest.helper.queryNodes;

import com.castrolol.hidra.datatest.helper.core.QueryNode;

/**
 * Created by 'Luan on 30/06/2015.
 */
public class QueryFromNode extends QueryNode {

    QuerySourceNode source;

    public QueryFromNode(QuerySourceNode source){
        this.source = source;
    }

    @Override
    public String getQueryFragment() {
        return " FROM " + source.getQueryFragment();
    }
}
