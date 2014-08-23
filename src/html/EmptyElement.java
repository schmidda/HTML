/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package html;

/**
 * Empty elements have no end tag in HTML5
 * @author desmond
 */
public class EmptyElement extends Element 
{
    public EmptyElement( String name )
    {
        super(name);
    }
    /**
     * Write out the element. No content.
     * @return a string
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append( name );
        for ( int i=0;i<attrs.size();i++ )
            sb.append( attrs.get(i).toString() );
        sb.append(">");
        //System.out.println("Wrote empty element "+sb.toString());
        return sb.toString();
    }
}
