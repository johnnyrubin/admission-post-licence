package Universite;

import Universite.GestionEtudiant.GestionEtudiantImpl;
import Universite.Master.MasterImpl;
import universite.database.MasterDAO;
import Pojo.Master;
import Universite.database.InitDbUniversite;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.omg.PortableServer.Servant;

/**
 * Classe principale d'un serveur universitaire
 * 
 * 
 */
public class ServerUniversite {
    
    /** Contient l'orb accessible par les autres classes */
    private static org.omg.CORBA.ORB orb;
    
    private static POA rootPOA;
    
    public static org.omg.CORBA.ORB getOrb() {
        return orb;
    }
    
    public static POA getRootPOA() {
        return rootPOA;
    }
    
    public static void main(String[] args) {
        
        if(args.length == 3) {
            // Récupération des paramètres
            String nameUniversite = args[0];
            String nameRectorat = args[1];
            String ipNamingService = args[2];
            
            // Initialisation de la base de données si nécessaire
            InitDbUniversite.run(nameUniversite);

            try {
                // Intialisation de l'ORB
                orb = org.omg.CORBA.ORB.init(args, null);
                orb.string_to_object("corbaloc:iiop:1.2@" + ipNamingService + ":2001/NameService");

                // Récupération du POA
                rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

                // Création du servant pour la gestion des étudiants
                GestionEtudiantImpl gestEtu = new GestionEtudiantImpl(nameUniversite, nameRectorat);

                // Activer le POA manager
                rootPOA.the_POAManager().activate();

                // Récupération du naming service
                NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@" + ipNamingService + ":2001/NameService"));

                // Construction du nom à enregistrer
                org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
                nameToRegister[0] = new org.omg.CosNaming.NameComponent(nameUniversite, "");

                // Enregistrement de l'objet CORBA dans le service de noms
                nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(gestEtu));
                System.out.println("==> Université \"" + nameUniversite + "\" est enregistré dans l'espace de noms");

                String IORServant = orb.object_to_string(rootPOA.servant_to_reference(gestEtu));
                System.out.println("L'objet possède la référence suivante : ");
                System.out.println(IORServant);

                // Récupération de la liste des masters de l'université
                MasterDAO dao = new MasterDAO(nameUniversite);
                List<Master> masters = dao.getAll();

                // Enregistrement des masters dans le service de nom
                MasterImpl m;

                for(Master master : masters) {
                    m = new MasterImpl(master.getNom(), nameRectorat, nameUniversite);

                    nameToRegister[0] = new org.omg.CosNaming.NameComponent(m.nom(), "");

                    nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(m));
                    System.out.println("==> Master \"" + m.nom() + "\" est enregistré dans l'espace de noms");

                    IORServant = orb.object_to_string(rootPOA.servant_to_reference(m));
                    System.out.println("L'objet possède la référence suivante : ");
                    System.out.println(IORServant);
                }

                // Lancement de l'ORB et mise en attente de la requête
                orb.run();

            } catch(InvalidName | AdapterInactive | WrongPolicy | ServantNotActive | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
                e.printStackTrace();
            }
        }
    }
    
    public static String getIorFromObject(Servant o) {
        String retour = null;
        if(o != null) {
            try {
                retour = orb.object_to_string(rootPOA.servant_to_reference(o));
            } catch (ServantNotActive | WrongPolicy ex) {
                Logger.getLogger(ServerUniversite.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return retour;
    }
    
}
