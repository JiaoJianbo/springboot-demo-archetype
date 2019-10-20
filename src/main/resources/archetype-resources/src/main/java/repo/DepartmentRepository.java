#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repo;

import ${package}.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bobby
 * @since 2019/8/11 23:57
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
