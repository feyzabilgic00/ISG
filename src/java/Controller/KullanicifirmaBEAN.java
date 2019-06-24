package Controller;

import Dao.KullanicifirmaDAO;
import Entity.Kullanicifirma;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class KullanicifirmaBEAN implements Serializable {

    private List<Kullanicifirma> kflist;
    private KullanicifirmaDAO kfdao;

    public KullanicifirmaBEAN() {
        this.kflist = new ArrayList();
        kfdao = new KullanicifirmaDAO();
    }

    public List<Kullanicifirma> getKflist() {
        return kflist;
    }

    public void setKflist(List<Kullanicifirma> kflist) {
        this.kflist = kflist;
    }

    public KullanicifirmaDAO getKfdao() {
        return kfdao;
    }

    public void setKfdao(KullanicifirmaDAO kfdao) {
        this.kfdao = kfdao;
    }

}
