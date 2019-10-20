#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Bobby
 * @since 2019/8/25 22:55
 */
@Data
public class PersonKey implements Serializable {
    private String name;

    private String idCard;
}
