package myset;
import java.sql.SQLOutput;
import java.util.*;

public class MySet<T> implements Cloneable {
    Vector<T> newSet = new Vector<T>();
    @Override
    public Object clone() throws CloneNotSupportedException {
        MySet oClon = new MySet<T>();
        for(T element:newSet)   {
            oClon.insertToSet(element);
        }
        return oClon;
    }
    int sizeSet()  {
        return newSet.size();
    }

    void insertToSet(T element) {
        if(isMember(element) == false)   {
            newSet.add(element);
        }
        else {
            System.out.println("There is already such element");
        }
    }

    void popFromSet(T element) {
        if(isMember(element) == true)   {
            newSet.remove(element);
        }
        else {
            System.out.println("No such element");
        }
    }

    boolean isMember(T element) {
        if(newSet.contains(element) == true)   {
            return true;
        }
        else  {
            return false;
        }

    }

    void displaySet()   {
        for(T element: newSet)  {
            System.out.println(element);
        }
    }

    public MySet union(MySet<T> s2) throws CloneNotSupportedException {
        MySet<T> s3 = (MySet<T>) s2.clone();

        for(T element: newSet)  {
            if(s3.isMember(element) == false)  {
                s3.insertToSet(element);
            }
        }
        return s3;
    }

    public MySet difference(MySet<T> s2) throws CloneNotSupportedException {
        MySet<T> s3 = (MySet<T>) this.clone();

        for(T element: s2.newSet)  {
            if(isMember(element) == true)  {
                s3.popFromSet(element);
            }
        }
        return s3;
    }

    public MySet intersection(MySet<T> s2) throws CloneNotSupportedException {
        MySet<T> s3 = new MySet<T>();

        for(T element: newSet)  {
            if(s2.isMember(element) == true)  {
                s3.insertToSet(element);
            }
        }
        return s3;
    }

    void popAll(MySet<T> s2)    {
        for(T element: s2.newSet)  {
            if(isMember(element) == true)    {
                popFromSet(element);
            }
        }
    }


}




/*
    std::vector<T> difference(Set set2) {
        std::vector<int>::iterator it_set2 = set2.set.begin();
        T element;

        Set<T> c;
        c.set=set;

        for(; it_set2 != set2.set.end(); it_set2++) {
            element = *it_set2;
            if(isMember(element)==true)
            {
                c.pop(element);
            }


        }
        return c.set;
    }

    std::vector<T> intersection(Set set2) {
        std::vector<int>::iterator it_set2 = set2.set.begin();

        T element;

        Set<T> c;
        c.set = set;

        for(; it_set2 != set2.set.end(); it_set2++) {
            element = *it_set2;
            if(c.isMember(element)==false)
            {
                c.pop(element);
            }


        }
        return c.set;
    }

    void popAll(Set set2) {
        std::vector<int>::iterator it_set2 = set2.set.begin();
        T element;

        for(; it_set2 != set2.set.end(); it_set2++) {
            element = *it_set2;
            if(isMember(element)==true)
            {
                if(set2.isMember(element)==true)
                {
                    pop(element);
                }
            }


        }
    }

};
*/