#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repo;

import ${package}.entity.${resource};
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @author Bobby
 * @since 2019/8/12 0:00
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ${resource}RepositoryTest {

    @Autowired
    private ${resource}Repository ${resource}Repository;

    @Test
    public void testFindAll() {
        List<${resource}> ${resource}s = ${resource}Repository.findAll();
        ${resource}s.forEach(System.out::println);
    }
    
    @Test
    public void testGetOne(){
        Long id = 1L;
        ${resource} ${resource} = ${resource}Repository.getOne(id);
        System.out.println("${resource} = " + ${resource});
    }

}
