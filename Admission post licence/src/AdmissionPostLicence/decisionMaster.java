package AdmissionPostLicence;

/**
 * Enum definition : decisionMaster
 *
 * @author OpenORB Compiler
*/
public final class decisionMaster implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member admis value 
     */
    public static final int _admis = 0;

    /**
     * Enum member admis
     */
    public static final decisionMaster admis = new decisionMaster(_admis);

    /**
     * Enum member listeAttente value 
     */
    public static final int _listeAttente = 1;

    /**
     * Enum member listeAttente
     */
    public static final decisionMaster listeAttente = new decisionMaster(_listeAttente);

    /**
     * Enum member refuser value 
     */
    public static final int _refuser = 2;

    /**
     * Enum member refuser
     */
    public static final decisionMaster refuser = new decisionMaster(_refuser);

    /**
     * Internal member value 
     */
    private final int _decisionMaster_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private decisionMaster( final int value )
    {
        _decisionMaster_value = value;
    }

    /**
     * Maintains singleton property for serialized enums.
     * Issue 4271: IDL/Java issue, Mapping for IDL enum.
     */
    public java.lang.Object readResolve() throws java.io.ObjectStreamException
    {
        return from_int( value() );
    }

    /**
     * Return the internal member value
     * @return the member value
     */
    public int value()
    {
        return _decisionMaster_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static decisionMaster from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return admis;
        case 1 :
            return listeAttente;
        case 2 :
            return refuser;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_decisionMaster_value)
        {
        case 0 :
            return "admis";
        case 1 :
            return "listeAttente";
        case 2 :
            return "refuser";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
