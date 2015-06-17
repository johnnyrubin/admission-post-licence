package responsableFormation;

import AdmissionPostLicence.resultat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * 
 */
public class ResultatModel extends AbstractTableModel {
    
    private final String[] entetes = {"Semestre", "Moyenne", "Classement"};
    private final List<Resultat> resultats;
    
    /**
     * 
     * @param desResultats 
     */
    public ResultatModel(resultat[] desResultats) {
        resultats = new ArrayList<>();
        Resultat r;
        
        for (resultat resultat : desResultats) {
            r = new Resultat();
            r.setSemestre(resultat.code);
            r.setMoyenne(String.valueOf(resultat.moyenne));
            r.setClassement(String.valueOf(resultat.position));
            resultats.add(r);
        }
    }

    @Override
    public int getRowCount() {
        return resultats.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0:
                // Semestre
                return resultats.get(i).getSemestre();
            case 1:
                // Moyenne
                return resultats.get(i).getMoyenne();
            case 2:
                // Classement
                return resultats.get(i).getClassement();
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
     * @return List<{@link Resultat}>
     */
    public List<Resultat> getResultats() {
        return resultats;
    }
    
}
