package Datastructs.SimpleList;

import java.util.Iterator;

import Datastructs.ListInterface;

/** @author zyoruk,jeukel
 *
 * @param <K> */

public class SimpleList < K > implements ListInterface < K >, Iterable < K > {

    protected int		  length;
    protected SimpleListNode < K > head;
    protected SimpleListNode < K > tail;

    /** Constructor */
    public SimpleList() {

	this.length = 0;
	this.head = null;
	this.tail = null;
    }

    /** Copy constructor
     * 
     * @param U */
    public SimpleList(SimpleList<K> U) {
	this.length = U.length;
	this.head = U.head;
	this.tail = U.tail;
    }

    /** Adds at the end. */
    @Override
    public boolean append(K pk) {

	final SimpleListNode < K > node = new SimpleListNode < K >( pk );

	if ( isEmpty() ) {
	    this.head = node;
	} else {
	    this.tail.setNext( node );
	}
	this.tail = node;
	this.length += 1;
	return true;
    }

    /* Links two lists together. */
    public boolean append(SimpleList < K > pk) {

	if ( pk.head != null ) {
	    if ( this.head == null ) {
		this.head = pk.head;
	    } else {
		if ( this.tail == null ) {
		    System.out.println( "No tail." );
		}
		this.tail.setNext( pk.head );
	    }
	    this.tail = pk.tail;
	    this.length += pk.length;
	} else {
	    System.out.println( "List empty. Nothing changed." );
	}
	return true;
    }

    public boolean append(SimpleListNode < K > pk) {

	if ( isEmpty() ) {
	    this.head = pk;
	} else {
	    this.tail.setNext( pk );
	}
	this.tail = pk;
	this.length += 1;
	return true;
    }

    /** Empties the list. */
    @Override
    public boolean clear() {

	SimpleListNode < K > temp = null;
	while ( this.head != null ) {
	    temp = this.head.getNext();
	    this.head.setNext( null );
	    this.head = temp;
	}
	this.tail = null;
	this.length = 0;
	return true;
    }

    @Override
    public boolean cut() {

	return false;
    }

    /** Deletes the first node. */
    @Override
    public boolean delete() {

	// Set tmp list
	final SimpleListNode < K > node = this.head.getNext();

	// Destroy
	this.head = null;

	// Set new list
	this.head = node;
	this.length--;
	return true;
    }

    /* Deletes the element */
    @Override
    public boolean delete(K pk) {

	if ( this.isEmpty() ) { return false; }

	// Search node
	SimpleListNode < K > previous = null;
	SimpleListNode < K > current = this.head;

	while ( current != null ) {
	    if ( current.getElem().equals( pk ) ) {
		break;
	    }
	    previous = current;
	    current = current.getNext();
	}

	// If not found
	if ( current == null ) { return false; }

	// Found, check head
	if ( current == this.head ) {
	    System.out.println( "Doing head thigs" );
	    this.head = current.getNext();
	}

	// Found, check tail
	if ( current == this.tail ) {
	    this.tail = previous;
	}

	// Remove node
	if ( previous != null ) {
	    previous.setNext( current.getNext() );
	}
	current.setNext( null );
	current = null;
	this.length -= 1;
	return true;
    }

    /** Describes the list
     * 
     * @return Description */
    @Override
    public String describe() {

	final String string = ( "It was null after all" );
	if ( this.head != null ) {
	    final StringBuilder result = new StringBuilder();

	    result.append( "List: " );
	    for ( final K k : this ) {
		result.append( String.format( "%s " , k.toString() ) );
	    }
	    result.append( "\n" );

	    result.append( String.format( "Length: %d\n" , this.length ) );
	    result.append( String.format( "Head: %s\n" , this.head.getElem().toString() ) );
	    result.append( String.format( "Tail: %s\n" , this.tail.getElem().toString() ) );

	    return result.toString();
	}
	System.out.println( "It was null after all" );
	return string;
    }

    /** Checks if the element is in the list
     * 
     * @param pk
     *            element to search */

    @Override
    public boolean exists(K pk) {

	for ( final K ck : this ) {
	    if ( ck.equals( pk ) ) { return true; }
	}
	return false;
    }

    @Override
    public K getData() {

	if ( this.head == null ) { return null; }
	return this.head.getElem();
    }

    public K getElementAt(int pIndex) {

	if ( pIndex >= this.length ) {
	    final K k = null;
	    return k;
	}
	SimpleListNode < K > temp = this.head;
	int tempIn = pIndex;
	while ( tempIn != 0 ) {
	    temp = temp.getNext();
	    tempIn--;
	}

	return temp.getElem();

    }

    @Override
    public K getTailData() {

	if ( this.tail == null ) { return null; }
	return this.tail.getElem();
    }

    /** Inserts at some position
     * 
     * @param pos
     *            where to add
     * @param pk
     *            what to add. */
    @Override
    public boolean insert(int pos, K pk) {

	final SimpleListNode < K > node = new SimpleListNode < K >( pk );

	// Check valid position
	if ( ( pos < 0 ) || ( pos > this.length ) ) { return false; }

	// Search position
	SimpleListNode < K > previous = null;
	SimpleListNode < K > current = this.head;
	for ( int i = 0; i != pos; i++ ) {
	    previous = current;
	    current = current.getNext();
	}

	// Insert node
	node.setNext( current );
	if ( previous != null ) {
	    previous.setNext( node );
	}

	// Check head
	if ( current == this.head ) {
	    this.head = node;
	}
	// Check tail
	if ( previous == this.tail ) {
	    this.tail = node;
	}

	this.length += 1;
	return true;
    }

    /** Inserts at the beginning of the list. */
    @Override
    public boolean insert(K pk) {

	final SimpleListNode < K > node = new SimpleListNode < K >( pk );

	// if no tail.
	if ( this.isEmpty() ) {
	    this.tail = node;
	}

	// Insert node
	node.setNext( this.head );

	// Check head
	this.head = node;

	this.length += 1;
	return true;
    }

    /** Checks if the list is empty
     * 
     * @return boolean. */
    @Override
    public boolean isEmpty() {

	return this.head == null;
    }

    /** calls the iterator */
    @Override
    public Iterator < K > iterator() {

	return new SimpleListIterator < K >( this );
    }

    /** @return size of the list */
    @Override
    public int length() {

	return this.length;
    }
}

/** In charge of managing the reading of the list.
 * 
 * @author zyoruk, jeukel
 *
 * @param <K> */
class SimpleListIterator < K > implements Iterator < K > {

    SimpleList < K >     list;
    SimpleListNode < K > current;

    /** Constructor
     * 
     * @param list */
    public SimpleListIterator(SimpleList < K > list) {

	this.list = list;
	this.current = null;
    }

    /** Checks if the node has next.
     * 
     * @return true if has next. */
    @Override
    public boolean hasNext() {

	if ( this.current == null ) {
	    if ( this.list.isEmpty() ) { return false; }
	    this.current = this.list.head;
	    return true;
	}

	this.current = this.current.getNext();
	return this.current != null;
    }

    /** @return the element of the next node. */
    @Override
    public K next() {

	if ( this.current == null ) { return null; }
	return this.current.getElem();
    }

    @Override
    public void remove() {

	throw new UnsupportedOperationException();
    }
}
