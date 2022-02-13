package 数据结构.链表;

import 数据结构.数组.List;
/// visualgo.net/zh
public class LinkedList<E> implements List<E> {

    private int size;

    private Node<E> first;

    public LinkedList(Node<E> first) {
        this.first = first;
    }

    @Override
    public int size() {
        return size;
    }

    public void add(E e, int index) {
        Node<E> current = new Node<E>(e);

        if (index == 0) {
            current.next = first;
            first = current;
        } else {
            Node<E> prev = node(index - 1);
            Node<E> next = prev.next;
            current.next = next;
            prev.next = current;
        }
        size++;
    }

    @Override
    public void add(E e) {
        Node<E> node = new Node<E>(e);
        Node<E> current = node(size);
        current.next = node;
        size++;
    }

    private Node<E> node(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        E value = first.element;

        return 0;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    private static class Node<E> {
        Node<E> next;
        E element;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node next) {
            this.next = next;
            this.element = element;
        }
    }
}
