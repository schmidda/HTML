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
 * Represent a HTML5 form
 * @author desmond
 */
public class Form extends Element 
{
    /**
     * Create a form instance
     * @param method the method attribute of the form
     * @param url the url to post/get to
     * @param encType the enctype attribute for the form
     */
    public Form( String method, String url, String encType )
    {
        super( "form" );
        addAttribute("method",method);
        addAttribute("action",url);
        addAttribute( "enctype", encType );
    }
}
