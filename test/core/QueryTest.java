/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import com.castrolol.hidra.datatest.helper.core.Query;
import com.castrolol.hidra.datatest.helper.queryNodes.QueryFieldExpressionNode;
import com.castrolol.hidra.datatest.helper.queryNodes.QueryFieldNode;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 'Luan
 */
public class QueryTest  {
    
    public QueryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSimpleSelct(){
        
        QueryFieldNode nome = new QueryFieldNode("nome");
        QueryFieldNode idade = new QueryFieldNode("idade");
        QueryFieldNode sexo = new QueryFieldNode("sexo");
        
        Query query = new Query("pessoas")
                            .select(nome, idade, sexo)
                            .where(idade.gOrEq("18"))
                            .and(idade.lt("60"))
                            .orderBy(nome);
                         
        String queryObjective = "SELECT nome, idade, sexo FROM pessoas WHERE idade >= 18 AND idade < 60 ORDER BY nome ASC";
        String queryResult  = query.resolve();
        assertEquals(queryObjective, queryResult);
        
    }
}
