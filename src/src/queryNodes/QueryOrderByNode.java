package com.castrolol.hidra.datatest.helper.queryNodes;

import com.castrolol.hidra.datatest.helper.core.QueryNode;

import java.util.List;

/**
 * Created by 'Luan on 30/06/2015.
 */
public class QueryOrderByNode extends QueryNodeContainer {

    boolean ascendent;

    public QueryOrderByNode(List<QueryFieldNode> fields, boolean ascendent){
        getChildren().addAll(fields);
        this.ascendent = ascendent;
    }

    @Override
    public String getQueryFragment() {
        String queryFrag = " ORDER BY ";
        boolean isFirst = true;
        for(QueryNode node : getChildren()){
            if(isFirst){
                isFirst = false;
            }else{
                queryFrag += ",";
            }
            queryFrag += node.getQueryFragment();
        }

        queryFrag += ascendent ? " ASC" : " DESC";
        return queryFrag;
    }
}
