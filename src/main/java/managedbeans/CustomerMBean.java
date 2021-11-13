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
    
    @EJB
    private CustomerManager customerManager;
    private boolean globalFilterOnly;    
    private List<Customer> customerList;
private List<Customer> filteredCustomers1;
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
    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (!LangUtils.isNotBlank(filterText)) {
            return true;
        }
        int filterInt = getInteger(filterText);

        Customer customer = (Customer) value;
        return customer.getName().toLowerCase().contains(filterText)
                || customer.getCity().toLowerCase().contains(filterText)
                || customer.getAddressline1().toLowerCase().contains(filterText)
                || customer.getAddressline2().toString().toLowerCase().contains(filterText)
                || customer.getEmail().toLowerCase().contains(filterText)
                || customer.getPhone().contains(filterText);
    }
     public boolean isGlobalFilterOnly() {
        return globalFilterOnly;
    }

    public void setGlobalFilterOnly(boolean globalFilterOnly) {
        this.globalFilterOnly = globalFilterOnly;
    }
    
    public void toggleGlobalFilter() {
        setGlobalFilterOnly(!isGlobalFilterOnly());
    }
        public List<Customer> getFilteredCustomers1() {
        return filteredCustomers1;
    }

    public void setFilteredCustomers1(List<Customer> filteredCustomers1) {
        this.filteredCustomers1 = filteredCustomers1;
    }
}
