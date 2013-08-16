/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.hotelho.hotel.entidades.HabitacionTipo;

/**
 *
 * @author obardales
 */
@Stateless
public class HabitacionTipoFacade extends AbstractFacade<HabitacionTipo> {
    @PersistenceContext(unitName = "WebHotelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HabitacionTipoFacade() {
        super(HabitacionTipo.class);
    }
    
}
