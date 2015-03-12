package br.com.jailsys.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import br.com.jailsys.model.Crime;
import br.com.jailsys.model.Preso;
import br.com.jailsys.qualifier.PresoBean;

@Named
public class PresoView implements Serializable {

	private static final long serialVersionUID = 1323681720981102858L;

	@Inject
	@PresoBean
	private Preso preso;

	private List<Preso> presos = new ArrayList<Preso>();
	
	private DualListModel<Crime> crimes = new DualListModel<Crime>();

	public Preso getPreso() {
		return preso;
	}

	public void setPreso(Preso preso) {
		this.preso = preso;
	}

	public List<Preso> getPresos() {
		return presos;
	}

	public void setPresos(List<Preso> presos) {
		this.presos = presos;
	}

    public DualListModel<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(DualListModel<Crime> crimes) {
        this.crimes = crimes;
    }

}
