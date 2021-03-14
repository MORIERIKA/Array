package com.company;

public class Array<E> {
    private int capacity;
    private int size;
    private E [] data;

    public Array(int capacity){
        this.capacity=capacity;
        data= (E[]) new Object[capacity];
        size=0;
    }

    public Array(){
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public E[] getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("data :");
        for (int i=0;i<size;i++){
            res.append(data[i]+" ");
        }
        return res.toString();
    }

    //向数组中的某个位置添加元素e
    public void addElement(int index, E e){
        if (index<0||index>data.length-1){
            throw new IllegalArgumentException("wrong index;");
        }
        if (size== getCapacity()){
            resize(2*getCapacity());
        }
        for (int i=size;i>index;i--){
            data[i]=data[i-1];
        }
        data[index]=e;
        size++;
    }

    //向数组头添加元素e
    public void addFirst(E e){
        addElement(0,e);
    }

    //向数组末尾添加元素e
    public void addLast(E e){
        addElement(data.length-1,e);
    }

    //替换数组index处元素为e
    public void setElement(int index,E e){
        if (index<0||index>data.length-1){
            throw new IllegalArgumentException("wrong index;");
        }
        data[index]=e;
    }

    //替换数组第一个元素为e
    public void setFirst(E e){
        setElement(0,e);
    }

    //替换数组第二个元素为e
    public void setLast(E e){
        setElement(size-1,e);
    }

    //数组中是否包含元素e
    public boolean contain(E e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //搜索数组中元素e的位置
    public int lookForElement(E e){
        if (contain(e)){
            for (int i=0;i<size;i++){
                if (data[i].equals(e)){
                    return i;
                }
            }
        }
        return -1;
    }

    //删除数组中index处的元素
    public E remove(int index){
        if (index<0||index>data.length-1){
            throw new IllegalArgumentException("wrong index;");
        }
        E re=data[index];
        for (int i=index;i<size-1;i++){
            data[i]=data[i+1];
        }
        size--;
        if (size<=data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        return re;
    }

    //改变数组容积
    public void resize(int newCapacity){
        E[] newdata= (E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newdata[i]=data[i];
        }
        data=newdata;
    }
}
