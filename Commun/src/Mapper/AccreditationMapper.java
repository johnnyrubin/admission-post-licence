package Mapper;

import AdmissionPostLicence.accreditation;
import Pojo.Accreditation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
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
            String[] diplome = new String[a.getDiplome().size()];
            for(int i=0;i<a.getDiplome().size();i++){
                diplome[i]=a.getDiplome().get(i);
            }
            ac = new accreditation(a.getUniversite(),diplome);
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
            ac = new Accreditation(a.universite);
            for (String master : a.master) {
                ac.addDiplome(master);
            }
        }
        return ac;
    }
    /**
     * Convertit les infos d'une liste accreditation vers le type accredidations de corba
     * 
     * @param a
     * @return {@link accreditation[]}
     */
    public static accreditation[] accreditationsCorbaToListAccredidation(List<Accreditation> a) {
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
     * @return {@link List<Accreditation>}
     */
    public static List<Accreditation> listAccreditationsToAccredidationCorba(accreditation[] a) {
        List<Accreditation> as = new ArrayList();
        if(a.length!=0){
            for (accreditation a1 : a) {
                as.add(accreditationCorbaToAccredidation(a1));
            }
        }
        return as;
    }
}
