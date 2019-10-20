#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repo;

import ${package}.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bobby
 * @since 2019/9/14 14:06
 */
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
