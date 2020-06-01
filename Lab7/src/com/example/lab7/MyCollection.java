package com.example.lab7;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyCollection implements List<Armor>{
    private Armor [] Armors;
    private int REALSIZE;
    public class MyListIterator implements ListIterator<Armor> {
        Armor next;
        Armor previous;
        Armor item;
        int index=0;
        public MyListIterator(int i) {
            index = i;
            item=Armors[index];
            index++;
            next=Armors[index];
            if(i==0){
                previous=null;
            }
            else{
                previous=Armors[i-1];
            }
        }
        public MyListIterator() {
            index = 0;
            item=Armors[index];
            index++;
            next=Armors[index];
            previous=null;

        }
        @Override
        public void add(Armor e) {
            item=e;
            if (index ==Armors.length){
                next=null;
                previous=Armors[index];

                index++;

            }
            else{
                index++;
                previous=Armors[index-1];
            }
            MyCollection.this.add(e);
        }
        @Override
        public boolean hasNext() {
            return Armors[index-1]!=null;

        }
        @Override
        public boolean hasPrevious() {
            return previous!=null;
        }
        @Override
        public Armor next() {
            Armor it = item;
            item=next;
            previous=it;

            if (index ==Armors.length){
                next=null;


            }
            else{
                index++;
                next = Armors[index];
                previous=Armors[index-1];
            }
            return it;

        }
        @Override
        public int nextIndex() {
            return index;
        }
        @Override
        public com.example.lab7.Armor previous() {
            return previous;
        }
        @Override
        public int previousIndex() {
            return index-1;
        }
        @Override
        public void remove() {
            MyCollection.this.remove(index-1);

        }
        @Override
        public void set(Armor e) {
            MyCollection.this.set(index-2, e);
        }



    }
    public MyCollection() {
        Armor [] am = new Armor[15+ (int)(15*0.3)];
        Armors=am;
        REALSIZE=0;
    }
    public MyCollection(Armor e) {
        Armor [] am = new Armor[15+ (int)(15*0.3)];
        REALSIZE=0;
        am[REALSIZE]=e;
        REALSIZE=1;
        Armors=am;
    }
    public MyCollection(Armor [] am) {
        int i=0;
        Armor [] ambuf = new Armor [15+ (int)(15*0.3)];
        for (Armor Armor : am) {
            ambuf[i]= Armor;
            i++;
        }
        REALSIZE=i;
        Armors = ambuf;
        ambuf=null;
    }
    public MyCollection (ArrayList<Armor> arList) {
        Armor [] ambuf = new Armor [15+ (int)(15*0.3)];
        int k=0;
        for (Armor Armor : arList) {
            ambuf[k]=Armor;
            k++;
        }
        REALSIZE = k;
        Armors = ambuf;
    }
    public boolean add(Armor e) {
        if (REALSIZE>=0){
            Armors[REALSIZE]= e;
            REALSIZE++;
            return true;
        }
        else
            return false;
    }
    @Override
    public void add(int index, Armor element) {
        if (REALSIZE <Armors.length){
            int i=index;
            Armor buf2 ;
            Armor buf1 = Armors[index];

            while (Armors[i]!=null) {
                buf2=Armors[i+1];
                Armors[i+1]=buf1;
                buf1=Armors[i+2];
                Armors[i+2]=buf2;
                i++;
            }
            Armors[index]=element;
            REALSIZE++;

        }
    }
    @Override
    public boolean addAll(Collection<? extends Armor> c) {
        Object [] am = c.toArray();
        if ((Armors.length-REALSIZE)>=am.length){
            for (Object Armor : am) {
                Armors[REALSIZE]=(Armor)Armor;
                REALSIZE++;
            }
            return true;
        }else
            return false;

    }
    @Override
    public boolean addAll(int index, Collection<? extends Armor> c) {
        Object [] am = c.toArray();
        if ((Armors.length-REALSIZE)>=am.length){
            int i=index;
            Armor buf2 ;
            Armor buf1 = Armors[index];
            for (int j = 0; j < am.length; j++) {
                while (Armors[i]!=null) {
                    buf2=Armors[i+1];
                    Armors[i+1]=buf1;
                    buf1=Armors[i+2];
                    Armors[i+2]=buf2;
                    i++;
                }
            }
            for (Object Armor : am) {
                Armors[index]=(Armor)Armor;
                index++;
                REALSIZE++;
            }

            return true;
        }
        else
            return false;

    }
    @Override
    public void clear() {
        Armor [] am = new Armor[15+ (int)(15*0.3)];
        Armors=am;

    }
    @Override
    public boolean contains(Object e ) {
        boolean q= false;
        for (Armor Armor : Armors) {
            if (Armor.equals(e)){
                q=true;
            }
        }
        return q;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        boolean q = true;
        int i=0;
        Object [] amm = c.toArray();
        for(int j = 0; j<amm.length; j++){
            i=0;q=true;
            while ((Armors[i]!=null)&(q)) {
                if (Armors[i].equals(amm[j])){
                    q=false;
                    i++;
                    amm[j]=null;
                }
            }
        }
        q=true;
        for (Object Armor : amm) {
            if (Armor==null){
                q=true;
            }
            else q=false;
        }
        return  q;
    }
    @Override
    public Armor get(int index) {
        return Armors[index];
    }
    @Override
    public int indexOf(Object e) {
        boolean q=true;
        int positon = 0;
        ListIterator<Armor> itr = listIterator();
        if (q)
            while ((itr.hasNext())) {
                Armor Armor = itr.next();
                if (e.equals(Armor)){
                    q=false;
                    positon =  itr.nextIndex()-2;
                }
            }
        if (q){
            return -1;
        }
        else return positon;
    }
    @Override
    public boolean isEmpty() {
        boolean q= true;
        for (Armor Armor : Armors) {
            if (!(Armor==null)){
                q=false;;
            }
        }
        return q;
    }
    @Override
    public Iterator<Armor> iterator(){
        MyListIterator itr = new MyListIterator();
        return itr;
    }
    @Override
    public int lastIndexOf(Object e) {
        boolean q=true;
        int i=REALSIZE;
        while ((q)&(Armors[i]!=null)) {
            if(Armors[i].equals(e)){
                q=false;
            }
            else i--;
        }
        if (i==0) return -1;
        else return i-1;
    }
    @Override
    public ListIterator<Armor> listIterator() {
        MyListIterator itr = new MyListIterator();
        return itr;
    }
    @Override
    public ListIterator<Armor> listIterator(int index) {
        MyListIterator itr = new MyListIterator(index);
        return itr;

    }
    @Override
    public boolean remove(Object e) {

        int i=0;
        if (indexOf(e)!=-1){
            Armor [] am = new Armor[15+ (int)(15*0.3)];
            ListIterator<Armor> itr = listIterator();
            while (itr.hasNext()) {
                Armor Armor = itr.next();
                if (!Armor.equals(e)){
                    am[i]=Armor;
                    i++;
                }
            }
            Armors=null;
            Armors= am;
            REALSIZE--;
            return true;
        }
        else return false;
    }
    @Override
    public Armor remove(int index) {
        Armor [] newam = new Armor[Armors.length];
        int k=0;
        for (int i = 0; i < Armors.length; i++) {
            if(i!=index){
                newam[k]= Armors[i];
                k++;
            }
        }
        Armor buf = Armors[index];
        Armors=null;
        Armors = newam;
        REALSIZE--;
        return buf;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        Object [] am = c.toArray();

        ListIterator<Armor> itr1 = listIterator();
        while (itr1.hasNext()) {
            Armor Armor = itr1.next();
            for (Object object : am) {
                if (Armor.equals(object)){
                    remove(Armor);
                }
            }


        }
        return true;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        Object [] am = c.toArray();
        Armor [] newam = new Armor [Armors.length];
        int k=0;
        for (int i = 0; i < am.length; i++) {
            if (indexOf(am[i])!=-1){
                newam[k]=(Armor)am[i];
                k++;
            }
        }
        if (newam[0]!=null){
            Armors=null;
            Armors=newam;
            return true;
        }
        else
            return false;
    }
    @Override
    public Armor set(int index, Armor element) {
        if ((index>0)&(index<Armors.length))
            Armors[index]=element;
        return element;
    }
    @Override
    public int size() {
        return REALSIZE;
    }
    @Override
    public ArrayList<Armor> subList(int fromIndex, int toIndex) {
        ArrayList<Armor> am = new ArrayList<Armor>();
        for (int i = fromIndex; i < toIndex; i++) {
            am.add(Armors[i]);
        }
        return am;
    }
    @Override
    public Armor [] toArray() {
        int i=0;
        Armor [] am = new Armor [size()];
        ListIterator<Armor> itr = listIterator();
        while (itr.hasNext()) {
            Armor Armor = itr.next();
            am[i]=Armor;
            i++;
        }
        return am;

    }
    @SuppressWarnings({ "hiding", "unchecked", "null" })
    @Override
    public <Armor> Armor[] toArray(Armor[] array) {


        int reconciliation_counter = 0;
        for (com.example.lab7.Armor Armor : Armors) {
            for (Armor ams : array) {
                if (Armor.getClass().equals(ams.getClass())){
                    reconciliation_counter++;
                }
            }
        }
        if (reconciliation_counter==array.length){
            return array;
        }
        else{
            Armor [] newam = null;
            int k=0;
            for (com.example.lab7.Armor Armor : Armors) {
                for (Armor ams : array) {
                    if (Armor.getClass().equals(ams.getClass())){
                        newam[k]=(Armor)Armor;
                    }
                }
            }
            return newam;
        }
    }
}
