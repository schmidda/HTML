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
import java.util.ArrayList;
/**
 * Represent a HTML5 head
 * @author desmond
 */
public class Head 
{
    ArrayList<Script> scripts;
    ArrayList<EmptyElement> metas;
    ArrayList<EmptyElement> links;
    Element css;
    /**
     * Create a head
     */
    public Head()
    {
        scripts = new ArrayList<Script>();
        metas = new ArrayList<EmptyElement>();
        links = new ArrayList<EmptyElement>();
        css = new Element("style");
        css.addAttribute("type","text/css");
    }
    /**
     * Add a JQuery reference to an external script
     * @param version the version required
     * @param dir the directory in which the local jquery resides or null
     * @paramlocal true if the copy of jquery is in the local directory
     */
    public void addJQuery( String version, String dir, boolean local )
    {
        scripts.add( new JQueryRef(version,dir,local) );
    }
    /**
     * Add a script with contents
     * @param script the contents
     */
    public void addScript( String script )
    {
        scripts.add( new Script(script) );
    }
    /**
     * Add a local script file
     * @param url the file's url or local file name
     */
    public void addScriptFile( String url )
    {
        Script s = new Script("");
        s.addAttribute("src",url );
        scripts.add( s );
    }
    /**
     * Add somecss
     * @param text the css to add
     */
    public void addCss( String text )
    {
        css.addText( text );
    }
    /**
     * Add a reference to a simple css file
     * @param fileName the name of the file
     */
    public void addCssFile( String fileName )
    {
        EmptyElement link = new EmptyElement("link");
        link.addAttribute( "href", fileName );
        link.addAttribute( "rel", "stylesheet");
        links.add( link );
    }
    /**
     * Add a header encoding like UTF-8
     * @param enc the text of the encoding in HTML5 compatible form
     */
    public void addEncoding( String enc )
    {
        EmptyElement elem = new EmptyElement("meta");
        elem.addAttribute("http-equiv","Content-Type");
        elem.addAttribute("content","text/html;charset="+enc);
        metas.add( elem );
    }
    /**
     * Convert the head to a string
     * @return a HTML string being the entire header
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<head>\n");
        for ( int i=0;i<metas.size();i++ )
        {
            sb.append( metas.get(i) );
            sb.append("\n");
        }
        for ( int i=0;i<links.size();i++ )
        {
            sb.append( links.get(i) );
            sb.append("\n");
        }
        for ( int i=0;i<scripts.size();i++ )
            sb.append( scripts.get(i) );
        if ( !css.isEmpty() )
            sb.append(css);
        sb.append("</head>\n");
        return sb.toString();
    }
}