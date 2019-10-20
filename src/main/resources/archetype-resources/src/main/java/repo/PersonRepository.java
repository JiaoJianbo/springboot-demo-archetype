#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repo;

import ${package}.entity.Person;
import ${package}.entity.PersonKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bobby
 * @since 2019/8/25 23:04
 */
public interface PersonRepository extends JpaRepository<Person, PersonKey> {
}
