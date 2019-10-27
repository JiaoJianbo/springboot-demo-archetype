#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repo;

import ${package}.entity.${resource};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Bobby
 * @since 1.0
 */
public interface ${resource}Repository
        extends JpaRepository <${resource}, Long>, JpaSpecificationExecutor<${resource}> {
}
