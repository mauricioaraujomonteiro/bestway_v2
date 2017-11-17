/**
 * 
 */
package br.com.mmonteiro.bestway.routemanagement.route.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mmonteiro.bestway.routemanagement.route.dao.RoutingServiceDAO;
import br.com.mmonteiro.bestway.routemanagement.route.service.RoutingService;

/**
 * @author mmont
 *
 */
@Service
public class RoutingServiceImpl implements RoutingService
{
    @Autowired
    RoutingServiceDAO dao;

    /* (non-Javadoc)
     * @see br.com.mmonteiro.bestway.routemanagement.route.service.RoutingService#checkRoute()
     */
    @Override
    public void checkRoute()
    {
        // TODO Auto-generated method stub
    }
}
