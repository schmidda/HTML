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
 * A pseudo-Element containing valid unparsed HTML
 * @author desmond
 */
public class Literal extends Element
{
    public Literal()
    {
        super("");
    }
    public Literal( String content )
    {
        super("");
        addText(content);
    }
    public void addChild( Element child )
    {
        super.addChild(child);
    }
    /**
     * We can't add an attribute because we are only text
     * @param name ignored
     * @param value ignored
     */
    public void addAttribute( String name, String value )
    {
    }
}
