package AdmissionPostLicence;

/**
 * Enum definition : etatCandidature
 *
 * @author OpenORB Compiler
*/
public final class etatCandidature implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member nonTraite value 
     */
    public static final int _nonTraite = 0;

    /**
     * Enum member nonTraite
     */
    public static final etatCandidature nonTraite = new etatCandidature(_nonTraite);

    /**
     * Enum member nonValide value 
     */
    public static final int _nonValide = 1;

    /**
     * Enum member nonValide
     */
    public static final etatCandidature nonValide = new etatCandidature(_nonValide);

    /**
     * Enum member valide value 
     */
    public static final int _valide = 2;

    /**
     * Enum member valide
     */
    public static final etatCandidature valide = new etatCandidature(_valide);

    /**
     * Enum member cloture value 
     */
    public static final int _cloture = 3;

    /**
     * Enum member cloture
     */
    public static final etatCandidature cloture = new etatCandidature(_cloture);

    /**
     * Internal member value 
     */
    private final int _etatCandidature_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private etatCandidature( final int value )
    {
        _etatCandidature_value = value;
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
        return _etatCandidature_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static etatCandidature from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return nonTraite;
        case 1 :
            return nonValide;
        case 2 :
            return valide;
        case 3 :
            return cloture;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_etatCandidature_value)
        {
        case 0 :
            return "nonTraite";
        case 1 :
            return "nonValide";
        case 2 :
            return "valide";
        case 3 :
            return "cloture";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
