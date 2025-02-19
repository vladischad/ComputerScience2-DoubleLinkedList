/**
 *  
 * @author Vlad Maliutin
 */

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class IUDoubleLinkedList<T> implements IndexedUnsortedList 
{
    //Node class
    protected class Node
    {
        protected Object item;
        protected Node next, previous;

        protected Node(Object item, Node next, Node previous) 
        {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    protected int size;
    protected Node header, tail;

    public IUDoubleLinkedList() 
    {
        size = 0;
        header = tail = null;
    }
   

    
    //Iterator class
    public class iter implements ListIterator<T>
    {
        private Node current;
        private Node last;
        
        public iter()
        {
            current = header;
            last = null;
        }
        


        //Methods
        @Override
        public T next()
        {
            if(current != null)
            {
                Object returnData = current.item;
                last = current;
                current = current.next;
                if(current != null)
                {
                    current.previous = last;
                }
                return (T) returnData;
            }
            else
            {
                throw new NoSuchElementException();
            }
        }

        @Override
        public boolean hasNext()
        {
            return current!=null;
        }

        @Override
        public T previous()
        {
            if(last != null)
            {
                current = last;
                last= current.previous;
                Object returnData = current.item;
                return (T) returnData;
            }
            else
            {
                throw new NoSuchElementException();
            }
        }

        @Override
        public boolean hasPrevious()
        {
            return last!=null;
        }
        
        @Override
        public void set(T elem)
        {
            current.item = elem;
        }

        @Override
        public int nextIndex() 
        {
            return this.nextIndex();
        }

        @Override
        public int previousIndex() 
        {
            return this.previousIndex();
        }

        @Override
        public void remove() 
        {
            this.remove();
        }

        @Override
        public void add(T e) 
        {
            this.add(e);
        }
    }

    



    //Start of all methods
    @Override
    public void addToFront(Object element) 
    {
        Node tmp = new Node(element, header, null);
        if (header != null)
        {
            header.previous = tmp;
        }
        header = tmp;
        if (tail == null)
        {
            tail = tmp;
        }
        size++;
    }

    @Override
    public void addToRear(Object element) 
    {
        Node tmp = new Node(element, null, tail);
        if (tail != null)
        {
            tail.next = tmp;
        }
        tail = tmp;
        if (header == null)
        {
            header = tmp;
        }
        size++;
    }

    @Override
    public void add(Object element) 
    {
        Node tmp = new Node(element, null, tail);
        if (tail != null)
        {
            tail.next = tmp;
        }
        tail = tmp;
        if (header == null)
        {
            header = tmp;
        }
        size++;
    }

    @Override
    public void addAfter(Object element, Object target) 
    {
        int index = indexOf(element);

        if((index + 1 < 0) || (index + 1 > size))
        {
            throw new java.lang.IndexOutOfBoundsException();
        }
        else if(index == size - 1)
        {
            addToRear(element);
        }
        else
        {
            Node temp = header;
            int i = 0;

            while(i  < index - 1)
            {
                temp = temp.next;
                i++;
            }

            temp.next = (IUDoubleLinkedList<T>.Node) element;
            size++;
        } 
    }

    @Override
    public void add(int index, Object element) 
    {
        if((index < 0) || (index > size))
        {
            throw new java.lang.IndexOutOfBoundsException();
        }

        if(index == 0)
        {
            addToFront(element);
        }
        else if(index == size)
        {
            addToRear(element);
        }
        else
        {
            Node temp = header;
            int i = 0;

            while(i  < index - 1)
            {
                temp = temp.next;
                i++;
            }

            temp.next = (IUDoubleLinkedList<T>.Node) element;
            size++;
        }
    }

    @Override
    public Object removeFirst() 
    {
        if (size == 0)
        {
            throw new NoSuchElementException("Linked list is empty");
        }
        Node tmp = header;
        header = header.next;
        header.previous = null;
        size--;
        return tmp.item;
    }

    @Override
    public Object removeLast() 
    {
        if (header == null)
        {
            throw new NoSuchElementException("Linked list is empty");
        }
        Node currentNode = header;
        Node previousNode = null;

        while (currentNode != null)
        {
            if (currentNode.equals(tail))
            {
                tail = previousNode;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        size--;
        return currentNode.item;
    }

    @Override
    public Object remove(Object element) 
    {
        Node prev = null, curr = header;
        while (curr != null)
        {
            if (curr == header)
            {
                header = header.next;
                curr = header;
            }
            else if (curr == tail)
            {
                curr = null;
                tail = prev;
                prev.next = null;
            }
            else 
            {
                prev.next = curr.next;
                curr = curr.next;
            }
            size--;
        }
        return this;
    }

    @Override
    public Object remove(int index) 
    {
        if((index < 0) || (index > size))
        {
            throw new java.lang.IndexOutOfBoundsException();
        }
        
        if(index==0)
        {
            if(header==null)
            {
                return null;
            }
            Object data = header.item;
            header = header.next;
            return data;
        }
        else
        {
            Node temp = header;
            int i=0;

            while(i < index - 1)
            {
                temp = temp.next;
                i++;
            }

            Node indexNode = temp.next;
            T data=(T) indexNode.item;
            temp.next = indexNode.next;
            return data;
        }
    }

    @Override
    public Object get(int index) {
        if(index < 0 || index > size)
        {
            throw new java.lang.IndexOutOfBoundsException();
        }
        
        if(index==0)
        {
            if(header==null)
            {
            return null;
            }
            return header.item;
        }
        else if(index==size-1)
        {
            return tail.item;
        }
        else
        {
            Node temp = header;
            int i=0;
            while(i<index)
            {
                temp = temp.next;
                i++;
            }
            return temp.item;
        }
    }

    @Override
    public int indexOf(Object element) {
        int index = -1;
		
		if (!isEmpty()) {
			int i = 0;
			while (index == -1 && i < size) 
            {
				if (element.equals(get(i))) 
                {
					index = i;
				} 
                else 
                {
					i++;
				}
			}
		}
		
		return index;
    }

    @Override
    public Object first() {
        return header.item;
    }

    @Override
    public Object last() {
        return tail.item;
    }

    @Override
    public boolean contains(Object target) 
    {
        if (size >= 1)
        {
            int i = 0;
			while (i < size) 
            {
				if (target.equals(get(i))) 
                {
					return true;
				} 
                else 
                {
					i++;
				}
			}
        } 

		return false;
    }

    @Override
    public boolean isEmpty() 
    {
        if (header == null)
        {
            return true;
        }
        return false;
    }

    @Override
    public int size() 
    {
        return size;
    }

    @Override
    public void set(int index, Object element) {
        if((index < 0) || (index > size))
        {
            throw new java.lang.IndexOutOfBoundsException();
        } 
		else
        {
            Node temp = header;
            temp.next = (IUDoubleLinkedList<T>.Node) element;
        }
    }

    @Override
    public ListIterator listIterator() 
    {
        return new iter();
    }

    @Override
    public ListIterator listIterator(int startingIndex) 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public Iterator iterator() 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}