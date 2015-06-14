package AdmissionPostLicence;

/**
 * Enum definition : decisionCandidat
 *
 * @author OpenORB Compiler
*/
public final class decisionCandidat implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member nonTraite value 
     */
    public static final int _nonTraite = 0;

    /**
     * Enum member nonTraite
     */
    public static final decisionCandidat nonTraite = new decisionCandidat(_nonTraite);

    /**
     * Enum member ouiDefinitif value 
     */
    public static final int _ouiDefinitif = 1;

    /**
     * Enum member ouiDefinitif
     */
    public static final decisionCandidat ouiDefinitif = new decisionCandidat(_ouiDefinitif);

    /**
     * Enum member ouiMais value 
     */
    public static final int _ouiMais = 2;

    /**
     * Enum member ouiMais
     */
    public static final decisionCandidat ouiMais = new decisionCandidat(_ouiMais);

    /**
     * Enum member nonMais value 
     */
    public static final int _nonMais = 3;

    /**
     * Enum member nonMais
     */
    public static final decisionCandidat nonMais = new decisionCandidat(_nonMais);

    /**
     * Enum member nonDefinitif value 
     */
    public static final int _nonDefinitif = 4;

    /**
     * Enum member nonDefinitif
     */
    public static final decisionCandidat nonDefinitif = new decisionCandidat(_nonDefinitif);

    /**
     * Internal member value 
     */
    private final int _decisionCandidat_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private decisionCandidat( final int value )
    {
        _decisionCandidat_value = value;
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
        return _decisionCandidat_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static decisionCandidat from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return nonTraite;
        case 1 :
            return ouiDefinitif;
        case 2 :
            return ouiMais;
        case 3 :
            return nonMais;
        case 4 :
            return nonDefinitif;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_decisionCandidat_value)
        {
        case 0 :
            return "nonTraite";
        case 1 :
            return "ouiDefinitif";
        case 2 :
            return "ouiMais";
        case 3 :
            return "nonMais";
        case 4 :
            return "nonDefinitif";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
