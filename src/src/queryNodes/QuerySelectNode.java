package com.castrolol.hidra.datatest.helper.queryNodes;

import com.castrolol.hidra.datatest.helper.core.QueryNode;

import java.util.Collection;
import java.util.List;

/**
 * Created by 'Luan on 29/06/2015.
 */
public class QuerySelectNode extends QueryNodeContainer {

    String raw;



    public QuerySelectNode(String raw){
        this.raw = raw;
    }

    public QuerySelectNode(Collection<QueryFieldNode> fields){
        getChildren().addAll(fields);
    }

    @Override
    public String getQueryFragment() {
        String queryFrag = "SELECT ";

        if(getChildren().size() <= 0 && raw != null){
            queryFrag = raw;
        }else{
            boolean isFirst = true;
            for(QueryNode node : getChildren()){
                if(isFirst){
                    isFirst = false;
                }else{
                    queryFrag += ", ";
                }
                queryFrag +=  node.getQueryFragment();
            }
        }

        return queryFrag;
    }
}
