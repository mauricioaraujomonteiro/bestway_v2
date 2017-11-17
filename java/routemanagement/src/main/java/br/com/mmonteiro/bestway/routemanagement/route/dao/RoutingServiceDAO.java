/**
 * 
 */
package br.com.mmonteiro.bestway.routemanagement.route.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.mmonteiro.bestway.usermanagement.core.route.Route;
import br.com.mmonteiro.bestway.usermanagementcore.user.entity.User;

/**
 * @author mmont
 *
 */
public interface RoutingServiceDAO extends CrudRepository<User, String>
{
    default List<Route> getActivedRoutes()
    {
        return Collections.emptyList();
    }
}
