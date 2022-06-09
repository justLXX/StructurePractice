package 数据结构.数组;

public interface List<E> {
    int size();
    void add(E e);
    E remove(int index);
    void clear();
    boolean isEmpty();
    int indexOf(E e);
    E get(int index);
}
