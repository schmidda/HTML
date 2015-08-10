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
 * Represent a HTML5 document
 * @author desmond
 */
public class HTML extends Element
{
    /** the HTML head element */
    Head head;
    /** the body as a string (gets built as we go) */
    StringBuilder body;
    /**
     * Create an instance of a HTML document
     */
    public HTML()
    {
        head = new Head();
        body = new StringBuilder();
    }
    /**
     * Get the head.
     * @return the head
     */
    public Head getHead()
    {
        return head;
    }
    /**
     * Add some raw text to the body
     * @param text the text
     */
    public void addText( String text )
    {
        body.append( text );
    }
    /**
     * Add an element to the body
     * @param elem the element
     */
    public void addElement( Element elem )
    {
        body.append( elem.toString() );
    }
    /**
     * Convert the document to a string
     * @return a HTML5 document
     */
    public String toString()
    {
        return "<!doctype HTML>\n<html>"
            +head.toString()
            +"<body>"+body.toString()+"</body>"
            +"</html>";
    }
}
