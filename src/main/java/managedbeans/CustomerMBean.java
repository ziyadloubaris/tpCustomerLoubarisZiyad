/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbeans;

import com.mycompany.tp1loubarisziyad.entities.Customer;
import com.mycompany.tp1loubarisziyad.session.CustomerManager;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import static java.lang.Integer.getInteger;
import javax.ejb.EJB;
import java.util.List; 
import java.util.Locale;
import org.primefaces.util.LangUtils;
/**
 *
 * @author ziyad
 */
@Named(value = "customerMBean")
@ViewScoped
public class CustomerMBean implements Serializable {
   
    private List<Customer> customerList;
 
    @EJB
    private CustomerManager customerManager;
   
    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() {
    }
    
    public List<Customer> getCustomers() {
    if (customerList == null) {
      customerList = customerManager.getAllCustomers();
    }
    return customerList;
  }  
   
}
