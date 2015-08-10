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
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
/**
 * Select dropdown
 * @author desmond
 */
public class Select extends Element
{
    /**
     * Create a HTML select list
     * @param map a map of name-value pairs
     * @param id the id of the select list
     * @param selected name of option to preselect
     */
    public Select( HashMap<String,String> map, String id, String selected )
    {
        super("select");
        this.addAttribute( "id", id );
        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();
        while ( iter.hasNext() )
        {
            String key = iter.next();
            Option option = new Option(key,map.get(key));
            if( key.equals(selected) )
                option.addAttribute("selected","selected");
            this.addChild( option );
        }
    }   
}
