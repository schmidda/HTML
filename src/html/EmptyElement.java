/*
 * This file is part of HTML.
 *
 *  HTML is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  HTML is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with HTML.  If not, see <http://www.gnu.org/licenses/>.
 *  (c) copyright Desmond Schmidt 2014
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
