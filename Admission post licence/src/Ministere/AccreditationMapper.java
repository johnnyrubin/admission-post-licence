/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ministere;

import AdmissionPostLicence.accreditation;
import Ministere.pojo.Accreditation;
import java.util.ArrayList;

/**
 *
 * @author johnny
 */
public class AccreditationMapper {
    /**
     * Convertit les infos d'un objet Accredidation vers son type accredidation utilisé par corba
     * 
     * @param a
     * @return {@link accreditation}
     */
    public static accreditation accreditationToAccredidationCorba(Accreditation a) {
        accreditation ac = null;
        if(a != null) {
            //ac = new accreditation(a.getUniversite(),a.getDiplome());
        }
        return ac;
    }
    /**
     * Convertit les infos d'un type accreditation corba vers son type Accredidation
     * 
     * @param a
     * @return {@link Accreditation}
     */
    public static Accreditation accreditationCorbaToAccredidation(accreditation a) {
        Accreditation ac = null;
        if(a != null) {
            //ac = new Accreditation(a.universite,a.master);
        }
        return ac;
    }
    /**
     * Convertit les infos d'une liste accreditation vers le type accredidations de corba
     * 
     * @param a
     * @return {@link accreditation[]}
     */
    public static accreditation[] accreditationsCorbaToListAccredidation(ArrayList<Accreditation> a) {
        accreditation[] as = new accreditation[a.size()];
        if(!a.isEmpty()) {
            for(int i=0;i<a.size();i++){
                as[i]=accreditationToAccredidationCorba(a.get(i));
            }
        }
        return as;
    }
    /**
     * Convertit les infos du type accredidations de corba vers une liste accreditation
     * 
     * @param a
     * @return {@link ArrayList<Accreditation>}
     */
    public static ArrayList<Accreditation> listAccreditationsToAccredidationCorba(accreditation[] a) {
        ArrayList<Accreditation> as = new ArrayList();
        if(a.length!=0){
            for (accreditation a1 : a) {
                as.add(accreditationCorbaToAccredidation(a1));
            }
        }
        return as;
    }
}
