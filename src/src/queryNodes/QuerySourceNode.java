package com.castrolol.hidra.datatest.helper.queryNodes;

import com.castrolol.hidra.datatest.helper.core.QueryNode;

/**
 * Created by 'Luan on 30/06/2015.
 */
public class QuerySourceNode extends QueryNode {
     private final String QUOTES = "\"";
    String source;
    String alias;

    public QuerySourceNode(String source){
        this(source, null);
    }

    public QuerySourceNode(String source, String alias){
        this.source = source;
        this.alias = alias;
    }

    @Override
    public String getQueryFragment() {
        String queryFrag = source ;
        if(alias != null) queryFrag += " as " + QUOTES + alias + QUOTES;
        return source;
    }
}
