
package Controller;

import Dao.TanilarDAO;
import Entity.Tanilar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TanilarBEAN implements Serializable{
private List<Tanilar> tnlist;
private TanilarDAO tndao;

    public TanilarBEAN() {
        this.tnlist=new ArrayList();
        tndao=new TanilarDAO();
    }
    public List<Tanilar> getTnlist() {
        return tnlist;
    }

    public void setTnlist(List<Tanilar> tnlist) {
        this.tnlist = tnlist;
    }

    public TanilarDAO getTndao() {
        return tndao;
    }

    public void setTndao(TanilarDAO tndao) {
        this.tndao = tndao;
    }

}
