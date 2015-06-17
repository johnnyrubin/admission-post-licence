package AdmissionPostLicence;

/**
 * Struct definition : resultatsEtudiant
 * 
 * @author OpenORB Compiler
*/
public final class resultatsEtudiant implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member etudiant
     */
    public AdmissionPostLicence.identite etudiant;

    /**
     * Struct member resultatsSemestres
     */
    public AdmissionPostLicence.resultat[] resultatsSemestres;

    /**
     * Default constructor
     */
    public resultatsEtudiant()
    { }

    /**
     * Constructor with fields initialization
     * @param etudiant etudiant struct member
     * @param resultatsSemestres resultatsSemestres struct member
     */
    public resultatsEtudiant(AdmissionPostLicence.identite etudiant, AdmissionPostLicence.resultat[] resultatsSemestres)
    {
        this.etudiant = etudiant;
        this.resultatsSemestres = resultatsSemestres;
    }

}
