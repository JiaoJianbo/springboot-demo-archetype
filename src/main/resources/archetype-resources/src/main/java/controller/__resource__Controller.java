#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ${author}
 * @since 1.0
 */

@RestController
public class ${resource}Controller {

    @GetMapping("/hi")
    public String sayHi() {

        return "Hello Archetype!";
    }
}
