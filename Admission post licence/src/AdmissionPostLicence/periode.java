package AdmissionPostLicence;

/**
 * Enum definition : periode
 *
 * @author OpenORB Compiler
*/
public final class periode implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member periode1 value 
     */
    public static final int _periode1 = 0;

    /**
     * Enum member periode1
     */
    public static final periode periode1 = new periode(_periode1);

    /**
     * Enum member periode2 value 
     */
    public static final int _periode2 = 1;

    /**
     * Enum member periode2
     */
    public static final periode periode2 = new periode(_periode2);

    /**
     * Enum member periode3 value 
     */
    public static final int _periode3 = 2;

    /**
     * Enum member periode3
     */
    public static final periode periode3 = new periode(_periode3);

    /**
     * Enum member periode4 value 
     */
    public static final int _periode4 = 3;

    /**
     * Enum member periode4
     */
    public static final periode periode4 = new periode(_periode4);

    /**
     * Internal member value 
     */
    private final int _periode_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private periode( final int value )
    {
        _periode_value = value;
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
        return _periode_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static periode from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return periode1;
        case 1 :
            return periode2;
        case 2 :
            return periode3;
        case 3 :
            return periode4;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_periode_value)
        {
        case 0 :
            return "periode1";
        case 1 :
            return "periode2";
        case 2 :
            return "periode3";
        case 3 :
            return "periode4";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
