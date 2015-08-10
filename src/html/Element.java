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
import html.Element;
/**
 * Represent a generic HTML5 element
 * @author desmond
 */
public class Element
{
    /** child elements */
    ArrayList<Element> children;
    /** a list of the element's attributes */
    ArrayList<Attribute> attrs;
    /** the tag name */
    String name;
    public Element()
    {
    }
     /**
     * Create an element
     * @param name the tag name
     */
    public Element( String name )
    {
        this.name = name;
        attrs = new ArrayList<Attribute>();
    }
    /**
     * Add an attribute to the script element
     * @param name name of the attribute
     * @param value its value
     */
    public void addAttribute( String name, String value )
    {
        attrs.add( new Attribute(name,value) );
    }
    /**
     * Add an attribute to the script element
     * @param name name of the attribute
     * @param value its value
     */
    public void addAttribute( Attribute attr )
    {
        attrs.add( attr );
    }
    /**
     * Add a textual string to the elements
     * @param text the raw text to add as one element
     */
    public void addText( String text )
    {
        if ( children == null )
            children = new ArrayList<Element>();
        children.add( new Text(text) );
    }
    /**
     * add an ordinary child element
     * @param child the child to add
     */
    public void addChild( Element child )
    {
        if ( children == null )
            children = new ArrayList<Element>();
        children.add( child );
    }
    /**
     * Get an element by its id attribute
     * @param tag the tag name to search for
     * @return the element or null
     */
    public Element getElementByTagName( String tag )
    {
        if ( this.name != null && this.name.equals(tag) )
            return this;
        else if ( children != null )
        {
            for ( int i=0;i<children.size();i++ )
            {
                Element child = children.get(i);
                Element e = child.getElementByTagName(tag);
                if ( e != null )
                    return e;
            }
        }
        return null;
    }
    /**
     * Get an element by its id attribute
     * @param id the id value to search for
     * @return the element or null
     */
    public Element getElementById( String id )
    {
        if ( attrs != null )
        {
            for ( int i=0;i<attrs.size();i++ )
            {
                Attribute a = attrs.get( i );
                if ( a.name.equals(HTMLNames.ID)&&a.value.equals(id) )
                    return this;
            }
        }
        // not here: recurse
        if ( children != null )
        {
            for ( int i=0;i<children.size();i++ )
            {
                Element child = children.get(i);
                Element e = child.getElementById(id);
                if ( e != null )
                    return e;
            }
        }
        return null;
    }
    /**
     * Ask all children to build but do nothing else
     */
    public void build()
    {
        if ( children != null )
        {
            for ( int i=0;i<children.size();i++ )
                children.get(i).build();
        }
    }
    /**
     * Add another value to the end of an existing attribute
     * @param key the name of the attribute to extend
     * @param extension the extension separated by a space
     */
    public void extendAttribute( String key, String extension )
    {
        for ( int i=0;i<attrs.size();i++ )
        {
            Attribute attr = attrs.get(i);
            if ( attr.name.equals(key) )
            {
                attr.value += " "+extension;
                break;
            }
        }
    }
    /**
     * Compose a HTML element for output. Allow for only text content.
     * @return a String
     */
    public String toString()
    {
        String res = "";
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if ( name == null )
        {
            // just text or literal HTML
            if ( children != null )
            {
                StringBuilder sb = new StringBuilder();
                for ( int i=0;i<children.size();i++ )
                    sb.append(children.get(i).toString());
                res = sb.toString();
            }
        }
        else 
        {
            if ( attrs != null )
            {
                for ( int i=0;i<attrs.size();i++ )
                    sb1.append( attrs.get(i).toString() );
            }
            if ( children != null )
            {
                for ( int i=0;i<children.size();i++ )
                    sb2.append( children.get(i).toString() );
                res = "<"+name+sb1.toString()+">"+sb2.toString()+"</"+name+">\n";
            }
            else
                res = "<"+name+sb1.toString()+">"+sb2.toString()+"</"+name+">";
        }
        return res;
    }
    /**
     * Do we have no content?
     * @return 
     */
    public boolean isEmpty()
    {
        return children == null || children.size()==0;
    }
}
