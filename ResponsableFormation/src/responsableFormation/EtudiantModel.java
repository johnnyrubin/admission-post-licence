package responsableFormation;

import AdmissionPostLicence.identite;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 */
public class EtudiantModel extends AbstractTableModel {
    
    private final String[] entetes = {"INE", "Nom", "Prénom", "Université", "Licence"};
    private final List<Etudiant> etudiants;

    public EtudiantModel(List<identite> desEtudiants) {
        etudiants = new ArrayList<>();
        
        Etudiant e;
        
        for (identite i : desEtudiants) {
            e = new Etudiant();
            e.setIne(i.ine);
            e.setNom(i.nom);
            e.setPrenom(i.prenom);
            e.setUniversite(i.universite);
            e.setLicence(i.licence);
            etudiants.add(e);
        }
    }
    
    @Override
    public int getRowCount() {
        return etudiants.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0:
                return etudiants.get(i).getIne();
            case 1:
                return etudiants.get(i).getNom();
            case 2:
                return etudiants.get(i).getPrenom();
            case 3:
                return etudiants.get(i).getUniversite();
            case 4:
                return etudiants.get(i).getLicence();
            default:
                throw new IllegalArgumentException();
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
    
    /**
     * 
     * @return List<{@link Etudiant}>
     */
    public List<Etudiant> getResultats() {
        return etudiants;
    }
    
}
