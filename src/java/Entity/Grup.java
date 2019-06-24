/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author Samsung
 */
public class Grup {
    
    private int grup_id;
    private String grup_adi;

    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public int getGrup_id() {
        return grup_id;
    }

    public void setGrup_id(int grup_id) {
        this.grup_id = grup_id;
    }

    public String getGrup_adi() {
        return grup_adi;
    }

    public void setGrup_adi(String grup_adi) {
        this.grup_adi = grup_adi;
    }

    @Override
    public String toString() {
        return  grup_adi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.grup_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grup other = (Grup) obj;
        if (!Objects.equals(this.grup_id, other.grup_id)) {
            return false;
        }
        return true;
    }
}
