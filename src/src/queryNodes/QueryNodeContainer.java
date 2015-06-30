package com.castrolol.hidra.datatest.helper.queryNodes;

import com.castrolol.hidra.datatest.helper.core.QueryNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 'Luan on 29/06/2015.
 */
public abstract class QueryNodeContainer extends QueryNode {


    private List<QueryNode> children = new ArrayList<>();

    public List<QueryNode> getChildren(){
        return children;
    }

    @Override
    public abstract String getQueryFragment();
}
