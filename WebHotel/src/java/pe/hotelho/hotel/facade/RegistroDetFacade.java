/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.hotelho.hotel.entidades.RegistroDet;

/**
 *
 * @author obardales
 */
@Stateless
public class RegistroDetFacade extends AbstractFacade<RegistroDet> {
    @PersistenceContext(unitName = "WebHotelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroDetFacade() {
        super(RegistroDet.class);
    }
    
}
